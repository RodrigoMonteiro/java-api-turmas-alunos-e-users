package com.atividade05.apirest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.atividade05.apirest.Model.Aluno;
import com.atividade05.apirest.Repository.AlunoRepository;
import com.atividade05.apirest.Service.AlunoService;

@ExtendWith(SpringExtension.class)
public class AlunoServiceTest {

	@TestConfiguration
	static class alunoServiceConfiguration {
		@Bean
		public AlunoService alunoService() {
			return new AlunoService();
		}
	}

	@Autowired
	AlunoService alunoService;

	@MockBean
	AlunoRepository alunoRepository;

	@Test
	public void alunoTestService() {

		String nome = alunoService.pegarNomeporId(3);

		Assertions.assertEquals(nome, "Aluno teste");
	}

	@BeforeEach
	public void setup() {	 
		Aluno aluno = new Aluno("Aluno teste");
	
	Mockito.when(alunoRepository.findById(aluno.getIdAluno()))
	.thenReturn(java.util.Optional.of(aluno));
	
	}
}
