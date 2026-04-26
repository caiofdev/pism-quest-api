package com.pismquest.api.mapper;

import com.pismquest.api.dto.response.UsuarioResponse;
import com.pismquest.api.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getDataCriacao()
        );
    }
}