package com.example.pismquest.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevisaoEspacada {
    
    @Id
    @GeneratedValue
    private Long id;

    private Integer contadorQuestoes;
    private LocalDateTime dataProximaRevisao;

    @ManyToMany
    private List<Questao> questoes;

    @OneToOne
    private Aluno aluno;
}
