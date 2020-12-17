package com.atividade05.apirest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.atividade05.apirest.Controller.AlunoController;
import com.atividade05.apirest.Model.Aluno;
import com.atividade05.apirest.Repository.AlunoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AlunoControllerTest {

	private final String baseApiUrl = "/api/alunos";
	private Integer idCorrect = 1;
	private Integer idIncorrect = 2077;
	private MockMvc mockMvc;

	@InjectMocks
	private AlunoController alunoController;

	@Autowired
	AlunoRepository alunorepository;

	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(alunoController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView()).build();
	}

	// TESTE PARA A ROTA GET (ROTA CORRETA)
	@Test
	public void alunoTestGetAllCorrect() throws Exception {
		mockMvc.perform(get("/api/alunos"))
		.contentType(MediaType.APPLICATION_JSON)
		.andExpect(status().isOk());
	}

	// TESTE PARA A ROTA GET (ROTA INCORRETA)
	@Test
	public void alunoTestGetAllIncorrect() throws Exception {
		mockMvc.perform(get("/api/alunos"))
		.contentType(MediaType.APPLICATION_JSON)
		.andExpect(status().isOk());
	}

	// TESTE PARA A ROTA GET PASSANDO UM ID (ROTA CORRETA)
	@Test
	public void alunoTestGetByIdCorrect() throws Exception {
		mockMvc.perform(get("/api/alunos" + idCorrect))
		.contentType(MediaType.APPLICATION_JSON)
		.andExpect(status().isOk());

	}

	// TESTE PARA A ROTA GET PASSANDO UM ID (ROTA INCORRETA)
	@Test
	public void alunoTestGetByIdIncorrect() throws Exception {
		mockMvc.perform(get("/api/alunos" + idIncorrect))
		.contentType(MediaType.APPLICATION_JSON)
		.andExpect(status().isOk());

	}

	// TESTE PARA A ROTA POST (FORMA CORRETA)
	@Test
	public void alunoTestSaveCorrect() throws Exception {
		Aluno aluno = new Aluno("Criando aluno para o Teste do post");

		mockMvc.perform(
				post("/api/alunos")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(aluno)))
				.andExpect(status().isCreated());
	}

	// TESTE PARA A ROTA POST (FORMA INCORRETA)
	@Test
	public void alunoTestSaveIncorrect() throws Exception {
		Aluno aluno = new Aluno("Criando aluno para o Teste do post");

		mockMvc.perform(
				post("/api/alunos")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(aluno)))
				.andExpect(status(500));
	}

	// TESTE PARA A ROTA PUT (FORMA CORRETA )
	@Test
	public void alunoTestAtualizar() throws Exception {
		Aluno aluno = alunorepository.getOne(idCorrect);
		mockMvc.perform(put("/api/alunos/" + idCorrect)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(aluno)))
		        .andExpect(status().isOk());
	}

	// TESTE PARA A ROTA PUT (FORMA INCORRETA )
	@Test
	public void alunoTestAtualizarIncorrect() throws Exception {
		Aluno aluno = alunorepository.getOne(idIncorrect);
		mockMvc.perform(put("/api/alunos/" + idIncorrect)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(aluno)))
		        .andExpect(status().isNotFound());
	}

	// TESTE PARA A ROTA DELETE ( FORMA CORRETA )
	public void deletarAlunoCorrect() throws Exception{
		mockMvc.perform(delete("/api/alunos/" + idCorrect).contentType("application/json")
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
	}

	// TESTE PARA A ROTA DELETE ( FORMA INCORRETA )
	public void deletarAlunoIncorrect() throws Exception {
		mockMvc.perform(delete("/api/alunos/"+idIncorrect).contentType("application/json")
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
}
}
