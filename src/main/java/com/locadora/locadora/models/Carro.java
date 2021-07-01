package com.locadora.locadora.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table (name = Carro.TABLE_NAME)
public class Carro {
    static final String TABLE_NAME="carro";
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String marca;
    private String categoria;
    private String ano;
}
