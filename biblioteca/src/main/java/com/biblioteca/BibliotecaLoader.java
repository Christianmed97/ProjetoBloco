package com.biblioteca;

import java.io.BufferedReader;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.biblioteca.model.Biblioteca;
import com.biblioteca.model.Endereco;
import com.biblioteca.service.BibliotecaService;
import com.biblioteca.service.EnderecoService;


@Order(1)
@Component
public class BibliotecaLoader implements ApplicationRunner{
	
	@Autowired
	public BibliotecaService bibliotecaService;
	@Autowired
	public EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		

		
		FileReader fr=new FileReader("arquivos/biblioteca.txt");
		BufferedReader br=new BufferedReader(fr);
		String linha = br.readLine();
		String[] campos = null;
		Biblioteca biblioteca = null;
		while(linha!=null) {	
			
		campos= linha.split(";");
			Endereco endereco= enderecoService.obterPorCep(campos[0]);
			biblioteca = new Biblioteca();
			biblioteca.setEndereco(endereco);
			biblioteca.setNome(campos[1]);
			biblioteca.setEmail(campos[2]);
			bibliotecaService.incluir(biblioteca);
		linha=br.readLine();
		}
		
		br.close();
	}

}
