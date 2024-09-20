package br.edu.infnet.AppChristian.clients;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.AppChristian.model.domain.DetalhesOpenLivros;
import br.edu.infnet.AppChristian.model.domain.Endereco;
import br.edu.infnet.AppChristian.model.domain.OpenLivros;

@FeignClient(url = "http://localhost:8081", name="apiChristian")
public interface ApiChristianClient {
	@GetMapping(value = "/listagem")
	Collection<String> obterLista();
	
	@GetMapping(value="/{cep}")
	public Endereco obterEnderecoPorCep(@PathVariable String cep);
	
	@GetMapping(value = "/openLivros/{listaDeNomes}")
	Collection<OpenLivros> obterPorTitulo(@PathVariable ArrayList<String> listaDeNomes);
	
	@GetMapping(value = "/detalhes/{titulo}")
	Collection<DetalhesOpenLivros> obterDetalhes(@PathVariable String titulo);
}