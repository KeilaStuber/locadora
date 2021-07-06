package com.locadora.locadora.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table (name = Categoria.TABLE_NAME)

public class Categoria {
    static final String TABLE_NAME="categoria";
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String preco;
    @Enumerated(value = EnumType.STRING)private TipoCategoria categoria;

}