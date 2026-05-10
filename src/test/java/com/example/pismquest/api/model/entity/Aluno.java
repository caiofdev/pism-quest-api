package com.example.pismquest.api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Usuario {
    
    private Integer xpTotal;
    private Integer nivelAtual;
    private Integer streakAtual;

    @OneToOne(mappedBy =  "aluno")
    private RevisaoEspacada revisaoEspacada;

    @OneToOne(mappedBy =  "aluno")
    private Historico historico;

    @OneToOne(mappedBy =  "aluno")
    private Tentativa tentativa;
}
