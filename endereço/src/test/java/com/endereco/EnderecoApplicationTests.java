package com.endereco;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = EnderecoApplication.class)
class EnderecoApplicationTests {
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	@Test
	@DisplayName("Deve buscar pelo cep")
	public void testaObterPorCep() throws Exception{
		mockMvc.perform(get("/endereco/20010-020")).andExpect(status().isOk()).andExpect(content().json("{\n"
				+ "    \"id\": null,\n"
				+ "    \"cep\": \"20010-020\",\n"
				+ "    \"logradouro\": \"Rua São José\",\n"
				+ "    \"complemento\": \"\",\n"
				+ "    \"bairro\": \"Centro\",\n"
				+ "    \"localidade\": \"Rio de Janeiro\",\n"
				+ "    \"uf\": \"RJ\"\n"
				+ "}"));
	}
}
