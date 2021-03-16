package com.academis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public int getSerie() {
			return serie;
		}
		public void setSerie(int serie) {
			this.serie = serie;
		}
		public char getLetra() {
			return letra;
		}
		public void setLetra(char letra) {
			this.letra = letra;
		}
		public int getAno() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
		}
		private int codigo;
		private int serie;
		private char letra;
		private int ano;
}
