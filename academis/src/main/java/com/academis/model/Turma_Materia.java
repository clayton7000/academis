package com.academis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma_Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int turma;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTurma() {
		return turma;
	}
	public void setTurma(int turma) {
		this.turma = turma;
	}
	public int getMateria() {
		return materia;
	}
	public void setMateria(int materia) {
		this.materia = materia;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	private int materia;
	private String professor;
}
