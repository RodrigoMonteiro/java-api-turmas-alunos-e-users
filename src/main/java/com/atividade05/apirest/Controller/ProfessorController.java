package com.atividade05.apirest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade05.apirest.Model.Professor;
import com.atividade05.apirest.Repository.ProfessorRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class ProfessorController {

	@Autowired
	ProfessorRepository professorRepository;

	@GetMapping(value = "/professores")
	@ApiOperation(value = "Retorna um lista com todos os professores cadastrados.")
	public List<Professor> listaProfessor() {
		return professorRepository.findAll();
	}

	@GetMapping(value = "/professores/{id}")
	@ApiOperation(value = "Retorna o professor que teve o id passado por parâmetro.")
	public Optional<Professor> professorById(@PathVariable(value = "id") Integer id) {
		return professorRepository.findById(id);

	}

	@PostMapping(value = "/professores")
	@ApiOperation(value = "Adiciona o um novo professor a lista de professores caastrados.")
	public void adicionarProfessor(@RequestBody Professor professor) {
		professorRepository.save(professor);
	}

	@PutMapping(value = "/professores/{id}")
	@ApiOperation(value = "Altera dados do aluno que teve o id passado por parâmetro.")
	public void alterarProfessor(@PathVariable(value = "id") Integer id, @RequestBody Professor professor) {
		List<Professor> professores = professorRepository.findAll();
		for (Professor p : professores) {
			if (p.getId() == id) {
				p.setNomeProfessor(professor.getNomeProfessor());
				p.setAtuacaoProfessor(professor.getAtuacaoProfessor());
				p.setFormacaoProfessor(professor.getFormacaoProfessor());
				professorRepository.save(p);
			}
		}

	}

	@DeleteMapping(value = "/professores/{id}")
	@ApiOperation(value="Deleta o professor que teve o id passado por parâmetro.")
	public void deletarProfessor(@PathVariable(value = "id") Integer id) {
		professorRepository.deleteById(id);
	}

}
