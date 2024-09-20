package br.edu.infnet.AppChristian;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.AppChristian.model.domain.Biblioteca;
import br.edu.infnet.AppChristian.model.domain.Literario;
import br.edu.infnet.AppChristian.model.service.LiterarioService;

@Order(3)
@Component
public class LiterarioLoader implements ApplicationRunner{
	
	@Autowired
	public LiterarioService literarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader fr=new FileReader("arquivos/literario.txt");
		BufferedReader br=new BufferedReader(fr);
		String linha = br.readLine();
		String[] campos = null;
		
		System.err.println("Literario");
		while(linha!=null) {	
			
			campos= linha.split(";");
			
			Literario literario = new Literario();
			literario.setAutor(campos[0]);
			literario.setNome(campos[1]);
			literario.setNumeroPaginas(Integer.valueOf(campos[2]));
			literario.setPreco(Float.valueOf(campos[3]));
			literario.setSinopse(campos[4]);
			literario.setTema(campos[5]);
			literario.setInfantil(Boolean.valueOf(campos[6]));
			literario.setTipo(campos[7]);
			literario.setBiblioteca(new Biblioteca(Integer.valueOf(campos[8])));
			literarioService.incluir(literario);
			
			linha=br.readLine();
	}
			for(Literario literario: literarioService.obterLista()) {
				System.out.println(literario);
			}
			br.close();
}
}