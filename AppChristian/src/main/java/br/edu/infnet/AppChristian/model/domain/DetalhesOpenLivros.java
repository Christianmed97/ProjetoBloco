package br.edu.infnet.AppChristian.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalhesOpenLivros {

	@JsonProperty("title")
	private String title;
	@JsonProperty("first_publish_year")
	private String firstPublishYear;
	
	
	public String toString() {
		return String.format("Titulo: %s - Primeiro ano de Publicação: %s", title, firstPublishYear );
	}
}
