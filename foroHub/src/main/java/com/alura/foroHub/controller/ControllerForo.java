package com.alura.foroHub.controller;

import com.alura.foroHub.DTO.DatosActualizarTopico;
import com.alura.foroHub.DTO.DatosListadoTopicos;
import com.alura.foroHub.DTO.DatosRespuestaTopico;
import com.alura.foroHub.DTO.DatosTopico;
import com.alura.foroHub.INFRA.RespuestaService;
import com.alura.foroHub.INFRA.TopicoService;
import com.alura.foroHub.entidades.Respuesta;
import com.alura.foroHub.entidades.Topico;
import com.alura.foroHub.repository.RespuestaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.alura.foroHub.repository.TopicoRepository;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class ControllerForo {

    @Autowired
    private TopicoRepository  topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private RespuestaService respuestaService;

    @Autowired
    private RespuestaRepository respuestaRepository;


    @PostMapping
        public ResponseEntity <DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder)
        {
            Topico topico= topicoRepository.save(new Topico((topicoService.vaciarDatos(datosTopico))));
            DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getIdTopico(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                    topico.isStatus());
            URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getIdTopico()).toUri();
            return ResponseEntity.created(url).body(datosRespuestaTopico);
        }


    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(size=5) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopicos> obtenerPorId(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        var datosTopico= new DatosListadoTopicos(topico.getIdTopico(),topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),topico.getAutor().getNombre().toString());
        return ResponseEntity.ok(datosTopico);
    }

    /*
    @DeleteMapping("/{id}")
    @Transactional
    public void desactivarTopico(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }

*/
    @DeleteMapping("/{id}")
     @Transactional
     public ResponseEntity BorradoTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build(); //Devolver respuesta 204
    }



    @PutMapping
    @Transactional
    public ResponseEntity actualizaTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico=topicoRepository.getReferenceById(datosActualizarTopico.idTopico());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getIdTopico(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.isStatus()));
    }


}



