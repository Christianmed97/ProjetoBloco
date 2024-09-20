package org.acme.service;

import org.acme.model.Biblioteca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class BibliotecaService {
	
	@Inject
	Biblioteca biblioteca;
	
	public String obterNomes(){
		return biblioteca.listAll().toString();
	}
}
