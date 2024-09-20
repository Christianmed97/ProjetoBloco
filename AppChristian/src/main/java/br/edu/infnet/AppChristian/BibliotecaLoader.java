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
import br.edu.infnet.AppChristian.model.domain.Endereco;
import br.edu.infnet.AppChristian.model.domain.Literario;
import br.edu.infnet.AppChristian.model.service.AcademicoService;
import br.edu.infnet.AppChristian.model.service.BibliotecaService;
import br.edu.infnet.AppChristian.model.service.EnderecoService;
import br.edu.infnet.AppChristian.model.service.LiterarioService;

@Order(1)
@Component
public class BibliotecaLoader implements ApplicationRunner{
	
	@Autowired
	public BibliotecaService bibliotecaService;
	@Autowired
	public AcademicoService academicoService;
	@Autowired
	public LiterarioService literarioService;
	@Autowired
	public EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		

		
		FileReader fr=new FileReader("arquivos/biblioteca.txt");
		BufferedReader br=new BufferedReader(fr);
		String linha = br.readLine();
		String[] campos = null;
		Biblioteca biblioteca = null;
		System.err.println("Biblioteca");
		while(linha!=null) {	
			
		campos= linha.split(";");
		switch(campos[0].toUpperCase()) {
		case "B":
			System.out.println("teste"+campos[1]);
			Endereco endereco= enderecoService.obterPorCep(campos[1]);
			biblioteca = new Biblioteca();
			biblioteca.setEndereco(endereco);
			biblioteca.setNome(campos[2]);
			biblioteca.setEmail(campos[3]);
			bibliotecaService.incluir(biblioteca);
			break;
		case "A": 
			Academico academico = new Academico();
			academico.setAutor(campos[1]);
			academico.setNome(campos[2]);
			academico.setNumeroPaginas(Integer.valueOf(campos[3]));
			academico.setPreco(Float.valueOf(campos[4]));
			academico.setSinopse(campos[5]);
			academico.setArea(campos[6]);
			academico.setVolume(campos[7]);
			academico.setBiblioteca(biblioteca);
			academicoService.incluir(academico);
			biblioteca.getLivro().add(academico);
		break;
	case "L":
			Literario literario = new Literario();
			literario.setAutor(campos[1]);
			literario.setNome(campos[2]);
			literario.setNumeroPaginas(Integer.valueOf(campos[3]));
			literario.setPreco(Float.valueOf(campos[4]));
			literario.setSinopse(campos[5]);
			literario.setTema(campos[6]);
			literario.setInfantil(Boolean.valueOf(campos[7]));
			literario.setTipo(campos[8]);
			literario.setBiblioteca(biblioteca);
			literarioService.incluir(literario);
			biblioteca.getLivro().add(literario);
		break;
		}
		
		linha=br.readLine();
		}
		for(Biblioteca biblioteca1: bibliotecaService.obterLista()) {
			System.out.println("lista "+biblioteca1);
		}
		
		br.close();
	}

}
