package br.edu.infnet.ChristianAPI.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.ChristianAPI.domain.DetalhesOpenLivros;
import br.edu.infnet.ChristianAPI.domain.OpenLivros;


@FeignClient(url = "https://openlibrary.org/search.json", name="OpenLibrary")
public interface OpenLivrosClient {

	@GetMapping(value = "?title={titulo}&sort=old")
	OpenLivros obterPorTitulo(@PathVariable String titulo);
	
	@GetMapping(value = "?title={titulo}&sort=old")
	DetalhesOpenLivros obterDetalhes(@PathVariable String titulo);
}
