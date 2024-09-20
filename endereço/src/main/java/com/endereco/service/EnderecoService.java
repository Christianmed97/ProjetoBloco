package com.endereco.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endereco.clients.EnderecoClient;
import com.endereco.model.Endereco;
import com.endereco.repository.EnderecoRepository;



@Service
public class EnderecoService {
	
	@Autowired
	public EnderecoRepository enderecoRepository;
	@Autowired
	public EnderecoClient enderecoClient;
	
	public Collection<Endereco> obterLista(){
		return (Collection<Endereco>) enderecoRepository.findAll();
	}	
	public Optional<Endereco> obterPorCep(String cep) {
		return enderecoClient.obterPorCep(cep);
	}
	public long quantidade() {
		return enderecoRepository.count();
	}
}
