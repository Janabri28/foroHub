package com.alura.foroHub.INFRA;

import com.alura.foroHub.DTO.DatosActualizarTopico;
import com.alura.foroHub.DTO.DatosListadoTopicos;
import com.alura.foroHub.DTO.DatosTopico;
import com.alura.foroHub.INFRA.errores.ValidationDatos;
import com.alura.foroHub.entidades.Autor;
import com.alura.foroHub.entidades.Curso;
import com.alura.foroHub.entidades.Respuesta;
import com.alura.foroHub.entidades.Topico;
import com.alura.foroHub.repository.AutorRepository;
import com.alura.foroHub.repository.CursoRepository;
import com.alura.foroHub.repository.RespuestaRepository;
import com.alura.foroHub.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private DatosTopico datosTopico;
   // private LocalDateTime fechaCreacion;

    private DatosListadoTopicos datosListadoTopicos;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosListadoTopicos obtenerPorId(Long id) {
        Optional<Topico> topico= topicoRepository.findById(id);
        if(topico.isPresent()){
            Topico t = topico.get();
            return new DatosListadoTopicos(t.getIdTopico(), t.getTitulo(), t.getFechaCreacion(), t.getMensaje(),t.getAutor().getNombre());
        }
        return null;
    }


    public Topico vaciarDatos(DatosTopico datosTopico){ //Recordar que DatosTopico es un DTO que,

        if(!autorRepository.findById(datosTopico.idAutor()).isPresent()){
            throw new ValidationDatos("No se encontró este id para autor");
        }

        Autor autor=autorRepository.findById(datosTopico.idAutor()).get();

        var tituloRepetido = topicoRepository.existsByTitulo(datosTopico.titulo());


        if(tituloRepetido){
            throw new ValidationDatos("el titulo ya existe en Tópicos, elija otro");
        }

        var mensajeRepetido = topicoRepository.existsByMensaje(datosTopico.mensaje());

        if(mensajeRepetido){
            throw new ValidationDatos("ese mensaje ya existe en Tópicos, elija otro");
        }


        Curso datosCurso= cursoRepository.findByName(datosTopico.nombreCurso());
        System.out.println(datosCurso);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fechaComoCadena = sdf.format(new Date());

        List<Respuesta> respuestas = new ArrayList<>(); //crear lista
        Topico creandoTopico;
        creandoTopico = new Topico(null, datosTopico.titulo(), datosTopico.mensaje(), fechaComoCadena, true,datosCurso,autor,respuestas);
        return creandoTopico;

    }


    }



