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
import com.livro.model.Literario;
import com.livro.service.LiterarioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LiterarioController {
	
	@Autowired
	private LiterarioService literarioService;
	@Autowired
	private  ApplicationCache cache;

	@GetMapping(value = "/literario/lista")
	public ResponseEntity<?> obterLista(){
		log.info("nome"+cache.appName);
		return ResponseEntity.ok(literarioService.obterLista());
	}
	@GetMapping(value = "/literario/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable Integer id) {
		Optional<Literario> optional=literarioService.obterPorId(id);
		 if(optional.isPresent()) {
			 return ResponseEntity.ok(optional.get());
		 }else { 
			 return ResponseEntity.notFound().build();
		 }
	}
	@GetMapping(value = "/livro/literario/{bibliotecaId}")
	public ResponseEntity<?> obterLiterarioPorIdBiblioteca(@PathVariable Integer bibliotecaId) {
		log.info(literarioService.obterPorIdBiblioteca(bibliotecaId).toString());
		List<Literario> literario = literarioService.obterPorIdBiblioteca(bibliotecaId);
		if(!literario.isEmpty()) {
			 return ResponseEntity.ok(literario);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	}

	@PostMapping(value = "/literario/incluir")
	public ResponseEntity<Literario> incluir(@RequestBody Literario literario) {
		Literario saved=literarioService.incluir(literario);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	@PutMapping(value = "/literario/incluir")
	public ResponseEntity<Literario> atualizar(@RequestBody Literario literario) {
		Literario saved=literarioService.atualizar(literario);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	@DeleteMapping(value = "/literario/{id}/excluir")
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		literarioService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}


