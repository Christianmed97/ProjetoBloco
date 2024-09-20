package br.edu.infnet.AppChristian.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppChristian.model.domain.Academico;
import br.edu.infnet.AppChristian.model.repository.AcademicoRepository;

@Service
public class AcademicoService {

	@Autowired
	public AcademicoRepository academicoRepository;
	
	public void incluir(Academico academico) {
		try {
			academicoRepository.save(academico);
			}catch(Exception e) {
				System.err.println("[ERROR] "+ e.getMessage());
			}
	}
	public Collection<Academico> obterLista(){
		return (Collection<Academico>) academicoRepository.findAll();
	}

	public Collection<Academico> obterListaDecrescente(){
		return (Collection<Academico>) academicoRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Academico obterPorId(Integer id) {
		return academicoRepository.findById(id).orElse(null);
	}

	public Collection<Academico> obterPorArea(String area) {
		return academicoRepository.findByArea(area);
	}
	public void excluir(Integer id) {
		academicoRepository.deleteById(id);
	}
	public long quantidade() {
		return academicoRepository.count();
	}
}
