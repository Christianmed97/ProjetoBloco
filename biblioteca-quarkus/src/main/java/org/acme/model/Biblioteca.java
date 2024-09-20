package org.acme.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;

@Entity
@Table(name = "tabelaBiblioteca")
@ApplicationScoped
public class Biblioteca extends PanacheEntity{
	
	public String nome;
	public int numero;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Biblioteca [nome=" + nome + ", numero=" + numero + "]";
	}
}
