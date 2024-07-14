package com.alura.foroHub.INFRA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.alura.foroHub.repository.AutorRepository;


@Service
public class AutenticacionService implements UserDetailsService{

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //checar esta instruccion por la anotacion
        return autorRepository.findByEmail(username);
    }
}
