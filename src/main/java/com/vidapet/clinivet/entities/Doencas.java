package com.vidapet.clinivet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Doencas implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	
	public Doencas() {
		super();
	}
	public Doencas(Long id, @NotBlank(message = "O campo nome é obrigatório") String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
}
