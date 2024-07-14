package com.alura.foroHub.DTO;

import com.alura.foroHub.entidades.Autor;
import com.alura.foroHub.entidades.Curso;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        boolean status

) {
}
