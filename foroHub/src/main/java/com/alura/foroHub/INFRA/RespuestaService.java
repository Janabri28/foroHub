package com.alura.foroHub.INFRA;

import com.alura.foroHub.repository.AutorRepository;
import com.alura.foroHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AutorRepository autorRepository;

/*
        public Respuesta verificandoRespuesta(DatosActualizarTopico datosActualizarTopico){


        Optional<Autor> verificaId=autorRepository.findById(datosActualizarTopico.respondeID());

        if(!(verificaId.isPresent())){
            System.out.println("No se encuentra ese id");
        }
            Autor autor=autorRepository.findById(datosActualizarTopico.respondeID()).get();



        Optional<Topico> verificaIdT=topicoRepository.findById(datosActualizarTopico.idTopico());


        if(!(verificaIdT.isPresent())){
            System.out.println("No se encuentra ese id");
        }
          Topico topico=topicoRepository.findById(datosActualizarTopico.idTopico()).get();

            List<Respuesta> respuestas = new ArrayList<>(); //crear lista

        Respuesta crearRespuesta=new Respuesta(null, datosActualizarTopico.mensaje(), new Date(),
               "false",autor,topico);

           crearRespuesta.setTopico(topico);
            respuestas.add(crearRespuesta);
            topico.setRespuesta(respuestas);

         //   topicoRepository.save(topico);     //salva topico (se hace en otro punto)
        //    respuestaRepository.save(crearRespuesta);   // salva respuesta (se hace en otro punto)

            return crearRespuesta;

    }

 */

}
