package com.livro.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.livro.model.Academico;
import com.livro.repository.AcademicoRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AcademicoService {

	@Autowired
	public AcademicoRepository academicoRepository;
	
	public Academico incluir(Academico academico) {
		try {
			academicoRepository.save(academico);
			return academico;
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());
				return academico;
			}
	}
	public Academico atualizar(Academico academico) {
		try {
			academicoRepository.save(academico);
			return academico;
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());
				return academico;
			}
	}
	public Collection<Academico> obterLista(){
		return (Collection<Academico>) academicoRepository.findAll();
	}

	public Collection<Academico> obterListaDecrescente(){
		return (Collection<Academico>) academicoRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Optional<Academico> obterPorId(Integer id) {
		return academicoRepository.findById(id);
	}

	public List<Academico> obterPorIdBiblioteca(int bibliotecaId) {
		log.info("livroService" + bibliotecaId);
		return academicoRepository.findByBibliotecaId(bibliotecaId);
	}
	public void excluir(Integer id) {
		academicoRepository.deleteById(id);
	}
	public long quantidade() {
		return academicoRepository.count();
	}
}
