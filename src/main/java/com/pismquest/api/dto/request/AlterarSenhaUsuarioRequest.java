package com.pismquest.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaUsuarioRequest(
    @NotBlank String novaSenha
) {}