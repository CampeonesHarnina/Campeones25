package com.campeones.proyectomoviles.model.DTO;

import jakarta.validation.constraints.Pattern;

public record LoginRequestDTO(@Pattern(regexp = "^[a-zA-Z0-9@.,\\sáéíóúÁÉÍÓÚñÑ]*$") String email,
		@Pattern(regexp = "^[a-zA-Z0-9_@#%$€&!?¿¡'/*.,\\sáéíóúÁÉÍÓÚñÑ]*$") String password) {
}
