package com.endereco.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.endereco.model.Endereco;
import com.endereco.service.EnderecoService;


@RestController
public class EnderecoController {


	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping(value="/endereco/{cep}")
	public ResponseEntity<?> obterEnderecoPorCep(@PathVariable String cep) {
		Optional<Endereco> optional=enderecoService.obterPorCep(cep);
		 if(optional.isPresent()) {
			 return ResponseEntity.ok(optional.get());
		 }else { 
			 return ResponseEntity.notFound().build();
		 }
	}
}
