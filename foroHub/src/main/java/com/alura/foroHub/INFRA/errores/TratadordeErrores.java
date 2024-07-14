package com.alura.foroHub.INFRA.errores;

import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadordeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404() {         //retornar una respuesta 404 Not Found.
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {         //Tratando un BadRequest o datos faltantes en un formulario
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }


    private record DatosErrorValidacion(String campo,String error){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }


    @ExceptionHandler(ValidacionIntegridad.class)
    public ResponseEntity tratarError403(ValidacionIntegridad e) {
       var errores = e.getMessage();
        return ResponseEntity.badRequest().body(errores);
    }


    @ExceptionHandler( TokenExpiredException.class)
    public ResponseEntity expiroToken( TokenExpiredException e) {
        var errores = e.getMessage();
        return ResponseEntity.badRequest().body(errores);
    }


}
