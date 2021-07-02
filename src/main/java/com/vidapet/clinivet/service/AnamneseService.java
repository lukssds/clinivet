package com.vidapet.clinivet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidapet.clinivet.entities.Anamnese;
import com.vidapet.clinivet.repository.AnamneseRepository;
import com.vidapet.clinivet.service.exception.ObjectNotFoundException;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;

	public Anamnese findById(Long id) {
		Optional<Anamnese> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Anamnese.class.getName()));
	}
	
	public List<Anamnese> findAll() {
		return repository.findAll();
	}
	
	public Anamnese insert (Anamnese obj) { 
		return repository.save(obj);
	}

	public Anamnese update(Long id, Anamnese anamnese) {
		Anamnese obj = findById(id);
		obj.setProblemaOlhos(anamnese.getProblemaOlhos());
		obj.setProblemaOuvido(anamnese.getProblemaOuvido());
		obj.setProblemaPele(anamnese.getProblemaPele());
		obj.setProblemaSistemaCardiacoRespiratorio(anamnese.getProblemaSistemaCardiacoRespiratorio());
		obj.setProblemaSistemaDigestivo(anamnese.getProblemaSistemaDigestivo());
		obj.setProblemaSistemaLocomotor(anamnese.getProblemaSistemaLocomotor());
		obj.setProblemaSistemaNeurologico(anamnese.getProblemaSistemaNeurologico());
		obj.setProblemaSistemaUroGenital(anamnese.getProblemaSistemaUroGenital());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
