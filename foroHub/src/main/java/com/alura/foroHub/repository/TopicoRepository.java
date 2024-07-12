package com.alura.foroHub.repository;

import com.alura.foroHub.entidades.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
    boolean existsByTitulo(String titulo);

   boolean existsByMensaje(String mensaje);


        // Page<Topico> findByActivoTrue(Pageable paginacion);






}
