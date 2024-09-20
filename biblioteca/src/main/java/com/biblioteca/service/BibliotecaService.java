package com.biblioteca.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.biblioteca.model.Academico;
import com.biblioteca.model.Biblioteca;
import com.biblioteca.model.Endereco;
import com.biblioteca.model.Literario;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.BibliotecaRepository;
import com.biblioteca.repository.LivroRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class BibliotecaService {
	
	public final BibliotecaRepository bibliotecaRepository;
	
	public final EnderecoService enderecoService;

	public final LivroService livroService;
	
	public final LivroRepository livroRepository;
	
	public Biblioteca incluir(Biblioteca biblioteca) {
		try {
			Endereco endereco= enderecoService.obterPorCep(biblioteca.getEndereco().getCep());
			biblioteca.setEndereco(endereco);
			bibliotecaRepository.save(biblioteca);
			List<Literario> literarios= livroService.obterLiterarioPorIdBiblioteca(biblioteca.getId());
			log.info("teste1");
			List<Academico> academicos= livroService.obterAcademicoPorIdBiblioteca(biblioteca.getId());
			log.info("teste2");
			List<Livro> livros= new ArrayList<>();
			for (Literario l : literarios) {
				livros.add(l);
			}
			for (Academico a : academicos) {
				livros.add(a);
			}
			for (Livro livro : livros) {
				livro.setBiblioteca(biblioteca);
				livroRepository.save(livro);
			}
			log.info("incluir livro" + livros);
			biblioteca.setLivros(livros);
			bibliotecaRepository.save(biblioteca);
			return biblioteca;
		}catch(Exception e){
				log.error("[ERROR] "+ e.getMessage());
				return biblioteca;
				}
		}
		
	public Collection<Biblioteca> obterLista(){
		return (Collection<Biblioteca>) bibliotecaRepository.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	public Optional<Biblioteca> obterPorId(Integer id) {
		return bibliotecaRepository.findById(id);
	}
	public Optional<Biblioteca> obterPorEmail(String email) {
		return bibliotecaRepository.findByEmail(email);
	}
	public void excluir(Integer id) {
		bibliotecaRepository.deleteById(id);
	}
	public Biblioteca atualizar(Biblioteca biblioteca) {
		try {
			log.info("incluir endereco");
			Endereco endereco= enderecoService.obterPorCep(biblioteca.getEndereco().getCep());
			biblioteca.setEndereco(endereco);
			bibliotecaRepository.save(biblioteca);
			log.info("incluir livro" + biblioteca.getId());
			List<Literario> literarios= livroService.obterLiterarioPorIdBiblioteca(biblioteca.getId());
			List<Academico> academicos= livroService.obterAcademicoPorIdBiblioteca(biblioteca.getId());
			List<Livro> livros= new ArrayList<>();
			for (Literario l : literarios) {
				livros.add(l);
			}
			for (Academico a : academicos) {
				livros.add(a);
			}
			for (Livro livro : livros) {
				livro.setBiblioteca(biblioteca);
				livroRepository.save(livro);
			}
			log.info("incluir livro" + livros);
			biblioteca.setLivros(livros);
			bibliotecaRepository.save(biblioteca);
			return biblioteca;
		}catch(Exception e){
				log.error("[ERROR] "+ e.getMessage());
				return biblioteca;
				}
		}
	public long quantidade() {
		return bibliotecaRepository.count();
	}
}
