package com.atividade05.apirest.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade05.apirest.Model.Aluno;
import com.atividade05.apirest.Repository.AlunoRepository;
@Service	
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;

	public String pegarNomeporId(Integer id) {
	Optional<Aluno> aluno = alunoRepository.findById(id);	
		return aluno.get().getNomeAluno();
	}
}
