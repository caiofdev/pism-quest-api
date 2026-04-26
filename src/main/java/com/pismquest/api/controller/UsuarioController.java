package com.pismquest.api.controller;

import com.pismquest.api.dto.request.AlterarSenhaUsuarioRequest;
import com.pismquest.api.dto.request.CadastroUsuarioRequest;
import com.pismquest.api.dto.request.LoginUsuarioRequest;
import com.pismquest.api.dto.response.UsuarioResponse;
import com.pismquest.api.mapper.UsuarioMapper;
import com.pismquest.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse cadastrar(@Valid @RequestBody CadastroUsuarioRequest request) {
        return usuarioMapper.toResponse(
            usuarioService.cadastro(request.nome(), request.email(), request.senha())
        );
    }

    @PostMapping("/login")
    public boolean login(@Valid @RequestBody LoginUsuarioRequest request) {
        return usuarioService.login(request.email(), request.senha());
    }

    @PatchMapping("/{id}/senha")
    public UsuarioResponse alterarSenha(@PathVariable int id, @Valid @RequestBody AlterarSenhaUsuarioRequest request) {
        return usuarioMapper.toResponse(
            usuarioService.alterarSenha(id, request.novaSenha())
        );
    }
}