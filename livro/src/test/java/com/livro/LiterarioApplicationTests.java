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
import com.livro.model.Literario;

@SpringBootTest
class LiterarioApplicationTests {

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
		mockMvc.perform(get("/literario/1")).andExpect(status().isOk()).andExpect(content().json("{\n"
				+ "    \"id\": 1,\n"
				+ "    \"nome\": \"Senhor dos aneis\",\n"
				+ "    \"autor\": \"Tolkien\",\n"
				+ "    \"numeroPaginas\": 576,\n"
				+ "    \"preco\": 100.0,\n"
				+ "    \"sinopse\": \"Seila\",\n"
				+ "    \"bibliotecaId\": 2,\n"
				+ "    \"tema\": \"fantasia\",\n"
				+ "    \"infantil\": false,\n"
				+ "    \"tipo\": \"livro\"\n"
				+ "}"));
		mockMvc.perform(get("/literario/600")).andExpect(status().isNotFound());
	}
	@Test
	@DisplayName("Deve buscar pelo Id da biblioteca")
	public void testafindByIdBiblioteca() throws Exception{
		mockMvc.perform(get("/livro/literario/1")).andExpect(status().isOk()).andExpect(content().json("[\n"
				+ "    {\n"
				+ "        \"id\": 2,\n"
				+ "        \"nome\": \"Motoqueiro Fantasma Vol.1\",\n"
				+ "        \"autor\": \"Tradd Moore\",\n"
				+ "        \"numeroPaginas\": 140,\n"
				+ "        \"preco\": 99.0,\n"
				+ "        \"sinopse\": \"sinopse doida\",\n"
				+ "        \"bibliotecaId\": 1,\n"
				+ "        \"tema\": \"fantasia\",\n"
				+ "        \"infantil\": false,\n"
				+ "        \"tipo\": \"quadrinho\"\n"
				+ "    }\n"
				+ "]"));
		mockMvc.perform(get("/livro/literario/100")).andExpect(status().isNotFound());
	}
	@Test
	public void testafindAll() throws Exception{
		mockMvc.perform(get("/literario/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)));
	}
	@Test
	public void testaDelete() throws Exception{
		mockMvc.perform(delete("/literario/2/excluir")).andExpect(status().isOk());
		mockMvc.perform(get("/literario/2")).andExpect(status().isNotFound());
		mockMvc.perform(get("/literario/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
		
	}
	@Test
	public void testaIncluir() throws Exception{
		Literario literario = new Literario();
		literario.setNome("Horus Rising: 1");
		literario.setAutor("Dan Abnett");
		literario.setNumeroPaginas(416);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(literario);
		mockMvc.perform(post("/literario/incluir").contentType("application/json").content(json)).andExpect(status().isCreated());
		mockMvc.perform(get("/literario/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(4)));	
		mockMvc.perform(get("/literario/6")).andExpect(status().isOk()).andExpect(jsonPath("$.nome",is("Horus Rising: 1")));
	}
	@Test
	public void testaAtualizar() throws Exception{
		Academico academico = new Academico();
		academico.setId(1);
		academico.setNome("Horus");
		academico.setAutor("Dan");
		academico.setNumeroPaginas(912);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(academico);
		mockMvc.perform(put("/literario/incluir").contentType("application/json").content(json)).andExpect(status().isCreated());
		mockMvc.perform(get("/literario/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)));	
		mockMvc.perform(get("/literario/1")).andExpect(status().isOk()).andExpect(jsonPath("$.nome",is("Horus")));
	}
}
