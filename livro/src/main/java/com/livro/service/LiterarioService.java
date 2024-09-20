package com.livro.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.livro.model.Literario;
import com.livro.repository.LiterarioRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class LiterarioService {

	@Autowired
	public LiterarioRepository literarioRepository;
	
	public Literario incluir(Literario literario) {
		try {
			literarioRepository.save(literario);
			return literario;
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());
				return literario;
			}
	}
	public Literario atualizar(Literario literario) {
		try {
			literarioRepository.save(literario);
			return literario;
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());
				return literario;
			}
	}
	public Collection<Literario> obterLista(){
		return (Collection<Literario>) literarioRepository.findAll();
	}
	public Collection<Literario> obterListaDecrescente(){
		return (Collection<Literario>) literarioRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Optional<Literario> obterPorId(Integer id) {
		return literarioRepository.findById(id);
	}
	public List<Literario> obterPorIdBiblioteca(int bibliotecaId) {
		log.info("livroService" + bibliotecaId);
		return literarioRepository.findByBibliotecaId(bibliotecaId);
	}
	public void excluir(Integer id) {
		literarioRepository.deleteById(id);
	}
	public long quantidade() {
		return literarioRepository.count();
	}
}