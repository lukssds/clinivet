package com.vidapet.clinivet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidapet.clinivet.entities.Doencas;
import com.vidapet.clinivet.repository.DoencasRepository;
import com.vidapet.clinivet.service.exception.ObjectNotFoundException;

@Service
public class DoencasService {

	@Autowired
	private DoencasRepository repository;

	public Doencas findById(Long id) {
		Optional<Doencas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Doencas.class.getName()));
	}
	
	public List<Doencas> findAll() {
		return repository.findAll();
	}
	
	public Doencas insert (Doencas obj) { 
		return repository.save(obj);
	}

	public Doencas update(Long id, Doencas Doencas) {
		Doencas obj = findById(id);
		obj.setNome(Doencas.getNome());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
