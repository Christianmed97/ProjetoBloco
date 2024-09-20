package br.edu.infnet.AppChristian;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.AppChristian.model.domain.Academico;
import br.edu.infnet.AppChristian.model.domain.Biblioteca;
import br.edu.infnet.AppChristian.model.domain.Literario;
import br.edu.infnet.AppChristian.model.domain.Livro;
import br.edu.infnet.AppChristian.model.service.AcademicoService;
import br.edu.infnet.AppChristian.model.service.LiterarioService;
import br.edu.infnet.AppChristian.model.service.LivroService;

@Order(4)
@Component
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
		System.err.println("Livro");
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
				academico.setBiblioteca(new Biblioteca(Integer.valueOf(campos[8])));
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
				literario.setBiblioteca(new Biblioteca(Integer.valueOf(campos[9])));
				livroService.incluir(literario);		
			break;
		default:
			System.out.println("tipoInvalido");
			break;
		}
		
		linha=br.readLine();
		
		}
		for(Livro livro2: livroService.obterLista()) {
			System.out.println(livro2);
		}
		br.close();
	}

}
