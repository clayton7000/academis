package com.academis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academis.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer>{

}
