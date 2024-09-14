package com.endereco.repository;

import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

import com.endereco.model.Endereco;


@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

}
