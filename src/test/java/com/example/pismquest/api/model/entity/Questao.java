package com.example.pismquest.api.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questao {
    
    @Id
    @GeneratedValue
    private Long id;

    private String enunciado;
    private enum alternativas {
        A, B, C, D, E
    }
    private char respostaCorreta;
    private enum dificuldade {
        FÁCIL, MÉDIO, DIFÍCIL
    } 
    private String explicacao;

    @ManyToOne
    private Licao licao;

    @ManyToMany(mappedBy =  "questoes")
    private List<RevisaoEspacada> RevisaoEspacada;
}
