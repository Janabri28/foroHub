package com.alura.foroHub.repository;

import com.alura.foroHub.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}