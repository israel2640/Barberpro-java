package br.com.barberpro.api.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "barbeiros")
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
}
