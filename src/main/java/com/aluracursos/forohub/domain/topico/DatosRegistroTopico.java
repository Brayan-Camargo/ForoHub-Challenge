package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank(message = "El titulo es obligatorio")
        String titulo,

        @NotBlank(message = "El mensaje no puede estar vacio")
        String mensaje,

        @NotBlank(message = "El autor es necesario")
        String autor,

        @NotBlank(message = "El curso debe especificarse")
        String curso
) {
}
