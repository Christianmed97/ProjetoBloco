package com.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Livro;



@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {

}