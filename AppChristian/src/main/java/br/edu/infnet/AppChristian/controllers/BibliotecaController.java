package br.edu.infnet.AppChristian.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.AppChristian.model.domain.Biblioteca;
import br.edu.infnet.AppChristian.model.service.BibliotecaService;

@RestController
public class BibliotecaController {


	@Autowired
	private BibliotecaService bibliotecaService;

	@GetMapping(value = "/biblioteca/lista")
	public Collection<Biblioteca> obterLista(){
		return bibliotecaService.obterLista();
	}
	
	@GetMapping(value = "/biblioteca/{id}")
	public Biblioteca obterPorId(@PathVariable Integer id) {
		return bibliotecaService.obterPorId(id);
	}
	@GetMapping(value = "/biblioteca/lista/{email}")
	public Biblioteca obterPorEmail(@PathVariable String email) {
		return bibliotecaService.obterPorEmail(email);
	}
	@PostMapping(value = "/biblioteca/incluir")
	public void incluir(@RequestBody Biblioteca biblioteca) {
		bibliotecaService.incluir(biblioteca);
	}
	
	@DeleteMapping(value = "/biblioteca/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		bibliotecaService.excluir(id);
	}
}
