package com.example.pismquest.api.model.entity;

import com.example.pismquest.api.model.enums.Dificuldade;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Trilha {
    
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Dificuldade dificuldade;

    @ManyToOne
    private Disciplina disciplinas;

    @OneToMany(mappedBy = "trilha")
    private List<Licao> licao;
}
