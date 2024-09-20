package br.edu.infnet.ChristianAPI.domain;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenLivros {
	@JsonProperty("numFound")
	private Integer numFound;
	@JsonProperty("start")
	private Integer start;
	@JsonProperty("docs")
	private ArrayList<DetalhesOpenLivros> docs;
	private String nome;
	@Override
	public String toString(){

		return String.format(" Numero de livros com nome %s: %s ",nome, numFound  );

	}

	public OpenLivros() {
		
	}
	//public OpenLivros(ArrayList<String> docs) {
	//	super();
	//	this.docs = docs;
	//}

	public Integer getNumFound() {
		return numFound;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<DetalhesOpenLivros> getDocs() {
		return docs;
	}

	public void setDocs(ArrayList<DetalhesOpenLivros> docs) {
		this.docs = docs;
	}

	public void setNumFound(Integer numFound) {
		this.numFound = numFound;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	

	

	



	
	
}
