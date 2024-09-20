package com.livro.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.livro.model.Livro;


@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {

	List<Livro> findByBibliotecaId(int bibliotecaId);
	
	 public Collection<Livro> findAll(Sort by);
}