package com.biblioteca.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tabelaLivro")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cs_nome")
	private String nome;
	@Column(name = "cs_autor")
	private String autor;
	@Column(name = "qt_numeroPaginas")
	private int numeroPaginas;
	@Column(name = "vl_preco")
	private float preco;
	private String sinopse;
	@ManyToOne
	@JoinColumn(name = "id_livro")
	@JsonBackReference
	private Biblioteca biblioteca;
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	private int bibliotecaId;
	
	
	public int getBibliotecaId() {
		return bibliotecaId;
	}
	public void setBibliotecaId(int bibliotecaId) {
		this.bibliotecaId = bibliotecaId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
	 return String.format("%d - %s - %s - %d -%f - %s",id, nome,autor, numeroPaginas,preco,sinopse);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

}
