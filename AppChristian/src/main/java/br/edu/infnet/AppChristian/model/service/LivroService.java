package br.edu.infnet.AppChristian.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppChristian.model.domain.Livro;
import br.edu.infnet.AppChristian.model.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	public LivroRepository livroRepository;
	
	public void incluir(Livro livro) {
		try {
			livroRepository.save(livro);
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());
			}
	}
	public Collection<Livro> obterLista(){
		return (Collection<Livro>) livroRepository.findAll();
	}
	public Collection<Livro> obterListaDecrescente(){
		return (Collection<Livro>) livroRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Livro obterPorId(Integer id) {
		return livroRepository.findById(id).orElse(null);
	}

	public Collection<Livro> obterPorAutor(String autor) {
		return livroRepository.findByAutor(autor);
	}
	public void excluir(Integer id) {
		livroRepository.deleteById(id);
	}
	public long quantidade() {
		return livroRepository.count();
	}
}
