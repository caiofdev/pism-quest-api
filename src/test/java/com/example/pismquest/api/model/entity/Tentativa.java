package com.example.pismquest.api.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tentativa {
    
    @Id
    @GeneratedValue
    private Long id;

    private String respostaDada;
    private Boolean resultado;
    private Integer xpObtido;
    private Integer penalidade;
    private LocalDate dataTentativa;
    
    @ManyToOne
    private Questao questao;

    @ManyToOne
    private Aluno aluno;
}
