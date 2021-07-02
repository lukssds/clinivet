package com.vidapet.clinivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidapet.clinivet.entities.Animal;

public interface AnimalRepository  extends JpaRepository<Animal, Long>{

}
