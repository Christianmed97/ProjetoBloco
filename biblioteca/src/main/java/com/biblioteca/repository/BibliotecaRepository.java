package com.biblioteca.repository;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import com.biblioteca.model.Biblioteca;



public interface BibliotecaRepository extends CrudRepository<Biblioteca, Integer> {

	Optional<Biblioteca> findByEmail(String email);
	 
	 public Collection<Biblioteca> findAll(Sort by);
}