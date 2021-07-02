package com.vidapet.clinivet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;

	@NotBlank(message = "O campo raca é obrigatório")
	private String raca;

	@NotBlank(message = "O campo pelagem é obrigatório")
	private String pelagem;
	
	@NotNull(message = "o campo peso não pode ser nullo")
	@Min(value= 1, message = "O campo peso deve ser maior ou igual a 1")
	private Integer peso;

	@NotNull(message = "o campo tipo não pode ser nullo")
	@Min(value=1,message = "O campo tipo deve ser maior ou igual a 1")
	private Integer tipo;
	
	@NotNull(message = "o campo estado não pode ser nullo")
	@Min(value=1, message = "O campo estado deve ser maior ou igual a 1")
	private Integer estado;

	@NotBlank(message = "O campo campo data Nascimento é obrigatório")
	private String dataNascimento;

	@NotBlank(message = "O campo data cadastro é obrigatório")
	private String dataCadastro;

	@OneToMany(mappedBy = "animalExame")
	@JsonManagedReference
	private List<Exame> exame = new ArrayList<Exame>();

	@OneToMany(mappedBy = "animalConsulta")
	@JsonManagedReference
	private List<Consulta> consulta = new ArrayList<Consulta>();
	
	public Animal() {
		super();
	}

	public Animal(Long id, @NotBlank(message = "O campo nome é obrigatório") String nome,
			@NotBlank(message = "O campo raca é obrigatório") String raca,
			@NotBlank(message = "O campo pelagem é obrigatório") String pelagem,
			@NotNull(message = "o campo peso não pode ser nullo") @Min(value = 1, message = "O campo peso é obrigatório") Integer peso,
			@NotNull(message = "o campo tipo não pode ser nullo") @Min(value = 1, message = "O campo tipo é obrigatório") Integer tipo,
			@NotNull(message = "o campo estado não pode ser nullo") @Min(value = 1, message = "O campo estado é obrigatório") Integer estado,
			@NotBlank(message = "O campo campo data Nascimento é obrigatório") String dataNascimento,
			@NotBlank(message = "O campo data cadastro é obrigatório") String dataCadastro, List<Exame> exame,
			List<Consulta> consulta) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.pelagem = pelagem;
		this.peso = peso;
		this.tipo = tipo;
		this.estado = estado;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.exame = exame;
		this.consulta = consulta;
	}

	

	
	

}
