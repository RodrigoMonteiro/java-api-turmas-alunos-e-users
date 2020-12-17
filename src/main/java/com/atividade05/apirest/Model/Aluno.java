package com.atividade05.apirest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ALUNOS")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAluno;

	@Column(name = "Nome_Aluno")
	private String nomeAluno;

	public Aluno() {
		super();
	}

	public Aluno(String nomeAluno) {
		super();
		this.nomeAluno = nomeAluno;
	}

	public Aluno(String nomeAluno, Integer idAluno) {
		super();
		this.nomeAluno = nomeAluno;
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

}
