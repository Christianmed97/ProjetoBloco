package com.livro;

import static org.hamcrest.Matchers.hasSize;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.livro.model.Academico;

@SpringBootTest
class AcademicoApplicationTests {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	@Test
	@DisplayName("Deve buscar pelo Id")
	public void testafindById() throws Exception{
		mockMvc.perform(get("/academico/3")).andExpect(status().isOk()).andExpect(content().json("{\n"
				+ "    \"id\": 3,\n"
				+ "    \"nome\": \"Calculo \",\n"
				+ "    \"autor\": \"James Steward\",\n"
				+ "    \"numeroPaginas\": 300,\n"
				+ "    \"preco\": 200.0,\n"
				+ "    \"sinopse\": \" outra sinopse maluca\",\n"
				+ "    \"bibliotecaId\": 1,\n"
				+ "    \"area\": \"Matematica\",\n"
				+ "    \"volume\": \"3\"\n"
				+ "}"));
		mockMvc.perform(get("/academico/600")).andExpect(status().isNotFound());
	}
	@Test
	@DisplayName("Deve buscar pelo Id da biblioteca")
	public void testafindByIdBiblioteca() throws Exception{
		mockMvc.perform(get("/livro/academico/1")).andExpect(status().isOk()).andExpect(content().json("[\n"
				+ "    {\n"
				+ "        \"id\": 3,\n"
				+ "        \"nome\": \"Calculo \",\n"
				+ "        \"autor\": \"James Steward\",\n"
				+ "        \"numeroPaginas\": 300,\n"
				+ "        \"preco\": 200.0,\n"
				+ "        \"sinopse\": \" outra sinopse maluca\",\n"
				+ "        \"bibliotecaId\": 1,\n"
				+ "        \"area\": \"Matematica\",\n"
				+ "        \"volume\": \"3\"\n"
				+ "    }\n"
				+ "]"));
		mockMvc.perform(get("/livro/academico/100")).andExpect(status().isNotFound());
	}
	@Test
	public void testafindAll() throws Exception{
		mockMvc.perform(get("/academico/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
	}
	@Test
	public void testaDelete() throws Exception{
		mockMvc.perform(delete("/academico/3/excluir")).andExpect(status().isOk());
		mockMvc.perform(get("/academico/3")).andExpect(status().isNotFound());
		mockMvc.perform(get("/academico/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)));
		
	}
	@Test
	public void testaIncluir() throws Exception{
		Academico academico = new Academico();
		academico.setNome("Física Conceitual");
		academico.setAutor("Paul G. Hewitt");
		academico.setNumeroPaginas(912);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(academico);
		mockMvc.perform(post("/academico/incluir").contentType("application/json").content(json)).andExpect(status().isCreated());
		mockMvc.perform(get("/academico/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)));	
		mockMvc.perform(get("/academico/6")).andExpect(status().isOk()).andExpect(jsonPath("$.nome",is("Física Conceitual")));
	}
	@Test
	public void testaAtualizar() throws Exception{
		Academico academico = new Academico();
		academico.setId(3);
		academico.setNome("Física");
		academico.setAutor("Paul Hewitt");
		academico.setNumeroPaginas(912);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(academico);
		mockMvc.perform(put("/academico/incluir").contentType("application/json").content(json)).andExpect(status().isCreated());
		mockMvc.perform(get("/academico/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));	
		mockMvc.perform(get("/academico/3")).andExpect(status().isOk()).andExpect(jsonPath("$.nome",is("Física")));
	}
}
