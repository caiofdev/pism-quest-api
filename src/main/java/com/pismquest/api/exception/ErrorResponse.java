package com.pismquest.api.exception;

import org.springframework.http.HttpStatus;
import java.time.Instant;
import java.util.List;

public record ErrorResponse(int status, String mensagem, String timestamp, String path, List<String> errors) {
    public static ErrorResponse of(HttpStatus status, String mensagem, String path, List<String> errors) {
        return new ErrorResponse(status.value(), mensagem, Instant.now().toString(), path, errors);
    }
}