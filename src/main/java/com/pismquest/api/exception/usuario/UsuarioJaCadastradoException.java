package com.pismquest.api.exception.usuario;

import com.pismquest.api.exception.ApiException;
import org.springframework.http.HttpStatus;

public class UsuarioJaCadastradoException extends ApiException {
    public UsuarioJaCadastradoException(String message) {
        super(message, HttpStatus.CONFLICT);
    }

    public UsuarioJaCadastradoException() {
        this("Email já cadastrado.");
    }
}