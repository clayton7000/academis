package com.academis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Turma {
		@Id
		private int codigo;
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
		public String getAluno() {
			return aluno;
		}
		public void setAluno(String aluno) {
			this.aluno = aluno;
		}
		public int getAno() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
		}
		private int serie;
		private char letra;
		private String aluno;
		private int ano;
}
