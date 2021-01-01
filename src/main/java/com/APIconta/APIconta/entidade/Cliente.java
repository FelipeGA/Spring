package com.APIconta.APIconta.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE_TBL")
public class Cliente {
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String email;
	private String CPF;
	private String dataNascimento;
}
