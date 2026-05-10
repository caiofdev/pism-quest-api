package com.example.pismquest.api.model.entity;

import com.example.pismquest.api.model.enums.Status;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Licao {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private Status status;
    private Double percentualConclusao;

    @ManyToOne
    private Trilha trilha;

    @OneToMany(mappedBy = "licao")
    private List<Questao> questao;
}
