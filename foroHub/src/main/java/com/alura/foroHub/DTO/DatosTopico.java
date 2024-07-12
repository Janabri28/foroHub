package com.alura.foroHub.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico (

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        String nombreCurso,

        @NotNull
        Long idAutor

)

{}
