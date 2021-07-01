package com.locadora.locadora.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table (name = Cliente.TABLE_NAME)
public class Cliente implements Serializable {
	static final String TABLE_NAME="cliente";
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cpf;
	private String nascimento;
	private String telefone;
	private String email;
}
