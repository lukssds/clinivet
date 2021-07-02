package com.vidapet.clinivet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidapet.clinivet.entities.Animal;
import com.vidapet.clinivet.repository.AnimalRepository;
import com.vidapet.clinivet.service.exception.ObjectNotFoundException;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	public Animal findById(Long id) {
		Optional<Animal> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Animal.class.getName()));
	}
	
	public List<Animal> findAll() {
		return repository.findAll();
	}
	
	public Animal insert (Animal obj) { 
		return repository.save(obj);
	}

	public Animal update(Long id, Animal animal) {
		Animal obj = findById(id);
		obj.setDataCadastro(animal.getDataCadastro());
		obj.setDataNascimento(animal.getDataNascimento());
		obj.setEstado(animal.getEstado());
		obj.setExame(animal.getExame());
		obj.setConsulta(animal.getConsulta());
		obj.setNome(animal.getNome());
		obj.setPelagem(animal.getPelagem());
		obj.setPeso(animal.getPeso());
		obj.setRaca(animal.getRaca());
		obj.setTipo(animal.getTipo());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
