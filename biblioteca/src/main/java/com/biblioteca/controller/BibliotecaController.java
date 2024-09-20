package com.biblioteca.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.conf.ApplicationCache;
import com.biblioteca.model.Biblioteca;
import com.biblioteca.service.BibliotecaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@AllArgsConstructor
@Slf4j
public class BibliotecaController {


	private final BibliotecaService bibliotecaService;

	private final ApplicationCache cache;

	@GetMapping(value = "/biblioteca/lista")
	public ResponseEntity<?> obterLista(){
		log.info("nome"+cache.appName);
		return ResponseEntity.ok(bibliotecaService.obterLista());
	}
	
	@GetMapping(value = "/biblioteca/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable Integer id) {
		 Optional<Biblioteca> optional=bibliotecaService.obterPorId(id);
		 if(optional.isPresent()) {
			 return ResponseEntity.ok(optional.get());
		 }else { 
			 return ResponseEntity.notFound().build();
		 }

	}
	@GetMapping(value = "/biblioteca/email/{email}")
	public ResponseEntity<?> obterPorEmail(@PathVariable String email) {
		 Optional<Biblioteca> optional=bibliotecaService.obterPorEmail(email);
		 if(optional.isPresent()) {
			 return ResponseEntity.ok(optional.get());
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	}
	@PostMapping(value = "/biblioteca/incluir")
	public ResponseEntity<Biblioteca> incluir(@RequestBody Biblioteca biblioteca) {
		Biblioteca saved=bibliotecaService.incluir(biblioteca);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@DeleteMapping(value = "/biblioteca/{id}/excluir")
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		bibliotecaService.excluir(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping(value = "/biblioteca/incluir")
	public ResponseEntity<Biblioteca> atualizar(@RequestBody Biblioteca biblioteca) {
		Biblioteca saved=bibliotecaService.atualizar(biblioteca);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
}
