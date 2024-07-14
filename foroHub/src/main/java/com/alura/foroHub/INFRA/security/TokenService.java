package com.alura.foroHub.INFRA.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.alura.foroHub.entidades.Autor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;


    public String generarToken(Autor usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return  JWT.create()
                    .withIssuer("forohub")  //checar aqui
                    .withSubject(usuario.getEmail())
                 //   .withClaim("idAutor",usuario.getIdAutor()) //la aplicación cliente conozca el id de usuario
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("error al generar token jwt", exception);
        }

    }


    public String getSubject(String token) {
        if(token==null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {

            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("forohub")   // Aqui se cambia por nuestra api
                    .build()
                    .verify(token);
            verifier.getSubject();

        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if(verifier.getSubject()==null){
            throw new RuntimeException("Verifier invalido");
        }

        return verifier.getSubject();
    }


    private Instant generarFechaExpiracion(){ //hacemos que el token tenga 4 horas de expiracion y con el horario
        return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-05:00")); //de Sudamerica.

    }

}

