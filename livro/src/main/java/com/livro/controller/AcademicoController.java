package com.livro.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.livro.conf.ApplicationCache;
import com.livro.model.Academico;
import com.livro.service.AcademicoService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class AcademicoController {
	
	@Autowired
	private AcademicoService academicoService;
	@Autowired
	private  ApplicationCache cache;
	

	@GetMapping(value = "/academico/lista")
	public ResponseEntity<?> obterLista(){
		log.info("nome"+cache.appName);
		return ResponseEntity.ok(academicoService.obterLista());
	}
	@GetMapping(value = "/academico/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable Integer id) {
		Optional<Academico> optional=academicoService.obterPorId(id);
		 if(optional.isPresent()) {
			 return ResponseEntity.ok(optional.get());
		 }else { 
			 return ResponseEntity.notFound().build();
		 }
	}
	@GetMapping(value = "/livro/academico/{bibliotecaId}")
	public ResponseEntity<?> obterAcademicoPorIdBiblioteca(@PathVariable Integer bibliotecaId) {
		log.info("livroController");
		log.info(academicoService.obterPorIdBiblioteca(bibliotecaId).toString());
		List<Academico> academico = academicoService.obterPorIdBiblioteca(bibliotecaId);
		if(!academico.isEmpty()) {
			 return ResponseEntity.ok(academico);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	}
	@PostMapping(value = "/academico/incluir")
	public ResponseEntity<Academico> incluir(@RequestBody Academico academico) {
		Academico saved=academicoService.incluir(academico);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	@PutMapping(value = "/academico/incluir")
	public ResponseEntity<Academico> atualizar(@RequestBody Academico academico) {
		Academico saved=academicoService.atualizar(academico);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	@DeleteMapping(value = "/academico/{id}/excluir")
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		academicoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
