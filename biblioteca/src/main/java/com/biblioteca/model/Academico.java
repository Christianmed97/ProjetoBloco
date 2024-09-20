package com.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tabelaAcademico")
public class Academico extends Livro {
	
	private String area;
	@Column(name="cs_volume")
	private String volume;
	
	@Override
	public String toString() {
		 return String.format("%s - %s - %s",super.toString(), area,volume);
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}

}
