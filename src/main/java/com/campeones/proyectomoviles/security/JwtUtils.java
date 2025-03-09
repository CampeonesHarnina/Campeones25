package com.campeones.proyectomoviles.security;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

	@Value("${jwt.secret.key}")
	private String secretKey;

	@Value("${jwt.time.expiration}")
	private String timeExpiration;

	public String generateAccessToken(String username) {
		return Jwts.builder().issuedAt(Date.valueOf(LocalDateTime.now().toLocalDate())).subject(username)
				.expiration(Date.from(LocalDateTime.now().plusMinutes(Long.parseLong(timeExpiration))
						.atZone(ZoneId.systemDefault()).toInstant()))
				.signWith(getSignatureKey()).compact();
	}

	public String generateRefreshToken(User user) {
		return Jwts.builder().subject(user.getUsername()).issuedAt(Date.valueOf(LocalDateTime.now().toLocalDate()))
				.expiration(Date.from(LocalDateTime.now().plusDays(7).atZone(ZoneId.systemDefault()).toInstant()))
				.signWith(getSignatureKey()).compact();
	}

	public Boolean isTokenValid(String token) {
		try {
			getAllClaims(token);
			return true;
		} catch (Exception e) {
			log.error("JwtUtils: Token inválido: " + e.getMessage());
			return false;
		}
	}

	public String getEmailFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	public SecretKey getSignatureKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey); // Asume que la clave está en Base64
		if (keyBytes.length < 32) {
			throw new IllegalArgumentException("La clave secreta debe tener al menos 256 bits (32 bytes)");
		}
		return Keys.hmacShaKeyFor(keyBytes);
	}

	private Claims getAllClaims(String token) {
		return Jwts.parser().verifyWith(getSignatureKey()).build().parseSignedClaims(token).getPayload();
	}

	private <T> T getClaim(String token, Function<Claims, T> claimsFunction) {
		Claims allClaims = getAllClaims(token);
		return claimsFunction.apply(allClaims);
	}
}