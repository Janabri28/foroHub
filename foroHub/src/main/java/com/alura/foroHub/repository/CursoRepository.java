package com.alura.foroHub.repository;

import com.alura.foroHub.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByName(String nombreCurso);
}
