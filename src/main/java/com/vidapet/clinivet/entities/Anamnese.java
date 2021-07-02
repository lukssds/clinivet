package com.vidapet.clinivet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Anamnese implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório")
	private String problemaSistemaDigestivo;

	@NotBlank(message = "O campo  problema Sistema uro Genital  é obrigatório")
	private String problemaSistemaUroGenital;

	@NotBlank(message = "O campo  problema Sistema cardiaco Respiratorio  é obrigatório")
	private String problemaSistemaCardiacoRespiratorio;

	@NotBlank(message = "O campo  problema Sistema Neurologico é obrigatório")
	private String problemaSistemaNeurologico;

	@NotBlank(message = "O campo  problema Sistema Locomotor  é obrigatório")
	private String problemaSistemaLocomotor;

	@NotBlank(message = "O campo problema Pele é obrigatório")
	private String problemaPele;

	@NotBlank(message = "O campo  problema Olhos  é obrigatório")
	private String problemaOlhos;

	@NotBlank(message = "O campo  problema Ouvido  é obrigatório")
	private String problemaOuvido;

	@ManyToMany
	private List<Doencas> doencas = new ArrayList<Doencas>();



	public Anamnese() {
		super();
	}

	public Anamnese(Long id,
			@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório") String problemaSistemaDigestivo,
			@NotBlank(message = "O campo  problema Sistema uro Genital  é obrigatório") String problemaSistemaUroGenital,
			@NotBlank(message = "O campo  problema Sistema cardiaco Respiratorio  é obrigatório") String problemaSistemaCardiacoRespiratorio,
			@NotBlank(message = "O campo  problema Sistema Neurologico é obrigatório") String problemaSistemaNeurologico,
			@NotBlank(message = "O campo  problema Sistema Locomotor  é obrigatório") String problemaSistemaLocomotor,
			@NotBlank(message = "O campo problema Pele é obrigatório") String problemaPele,
			@NotBlank(message = "O campo  problema Olhos  é obrigatório") String problemaOlhos,
			@NotBlank(message = "O campo  problema Ouvido  é obrigatório") String problemaOuvido,
			List<Doencas> doencas) {
		super();
		this.id = id;
		this.problemaSistemaDigestivo = problemaSistemaDigestivo;
		this.problemaSistemaUroGenital = problemaSistemaUroGenital;
		this.problemaSistemaCardiacoRespiratorio = problemaSistemaCardiacoRespiratorio;
		this.problemaSistemaNeurologico = problemaSistemaNeurologico;
		this.problemaSistemaLocomotor = problemaSistemaLocomotor;
		this.problemaPele = problemaPele;
		this.problemaOlhos = problemaOlhos;
		this.problemaOuvido = problemaOuvido;
		this.doencas = doencas;
	}

}
