package br.edu.infnet.AppChristian.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.edu.infnet.AppChristian.model.domain.Literario;
import br.edu.infnet.AppChristian.model.service.LiterarioService;

@RestController
public class LiterarioController {
	
	@Autowired
	private LiterarioService literarioService;

	@GetMapping(value = "/literario/lista")
	public Collection<Literario> obterLista(){
		return literarioService.obterLista();
	}
	
	@GetMapping(value = "/literario/{id}")
	public Literario obterPorId(@PathVariable Integer id) {
		return literarioService.obterPorId(id);
	}
	@GetMapping(value = "/literario/lista/{tema}")
	public Collection<Literario> obterPorTema(@PathVariable String tema) {
		return literarioService.obterPorTema(tema);
	}
	@PostMapping(value = "/literario/incluir")
	public void incluir(@RequestBody Literario literario) {
		literarioService.incluir(literario);
	}
	
	@DeleteMapping(value = "/literario/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		literarioService.excluir(id);
	}
}


