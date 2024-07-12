package com.alura.foroHub.INFRA.errores;

public class ValidationDatos extends RuntimeException {
    public ValidationDatos(String s) {  //se debe marcar una excepción con mensaje de error.
        super(s);
    }

}
