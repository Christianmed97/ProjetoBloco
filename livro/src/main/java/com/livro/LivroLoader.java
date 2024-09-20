package com.livro;

import java.io.BufferedReader;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.livro.model.Academico;
import com.livro.model.Literario;
import com.livro.model.Livro;
import com.livro.service.AcademicoService;
import com.livro.service.LiterarioService;
import com.livro.service.LivroService;

import lombok.extern.slf4j.Slf4j;


@Order(4)
@Component
@Slf4j
public class LivroLoader implements ApplicationRunner{
	
	@Autowired
	public LivroService livroService;
	@Autowired
	public AcademicoService academicoService;
	@Autowired
	public LiterarioService literarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader fr=new FileReader("arquivos/livro.txt");
		BufferedReader br=new BufferedReader(fr);
		String linha = br.readLine();
		String[] campos = null;
		log.info("Livro");
		while(linha!=null) {	
			campos= linha.split(";");
		switch (campos[0]) {
		case "A": 
				Academico academico = new Academico();
				academico.setAutor(campos[1]);
				academico.setNome(campos[2]);
				academico.setNumeroPaginas(Integer.valueOf(campos[3]));
				academico.setPreco(Float.valueOf(campos[4]));
				academico.setSinopse(campos[5]);
				academico.setArea(campos[6]);
				academico.setVolume(campos[7]);
				academico.setBibliotecaId(Integer.valueOf(campos[8]));
				livroService.incluir(academico);
			break;
		case "L":				
				campos= linha.split(";");
				
				Literario literario = new Literario();
				literario.setAutor(campos[1]);
				literario.setNome(campos[2]);
				literario.setNumeroPaginas(Integer.valueOf(campos[3]));
				literario.setPreco(Float.valueOf(campos[4]));
				literario.setSinopse(campos[5]);
				literario.setTema(campos[6]);
				literario.setInfantil(Boolean.valueOf(campos[7]));
				literario.setTipo(campos[8]);
				literario.setBibliotecaId(Integer.valueOf(campos[9]));
				livroService.incluir(literario);		
			break;
		default:
			log.info("tipoInvalido");
			break;
		}
		
		linha=br.readLine();
		
		}
		br.close();
	}

}
