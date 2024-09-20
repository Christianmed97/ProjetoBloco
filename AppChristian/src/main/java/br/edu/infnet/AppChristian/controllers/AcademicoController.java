package br.edu.infnet.AppChristian.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.AppChristian.model.domain.Academico;
import br.edu.infnet.AppChristian.model.service.AcademicoService;

@RestController
public class AcademicoController {
	
	@Autowired
	private AcademicoService academicoService;

	@GetMapping(value = "/academico/lista")
	public Collection<Academico> obterLista(){
		return academicoService.obterLista();
	}
	@GetMapping(value = "/academico/{id}")
	public Academico obterPorId(@PathVariable Integer id) {
		return academicoService.obterPorId(id);
	}
	@GetMapping(value = "/academico/lista/{area}")
	public Collection<Academico> obterPorArea(@PathVariable String area) {
		return academicoService.obterPorArea(area);
	}
	@PostMapping(value = "/academico/incluir")
	public void incluir(@RequestBody Academico academico) {
		System.out.println("dasdsad"+academico);
		academicoService.incluir(academico);
	}
	
	@DeleteMapping(value = "/academico/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		academicoService.excluir(id);
	}
}
