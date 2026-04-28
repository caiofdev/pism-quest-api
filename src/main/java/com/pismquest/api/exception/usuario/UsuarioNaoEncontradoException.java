package com.pismquest.api.exception.usuario;

import com.pismquest.api.exception.ApiException;
import org.springframework.http.HttpStatus;

public class UsuarioNaoEncontradoException extends ApiException {
    public UsuarioNaoEncontradoException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public UsuarioNaoEncontradoException() {
        this("Usuário não encontrado.");
    }
}