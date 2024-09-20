package com.livro.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.livro.model.Academico;


@Repository
public interface AcademicoRepository extends CrudRepository<Academico, Integer> {

	Collection<Academico> findByArea(String area);
	
	public Collection<Academico> findAll(Sort by);
	
	List<Academico> findByBibliotecaId(int bibliotecaId);
}