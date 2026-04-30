package com.pismquest.api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(nullable = false, length = 120)
    @Setter
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    @Setter
    private String email;

    @Column(nullable = false, length = 255)
    @Setter
    private String senha;

    @Column(name = "data_criacao", nullable = false)
    @Setter(AccessLevel.NONE)
    private LocalDate dataCriacao;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = LocalDate.now();
    }
}