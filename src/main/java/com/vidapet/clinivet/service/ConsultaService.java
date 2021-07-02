package com.vidapet.clinivet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidapet.clinivet.entities.Consulta;
import com.vidapet.clinivet.repository.ConsultaRepository;
import com.vidapet.clinivet.service.exception.ObjectNotFoundException;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	public Consulta findById(Long id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Consulta.class.getName()));
	}
	
	public List<Consulta> findAll() {
		return repository.findAll();
	}
	
	public Consulta insert (Consulta obj) { 
		return repository.save(obj);
	}

	public Consulta update(Long id, Consulta consulta) {
		Consulta obj = findById(id);
		obj.setData(consulta.getData());
		obj.setHistorico(consulta.getHistorico());
		obj.setObservacoes(consulta.getObservacoes());
		obj.setQueixa(consulta.getQueixa());
		obj.setAnamnese(consulta.getAnamnese());
		obj.setAnimalConsulta(consulta.getAnimalConsulta());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
