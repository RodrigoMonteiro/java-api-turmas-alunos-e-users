package com.atividade05.apirest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade05.apirest.Model.Aluno;
import com.atividade05.apirest.Repository.AlunoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value= "API REST de alunos")
@CrossOrigin(origins="*")
public class AlunoController {
	@Autowired
	AlunoRepository alunoRepository;

	@GetMapping(value = "/alunos")
	@ApiOperation(value ="Retorna um lista com todos os alunos cadastrados.")
	public List<Aluno> listaAlunos() {
		return alunoRepository.findAll();
	}

	@GetMapping(value = "/alunos/{id}")
	@ApiOperation(value ="Retorna um aluno com o id passado por parâmetro.")
	public Optional<Aluno> alunoById(@PathVariable(value = "id") Integer id) {
		return alunoRepository.findById(id);
	}

	@PostMapping(value = "/alunos")
	@ApiOperation(value ="Adiciona um aluno a lista de alunos cadastrados.")
	public Aluno adicionarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@DeleteMapping(value = "/alunos/{id}")
	@ApiOperation(value ="Deleta o aluno que teve o id passado por parâmetro.")
	public void removerAluno(@PathVariable(value = "id") Integer id) {
		alunoRepository.deleteById(id);
	}

	@PutMapping(value = "/alunos/{id}")
	@ApiOperation(value ="Edita o aluno que teve o id passado por parâmetro.")
	public void atualizarAluno(@PathVariable(value = "id") Integer id, @RequestBody Aluno aluno) {
		List<Aluno> listaAlunos = alunoRepository.findAll();
		for (Aluno a : listaAlunos) {
			if (a.getIdAluno() == id) {
				a.setNomeAluno(aluno.getNomeAluno());
				alunoRepository.save(a);
			}
		}
	}

}
