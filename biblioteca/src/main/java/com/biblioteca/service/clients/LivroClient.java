package com.biblioteca.service.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.biblioteca.model.Academico;
import com.biblioteca.model.Literario;

@FeignClient("LIVRO-SERVICE")
public interface LivroClient {
	@GetMapping(value = "/livro/literario/{bibliotecaId}")
	List<Literario> obterLiterarioPorIdBiblioteca(@PathVariable Integer bibliotecaId);	
	
	@GetMapping(value = "/livro/academico/{bibliotecaId}")
	List<Academico> obterAcademicoPorIdBiblioteca(@PathVariable Integer bibliotecaId);	
}
