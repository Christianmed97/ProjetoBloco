package com.biblioteca;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.biblioteca.model.Biblioteca;
import com.biblioteca.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class BibliotecaApplicationTests {
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
		mockMvc.perform(get("/biblioteca/1")).andExpect(status().isOk()).andExpect(content().json("{\n"
				+ "    \"id\": 1,\n"
				+ "    \"nome\": \"Biblioteca1\",\n"
				+ "    \"endereco\": {\n"
				+ "        \"id\": 1,\n"
				+ "        \"cep\": \"22631-054\",\n"
				+ "        \"logradouro\": \"Avenida Prefeito Dulcídio Cardoso\",\n"
				+ "        \"complemento\": \"de 3042 a 4028 - lado par\",\n"
				+ "        \"bairro\": \"Barra da Tijuca\",\n"
				+ "        \"localidade\": \"Rio de Janeiro\",\n"
				+ "        \"uf\": \"RJ\"\n"
				+ "    },\n"
				+ "    \"email\": \"biblioteca1@hotmail.com\",\n"
				+ "    \"livros\": [\n"
				+ "        {\n"
				+ "            \"id\": 2,\n"
				+ "            \"nome\": \"Calculo \",\n"
				+ "            \"autor\": \"James Steward\",\n"
				+ "            \"numeroPaginas\": 300,\n"
				+ "            \"preco\": 200.0,\n"
				+ "            \"sinopse\": \" outra sinopse maluca\",\n"
				+ "            \"bibliotecaId\": 1,\n"
				+ "            \"area\": \"Matematica\",\n"
				+ "            \"volume\": \"3\"\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"id\": 3,\n"
				+ "            \"nome\": \"Motoqueiro Fantasma Vol.1\",\n"
				+ "            \"autor\": \"Tradd Moore\",\n"
				+ "            \"numeroPaginas\": 140,\n"
				+ "            \"preco\": 99.0,\n"
				+ "            \"sinopse\": \"sinopse doida\",\n"
				+ "            \"bibliotecaId\": 1,\n"
				+ "            \"tema\": \"fantasia\",\n"
				+ "            \"infantil\": false,\n"
				+ "            \"tipo\": \"quadrinho\"\n"
				+ "        }\n"
				+ "    ]"
				+ "}"));
		mockMvc.perform(get("/biblioteca/600")).andExpect(status().isNotFound());
	}
	@Test
	public void testafindAll() throws Exception{
		mockMvc.perform(get("/biblioteca/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
	}
	@Test
	public void testaDelete() throws Exception{
		mockMvc.perform(delete("/biblioteca/1/excluir")).andExpect(status().isOk());
		mockMvc.perform(get("/biblioteca/1")).andExpect(status().isNotFound());
		mockMvc.perform(get("/biblioteca/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)));
		
	}
	@Test
	public void testaIncluir() throws Exception{
		Biblioteca biblioteca = new Biblioteca();
		Endereco endereco = new Endereco();
		endereco.setCep("20010-020");
		biblioteca.setNome("bibliotecateste");
		biblioteca.setEmail("bibliotecateste@hotmail.com");
		biblioteca.setEndereco(endereco);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(biblioteca);
		mockMvc.perform(post("/biblioteca/incluir").contentType("application/json").content(json)).andExpect(status().isCreated());
		mockMvc.perform(get("/biblioteca/lista")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)));	
		mockMvc.perform(get("/biblioteca/3")).andExpect(status().isOk()).andExpect(jsonPath("$.nome",is("bibliotecateste")));
	}
}
