package com.pismquest.api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public boolean login(String email, String senha) {
        return this.email != null
            && this.senha != null
            && this.email.equals(email)
            && this.senha.equals(senha);
    }

    public static Usuario cadastro(String nome, String email, String senha) {
        return new Usuario(nome, email, senha);
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }
}