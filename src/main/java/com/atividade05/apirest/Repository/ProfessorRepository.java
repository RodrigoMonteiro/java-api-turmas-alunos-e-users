package com.atividade05.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade05.apirest.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
