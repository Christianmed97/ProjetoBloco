package com.livro.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.livro.conf.ApplicationCache;
import com.livro.model.Livro;
import com.livro.service.LivroService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	@Autowired
	private  ApplicationCache cache;
	

	@GetMapping(value = "/livro/lista")
	public  ResponseEntity<?> obterLista(){
		log.info("nome"+cache.appName);
		return ResponseEntity.ok(livroService.obterLista());
	}
	@GetMapping(value = "/livro/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable Integer id) {
		Optional<Livro> optional=livroService.obterPorId(id);
		 if(optional.isPresent()) {
			 return ResponseEntity.ok(optional.get());
		 }else { 
			 return ResponseEntity.notFound().build();
		 }
	}
	@GetMapping(value = "/livro/idBiblioteca/{bibliotecaId}")
	public ResponseEntity<?> obterPorIdBiblioteca(@PathVariable Integer bibliotecaId) {
		log.info("livroController");
		log.info(livroService.obterPorIdBiblioteca(bibliotecaId).toString());
		List<Livro> livro = livroService.obterPorIdBiblioteca(bibliotecaId);
		if(!livro.isEmpty()) {
			 return ResponseEntity.ok(livro);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	} 
	@DeleteMapping(value = "/livro/{id}/excluir")
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		livroService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
