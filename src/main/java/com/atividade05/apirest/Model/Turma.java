package com.atividade05.apirest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_TURMAS")
@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTurma;
	@Column(name = "Nome_Turma")
	private String nomeTurma;

	public Turma() {
	}

	public Turma(String nome, Integer id) {

		this.nomeTurma = nome;
		this.idTurma = id;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nome) {
		this.nomeTurma = nome;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer id) {
		this.idTurma = id;
	}

}
