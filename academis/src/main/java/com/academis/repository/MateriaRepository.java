package com.academis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.academis.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer>{

}
