package br.edu.infnet.AppChristian.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppChristian.model.domain.Biblioteca;

@Repository
public interface BibliotecaRepository extends CrudRepository<Biblioteca, Integer> {

	 Biblioteca findByEmail(String email);
	 
	 public Collection<Biblioteca> findAll(Sort by);
}