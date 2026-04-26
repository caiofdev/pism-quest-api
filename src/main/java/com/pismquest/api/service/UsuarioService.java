package com.pismquest.api.service;

import com.pismquest.api.entity.Usuario;
import com.pismquest.api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario cadastro(String nome, String email, String senha) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email ja cadastrado");
        }
        Usuario usuario = Usuario.cadastro(nome, email, senha);
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));
        return usuario.login(email, senha);
    }

    @Transactional
    public Usuario alterarSenha(int id, String novaSenha) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));
        usuario.alterarSenha(novaSenha);
        return usuarioRepository.save(usuario);
    }
}