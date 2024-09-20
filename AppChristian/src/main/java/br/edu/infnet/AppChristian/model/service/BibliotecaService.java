package br.edu.infnet.AppChristian.model.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppChristian.model.domain.Biblioteca;
import br.edu.infnet.AppChristian.model.domain.Endereco;
import br.edu.infnet.AppChristian.model.repository.BibliotecaRepository;

@Service
public class BibliotecaService {

	@Autowired
	public BibliotecaRepository bibliotecaRepository;
	@Autowired
	public EnderecoService enderecoService;
	
	public void incluir(Biblioteca biblioteca) {
		try {
			Endereco endereco= enderecoService.obterPorCep(biblioteca.getEndereco().getCep());
			biblioteca.setEndereco(endereco);
			bibliotecaRepository.save(biblioteca);
		}catch(Exception e){
			try {
				bibliotecaRepository.save(biblioteca);
				}catch(Exception e1) {
					System.err.println("[ERROR] "+ e.getMessage());
					System.err.println("[ERROR] "+ e1.getMessage());
				}
		}
	}
	public Collection<Biblioteca> obterLista(){
		return (Collection<Biblioteca>) bibliotecaRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Biblioteca obterPorId(Integer id) {
		return bibliotecaRepository.findById(id).orElse(null) ;
	}
	public Biblioteca obterPorEmail(String email) {
		return bibliotecaRepository.findByEmail(email);
	}
	public void excluir(Integer id) {
		bibliotecaRepository.deleteById(id);
	}
	public long quantidade() {
		return bibliotecaRepository.count();
	}
}
