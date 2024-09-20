package br.edu.infnet.AppChristian.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppChristian.model.domain.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {

	Collection<Livro> findByAutor(String Autor);
	
	 public Collection<Livro> findAll(Sort by);
}