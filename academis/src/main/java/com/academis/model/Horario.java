package com.academis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dia;
	private String horaInicio;
	private String horaTerminio;
	private int turrma_materia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraTerminio() {
		return horaTerminio;
	}
	public void setHoraTerminio(String horaTerminio) {
		this.horaTerminio = horaTerminio;
	}
	public int getTurrma_materia() {
		return turrma_materia;
	}
	public void setTurrma_materia(int turrma_materia) {
		this.turrma_materia = turrma_materia;
	}
}
