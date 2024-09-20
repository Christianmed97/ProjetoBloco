package com.biblioteca.service.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.biblioteca.model.Endereco;

@FeignClient("ENDERECO-SERVICE")
public interface EnderecoClient {
	@GetMapping(value = "/endereco/{cep}")
	Endereco obterPorCep(@PathVariable String cep);	
}
