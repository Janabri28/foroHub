package com.alura.foroHub.controller;

import com.alura.foroHub.DTO.DatosActualizarTopico;
import com.alura.foroHub.DTO.DatosListadoTopicos;
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
import org.springframework.web.bind.annotation.*;


import com.alura.foroHub.repository.TopicoRepository;


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
        public void  registrarTopico(@RequestBody @Valid DatosTopico datosTopico)
        {
            System.out.println(topicoService.vaciarDatos(datosTopico));
            topicoRepository.save(new Topico((topicoService.vaciarDatos(datosTopico))));
        }


    @GetMapping
    public Page<DatosListadoTopicos> listadoTopicos(@PageableDefault(size=5) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
    }


    @GetMapping("/{id}")
    public DatosListadoTopicos obtenerPorId(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        return topicoService.obtenerPorId(id);
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
     public void BorradoTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }



    @PutMapping
    @Transactional //Cuando el metodo se termine de ejecutar se ejecuta a nivel base de datos. paso 20.
    public void actualizaTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico=topicoRepository.getReferenceById(datosActualizarTopico.idTopico());
        topico.actualizarDatos(datosActualizarTopico);
    }


}



