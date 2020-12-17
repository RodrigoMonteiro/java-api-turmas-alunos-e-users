package com.atividade05.apirest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="TB_PROFESSORES")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nome_Professor")
	private String nomeProfessor;
	
	@Column(name = "Atuacao_Professor")
	private String atuacaoProfessor;
	
	@Column(name="Formacao_Professor")
	private String formacaoProfessor;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getAtuacaoProfessor() {
		return atuacaoProfessor;
	}

	public void setAtuacaoProfessor(String atuacaoProfessor) {
		this.atuacaoProfessor = atuacaoProfessor;
	}

	public String getFormacaoProfessor() {
		return formacaoProfessor;
	}

	public void setFormacaoProfessor(String formacaoProfessor) {
		this.formacaoProfessor = formacaoProfessor;
	}

	public Professor() {
		super();
	}

	public Professor(Integer id, String nomeProfessor, String atuacaoProfessor, String formacaoProfessor) {
		super();
		this.id = id;
		this.nomeProfessor = nomeProfessor;
		this.atuacaoProfessor = atuacaoProfessor;
		this.formacaoProfessor = formacaoProfessor;
	}
	
	

}
