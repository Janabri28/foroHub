package com.alura.foroHub.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosActualizarTopico(  //RESPUESTA
                                      @NotNull
                                       Long idTopico,
       boolean status,

        String titulo,

        String mensaje

) {
}
