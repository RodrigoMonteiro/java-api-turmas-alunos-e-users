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

import com.atividade05.apirest.Model.Turma;
import com.atividade05.apirest.Repository.TurmaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value= "API REST de turmas")
@CrossOrigin(origins="*")
public class TurmaController {

	@Autowired
	TurmaRepository turmaRepository;

	@GetMapping(value = "/turmas")
	@ApiOperation(value ="Retorna a lista de todas as turmas cadastradas.")
	public List<Turma> listaTurmas() {
		return turmaRepository.findAll();
	}

	@GetMapping(value = "/turmas/{id}")
	@ApiOperation(value ="Retorna a turma que teve o id passado por parâmetro.")
	public Optional<Turma> TurmaById(@PathVariable(value = "id") Integer id) {
		return turmaRepository.findById(id);

	}

	@PostMapping(value = "/turmas")
	@ApiOperation(value ="Aiciona uma nova turma a lista de turmas caastradas.")
	public Turma adicionarTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);

	}

	@DeleteMapping(value = "/turmas/{id}")
	@ApiOperation(value ="Deleta a turma que teve o id passado por parâmetro.")
	public void removerTurma(@PathVariable(value = "id") Integer id) {
		turmaRepository.deleteById(id);
	}

	@PutMapping(value = "/turmas/{id}")
	@ApiOperation(value ="Edita a turma que teve o id passado por parâmetro.")
	public void updateTurma(@PathVariable(value = "id") Integer id, @RequestBody Turma turma) {

		List<Turma> turmas = turmaRepository.findAll();
		for (Turma t : turmas) {
			if (t.getIdTurma() == id) {
				t.setNomeTurma(turma.getNomeTurma());
				turmaRepository.save(t);
			}
		}
	}
}
