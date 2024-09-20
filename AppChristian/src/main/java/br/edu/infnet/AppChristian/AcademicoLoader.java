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
import br.edu.infnet.AppChristian.model.service.AcademicoService;

@Order(2)
@Component
public class AcademicoLoader implements ApplicationRunner{
	
	@Autowired
	public AcademicoService academicoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("arquivos/academico.txt");
		BufferedReader br=new BufferedReader(fr);
		String linha = br.readLine();
		String[] campos = null;
		
		System.err.println("Academico");
		
		while(linha!=null) {
			
		campos= linha.split(";");
		
		Academico academico = new Academico();
		academico.setAutor(campos[0]);
		academico.setNome(campos[1]);
		academico.setNumeroPaginas(Integer.valueOf(campos[2]));
		academico.setPreco(Float.valueOf(campos[3]));
		academico.setSinopse(campos[4]);
		academico.setArea(campos[5]);
		academico.setVolume(campos[6]);
		academico.setBiblioteca(new Biblioteca(Integer.valueOf(campos[7])));
		academicoService.incluir(academico);
		
		linha=br.readLine();
		}
		for(Academico academico: academicoService.obterLista()) {
			System.out.println(academico);
		}
		br.close();
	}
}
