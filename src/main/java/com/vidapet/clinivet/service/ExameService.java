package com.vidapet.clinivet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidapet.clinivet.entities.Exame;
import com.vidapet.clinivet.repository.ExameRepository;
import com.vidapet.clinivet.service.exception.ObjectNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repository;

	public Exame findById(Long id) {
		Optional<Exame> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Exame.class.getName()));
	}
	
	public List<Exame> findAll() {
		return repository.findAll();
	}
	
	public Exame insert (Exame obj) { 
		return repository.save(obj);
	}

	public Exame update(Long id, Exame exame) {
		Exame obj = findById(id);
		obj.setCalcio(exame.getCalcio());
		obj.setColesterol(exame.getColesterol());
		obj.setData(exame.getData());
		obj.setFosforo(exame.getFosforo());
		obj.setGlicose(exame.getGlicose());
		obj.setHemograma(exame.getHemograma());
		obj.setMagnesio(exame.getMagnesio());
		obj.setPotassio(exame.getPotassio());
		obj.setRadiografia(exame.getRadiografia());
		obj.setUltrassonografia(exame.getUltrassonografia());
		obj.setUreia(exame.getUreia());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
