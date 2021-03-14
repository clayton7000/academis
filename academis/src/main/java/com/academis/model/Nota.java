package com.academis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMateria() {
		return materia;
	}
	public void setMateria(int materia) {
		this.materia = materia;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getRecuperacao_1Semestre() {
		return recuperacao_1Semestre;
	}
	public void setRecuperacao_1Semestre(double recuperacao_1Semestre) {
		this.recuperacao_1Semestre = recuperacao_1Semestre;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getNota4() {
		return nota4;
	}
	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	public double getRecuperacao_2Semestre() {
		return recuperacao_2Semestre;
	}
	public void setRecuperacao_2Semestre(double recuperacao_2Semestre) {
		this.recuperacao_2Semestre = recuperacao_2Semestre;
	}
	public double getRecuperacao_Final() {
		return recuperacao_Final;
	}
	public void setRecuperacao_Final(double recuperacao_Final) {
		this.recuperacao_Final = recuperacao_Final;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	private int materia;
	private String aluno;
	private double nota1;
	private double nota2;
	private double recuperacao_1Semestre;
	private double nota3;
	private double nota4;
	private double recuperacao_2Semestre;
	private double recuperacao_Final;
	private double media;
}
