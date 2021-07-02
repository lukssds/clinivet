package com.vidapet.clinivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidapet.clinivet.entities.Exame;
import com.vidapet.clinivet.service.ExameService;

@RestController
@RequestMapping(value = "/exame")
public class ExameController {

	@Autowired
	private ExameService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Exame> findById(@PathVariable Long id) {
		Exame obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Exame>> findAll() {
		List<Exame> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Exame obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok("Exame cadastrada com sucesso");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Exame> update(@PathVariable Long id, @RequestBody Exame exame) {
		Exame obj = service.update(id, exame);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){ 
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
