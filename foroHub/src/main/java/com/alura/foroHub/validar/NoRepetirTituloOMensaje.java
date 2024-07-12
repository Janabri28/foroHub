package com.alura.foroHub.validar;

import com.alura.foroHub.DTO.DatosTopico;
import com.alura.foroHub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public class NoRepetirTituloOMensaje {

    @Autowired
    private TopicoRepository repository;

    public void validar(DatosTopico datos) {
        var revisandoTitulo = datos.titulo();
        var revisandoMensaje = datos.mensaje();

        var tituloRepetido = repository.existsByTitulo(datos.titulo());
        var mensajeRepetido = repository.existsByMensaje(datos.mensaje());

        if (tituloRepetido) {
            throw new ValidationException("Ese titulo ya existe en tópicos, cámbielo");
        } else if (mensajeRepetido) {
            throw new ValidationException("Ese mensaje ya existe en tópicos, cámbielo");
        } else if (tituloRepetido && mensajeRepetido) {
            throw new ValidationException("Ese titulo y ese mensaje ya existe en tópicos, cámbielo");
        }

    }
}