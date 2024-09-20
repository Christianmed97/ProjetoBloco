package br.edu.infnet.AppChristian.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppChristian.model.domain.Literario;
import br.edu.infnet.AppChristian.model.repository.LiterarioRepository;

@Service
public class LiterarioService {

	@Autowired
	public LiterarioRepository literarioRepository;
	
	public void incluir(Literario literario) {
		try {
			literarioRepository.save(literario);
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());
			}
	}
	public Collection<Literario> obterLista(){
		return (Collection<Literario>) literarioRepository.findAll();
	}
	public Collection<Literario> obterListaDecrescente(){
		return (Collection<Literario>) literarioRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Literario obterPorId(Integer id) {
		return literarioRepository.findById(id).orElse(null);
	}

	public Collection<Literario> obterPorTema(String tema) {
		return literarioRepository.findByTema(tema);
	}
	public void excluir(Integer id) {
		literarioRepository.deleteById(id);
	}
	public long quantidade() {
		return literarioRepository.count();
	}
}