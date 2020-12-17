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

import com.atividade05.apirest.Model.Projeto;
import com.atividade05.apirest.Repository.ProjetoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProjetoController {

	@Autowired
	ProjetoRepository projetorepository;

	@GetMapping(value = "/projetos")
	public List<Projeto> listaProjetos() {
		return projetorepository.findAll();
	}

	@GetMapping(value = "/projetos/{id}")
	public Optional<Projeto> projetoById(@PathVariable(value = "id") Integer id) {
		return projetorepository.findById(id);
	}

	@PostMapping(value = "/projetos")
	public void adicionarProjeto(@RequestBody Projeto projeto) {
		projetorepository.save(projeto);
	}

	@DeleteMapping(value = "/projetos/{id}")
	public void deletarProjeto(@PathVariable(value = "id") Integer id) {
		projetorepository.deleteById(id);
	}
	@PutMapping(value= "/projetos/{id}")
	public void  alterarProjeto(@PathVariable (value = "id") Integer id, @RequestBody Projeto projeto) {
		List<Projeto> projetos = projetorepository.findAll();
		for (Projeto p : projetos) {
			if (p.getId() == id) {
				p.setDescricaoProjeto(projeto.getDescricaoProjeto());
				p.setNomeProjeto(projeto.getNomeProjeto());
				projetorepository.save(p);
			}
		}
	}
}
