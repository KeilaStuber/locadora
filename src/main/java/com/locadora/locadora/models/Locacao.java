package com.locadora.locadora.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter

@Table (name = Locacao.TABLE_NAME)
public class Locacao {
    static final String TABLE_NAME="locacao";
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String cliente;
    private String categoria;
    private String carro;
    private String valor;
    private String dataini;
    private String datafim;


}
