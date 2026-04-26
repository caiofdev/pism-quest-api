package com.pismquest.api.dto.response;

import java.time.LocalDate;

public record UsuarioResponse(
    Integer id,
    String nome,
    String email,
    LocalDate dataCriacao
) {}