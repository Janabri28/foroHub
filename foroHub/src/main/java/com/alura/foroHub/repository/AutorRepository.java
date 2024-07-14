package com.alura.foroHub.repository;

import com.alura.foroHub.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    UserDetails findByEmail(String email);
}
