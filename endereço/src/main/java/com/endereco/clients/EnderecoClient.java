package com.endereco.clients;


import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.endereco.model.Endereco;



@FeignClient(url = "https://viacep.com.br/ws", name="viaCep")
public interface EnderecoClient {
	@GetMapping(value = "/{cep}/json/")
	Optional<Endereco> obterPorCep(@PathVariable String cep);	
}
