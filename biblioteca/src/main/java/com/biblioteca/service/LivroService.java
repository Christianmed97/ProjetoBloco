package com.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.model.Academico;
import com.biblioteca.model.Literario;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.service.clients.LivroClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class LivroService {
	@Autowired
	private LivroClient livroClient;
	@Autowired
	private LivroRepository livroRepository;
	private static Map<Integer, List<Livro>> CACHELITERARIO= new ConcurrentHashMap<>();
	private static Map<Integer, List<Livro>> CACHEACADEMICO= new ConcurrentHashMap<>();
	
	@CircuitBreaker(name = "livroService",fallbackMethod = "buscarNoCacheLiterario")
	public List<Literario> obterLiterarioPorIdBiblioteca(Integer bibliotecaId) {
		List<Literario> literarios = livroClient.obterLiterarioPorIdBiblioteca(bibliotecaId);
		List<Livro> livros= new ArrayList<>();
		for (Literario l : literarios) {
			livros.add(l);
			livroRepository.save(l);
		}
		CACHELITERARIO.put(bibliotecaId, livros);
		return literarios;
	}
	@CircuitBreaker(name = "livroService",fallbackMethod = "buscarNoCacheAcademico")
	public List<Academico> obterAcademicoPorIdBiblioteca(Integer bibliotecaId) {
		List<Academico> academicos = livroClient.obterAcademicoPorIdBiblioteca(bibliotecaId);
		List<Livro> livros= new ArrayList<>();
		for (Academico a : academicos) {
			livros.add(a);
			livroRepository.save(a);
		}	
		CACHEACADEMICO.put(bibliotecaId, livros);
		return academicos;
	}
	public List<Livro> buscarNoCacheLiterario(Integer bibliotecaId , Throwable e) {
		log.info("Buscando no cache");
		return CACHELITERARIO.getOrDefault(bibliotecaId,new ArrayList<>());
	}
	public List<Livro> buscarNoCacheAcademico(Integer bibliotecaId , Throwable e) {
		log.info("Buscando no cache");
		return CACHEACADEMICO.getOrDefault(bibliotecaId,new ArrayList<>());
	}
}
