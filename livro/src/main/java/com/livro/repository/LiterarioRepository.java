package com.livro.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.livro.model.Literario;


@Repository
public interface LiterarioRepository extends CrudRepository<Literario, Integer> {

	Collection<Literario> findByTema(String tema);
	
	public Collection<Literario> findAll(Sort by);
	
	List<Literario> findByBibliotecaId(int bibliotecaId);
}