package br.edu.infnet.AppChristian.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppChristian.model.domain.Academico;

@Repository
public interface AcademicoRepository extends CrudRepository<Academico, Integer> {

	Collection<Academico> findByArea(String area);
	
	public Collection<Academico> findAll(Sort by);
}