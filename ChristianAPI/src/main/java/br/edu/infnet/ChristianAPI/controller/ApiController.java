package br.edu.infnet.ChristianAPI.controller;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.ChristianAPI.domain.DetalhesOpenLivros;
import br.edu.infnet.ChristianAPI.domain.Endereco;
import br.edu.infnet.ChristianAPI.domain.OpenLivros;
import br.edu.infnet.ChristianAPI.service.EnderecoService;
import br.edu.infnet.ChristianAPI.service.OpenLivrosService;

@RestController
public class ApiController {
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private OpenLivrosService openLivrosService;
	
	@GetMapping(value="/listagem")
	public Collection<String> obterLista(){
		return new ArrayList<String>(Arrays.asList("1","2","3"));
	}
	@GetMapping(value="/{cep}")
	public Endereco obterEnderecoPorCep(@PathVariable String cep) {
		return enderecoService.obterPorCep(cep);
	}
	@GetMapping(value = "/openLivros/{listaDeNomes}")
	Collection<OpenLivros> obterPorTitulo(@PathVariable ArrayList<String> listaDeNomes) {
		return openLivrosService.obterLista(listaDeNomes);
	};
	
	@GetMapping(value = "/detalhes/{titulo}")
	Collection<DetalhesOpenLivros> obterDetalhes(@PathVariable String titulo) {
		return openLivrosService.obterDetalhes(titulo);
	};
	
}
