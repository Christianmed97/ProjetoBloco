package br.edu.infnet.AppChristian.model.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppChristian.clients.ApiChristianClient;
import br.edu.infnet.AppChristian.model.domain.DetalhesOpenLivros;
import br.edu.infnet.AppChristian.model.domain.Livro;
import br.edu.infnet.AppChristian.model.domain.OpenLivros;

@Service
public class ApiService {

	@Autowired
	private ApiChristianClient apiChristianClient;	
	@Autowired
	private LivroService livroService;
	
	public Collection<String> teste() {
		return apiChristianClient.obterLista();
	}
	public Collection<OpenLivros> obterLista(){
		ArrayList<String> listaDeNomes = new ArrayList<String>();
		for (Livro livro : livroService.obterLista()) {
			listaDeNomes.add(livro.getNome());
		}
		return apiChristianClient.obterPorTitulo(listaDeNomes);
	}	
	public Collection<DetalhesOpenLivros> obterDetalhes(String titulo){	
		return apiChristianClient.obterDetalhes(titulo);
	}
	
}
