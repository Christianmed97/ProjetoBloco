package br.edu.infnet.AppChristian.model.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppChristian.clients.ApiChristianClient;
import br.edu.infnet.AppChristian.model.domain.Endereco;
import br.edu.infnet.AppChristian.model.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	public EnderecoRepository enderecoRepository;
	@Autowired
	public ApiChristianClient apiChristianClient;
	
	public Collection<Endereco> obterLista(){
		return (Collection<Endereco>) enderecoRepository.findAll();
	}	
	public Endereco obterPorCep(String cep) {
		return apiChristianClient.obterEnderecoPorCep(cep);
	}
	public long quantidade() {
		return enderecoRepository.count();
	}
}
