package com.example.pismquest.api.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String descricao;

    @OneToMany(mappedBy = "disciplina")
    private List<Trilha> trilhas;
}
