package com.biblioteca.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.model.Endereco;
import com.biblioteca.service.clients.EnderecoClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class EnderecoService {
	@Autowired
	private EnderecoClient enderecoClient;
	private static Map<String, Endereco> CACHE= new ConcurrentHashMap<>();
	
	@CircuitBreaker(name = "enderecoService",fallbackMethod = "buscarNoCache")
	public Endereco obterPorCep(String cep) {
		Endereco endereco = enderecoClient.obterPorCep(cep);
		CACHE.put(cep, endereco);
		return endereco;
	}
	
	public Endereco buscarNoCache(String cep , Throwable e) {
		log.info("Buscando no cache");
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		return CACHE.getOrDefault(cep,endereco);
	}
}
