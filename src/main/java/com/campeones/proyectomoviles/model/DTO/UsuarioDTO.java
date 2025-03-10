package com.campeones.proyectomoviles.model.DTO;

import jakarta.validation.constraints.Pattern;

public record UsuarioDTO(Long id, @Pattern(regexp = "^[a-zA-Z0-9'.\\sáéíóúÁÉÍÓÚñÑ]*$") String nombre,
		@Pattern(regexp = "^[a-zA-Z0-9_@#%$€&!?¿¡'/*.,\\sáéíóúÁÉÍÓÚñÑ]*$") String password,
		@Pattern(regexp = "^[a-zA-Z0-9@.,\\sáéíóúÁÉÍÓÚñÑ]*$") String email, boolean esAdmin) {
}
