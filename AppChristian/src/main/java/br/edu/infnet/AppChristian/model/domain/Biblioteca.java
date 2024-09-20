package br.edu.infnet.AppChristian.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tabelaBiblioteca")
public class Biblioteca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message ="É necessario preencher o nome")
	private String nome;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idEndereco")
	private Endereco endereco;
	@Email(message="O email esta invalido")
	@Column(unique=true,name="cs_email")
	private String email;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name= "id_livro")
	@JsonManagedReference
	public List<Livro> livros;
	
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
	}
	
	public Biblioteca(Integer id) {
		this();
		this.setId(id);
	}

	@Override
	public String toString() {
		return String.format("%d - %s - Endereço: %s - %s - Livros: %s", id, nome,endereco,email,livros);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setLivro(List<Livro> livro) {
		this.livros = livro;
	}
	

	public List<Livro> getLivro() {
		return this.livros;
	}
	

}
