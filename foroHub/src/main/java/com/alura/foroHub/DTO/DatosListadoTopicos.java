package com.alura.foroHub.DTO;

import com.alura.foroHub.entidades.Topico;

public record DatosListadoTopicos(
        Long Id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String nombre_autor

)

{

    public DatosListadoTopicos(Topico topico){
        this(topico.getIdTopico(),topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor().getNombre());

    }

}
