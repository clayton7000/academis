package com.academis.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chamada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int turma_materia;
	private String aluno;
	private Date dia;
	private boolean presente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTurma_materia() {
		return turma_materia;
	}
	public void setTurma_materia(int turma_materia) {
		this.turma_materia = turma_materia;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public boolean isPresente() {
		return presente;
	}
	public void setPresente(boolean presente) {
		this.presente = presente;
	}
}
