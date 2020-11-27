package com.atividade05.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade05.apirest.Model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
