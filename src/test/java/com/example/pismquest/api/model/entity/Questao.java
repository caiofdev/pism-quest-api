package com.example.pismquest.api.model.entity;

import com.example.pismquest.api.model.enums.Dificuldade;
import com.example.pismquest.api.model.enums.Alternativas;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Enumerated(EnumType.STRING)
    private Alternativas alternativas;
    private Character respostaCorreta;
    @Enumerated(EnumType.STRING)
    private Dificuldade dificuldade;
    private String explicacao;

    @ManyToOne
    private Licao licao;

    @ManyToMany(mappedBy =  "questoes")
    private List<RevisaoEspacada> RevisaoEspacada;

    @OneToMany(mappedBy =  "questao")
    private List<Tentativa> tentativa; 
}
