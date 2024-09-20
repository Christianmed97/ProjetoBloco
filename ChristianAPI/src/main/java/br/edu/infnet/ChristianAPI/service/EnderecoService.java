package br.edu.infnet.ChristianAPI.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.edu.infnet.ChristianAPI.clients.EnderecoClient;
import br.edu.infnet.ChristianAPI.domain.Endereco;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoClient enderecoClient;
	
	public Endereco obterPorCep(String cep) {
		return enderecoClient.obterPorCep(cep);
	}
}
