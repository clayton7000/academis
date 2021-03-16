package com.academis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academis.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
