package com.livro.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.livro.model.Livro;
import com.livro.repository.LivroRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LivroService {
	
	public final LivroRepository livroRepository;
	
	public Livro incluir(Livro livro) {
		try {
			livroRepository.save(livro);
			return livro;
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());

				return livro;
			}
	}
	public Collection<Livro> obterLista(){
		return (Collection<Livro>) livroRepository.findAll();
	}
	public Collection<Livro> obterListaDecrescente(){
		return (Collection<Livro>) livroRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Optional<Livro> obterPorId(Integer id) {
		return livroRepository.findById(id);
	}
	public Livro atualizar(Livro livro) {
		return livroRepository.save(livro);
	}
	public List<Livro> obterPorIdBiblioteca(int bibliotecaId) {
		log.info("livroService" + bibliotecaId);
		return livroRepository.findByBibliotecaId(bibliotecaId);
	}
	public void excluir(Integer id) {
		livroRepository.deleteById(id);
	}
	public long quantidade() {
		return livroRepository.count();
	}
}
