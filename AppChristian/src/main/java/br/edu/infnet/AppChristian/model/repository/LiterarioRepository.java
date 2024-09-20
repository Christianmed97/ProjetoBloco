package br.edu.infnet.AppChristian.model.repository;


import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppChristian.model.domain.Literario;

@Repository
public interface LiterarioRepository extends CrudRepository<Literario, Integer> {

	Collection<Literario> findByTema(String tema);
	
	public Collection<Literario> findAll(Sort by);
}