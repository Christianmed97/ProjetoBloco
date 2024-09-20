package com.biblioteca.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tabelaBiblioteca")
@Data
@AllArgsConstructor
public class Biblioteca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idEndereco")
	private Endereco endereco;
	@Column(name="cs_email")
	private String email;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name= "id_livro")
	public List<Livro> livros;
	
	public Biblioteca() {
	//	this.livros = new ArrayList<Livro>();
	}
	
	public Biblioteca(Integer id) {
		this();
		this.setId(id);
	}

	@Override
	public String toString() {
		return String.format("%d - %s - Endereço: %s - %s - Livros: %s", id, nome,endereco,email,livros);
	}
	
	

}
