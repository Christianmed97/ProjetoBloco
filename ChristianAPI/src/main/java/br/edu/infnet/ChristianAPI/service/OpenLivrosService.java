package br.edu.infnet.ChristianAPI.service;

import java.util.ArrayList;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.ChristianAPI.clients.OpenLivrosClient;
import br.edu.infnet.ChristianAPI.domain.DetalhesOpenLivros;
import br.edu.infnet.ChristianAPI.domain.OpenLivros;


@Service
public class OpenLivrosService {
	
	@Autowired
	private OpenLivrosClient openLivrosClient;
	
	
	//public Collection<OpenLivros> obterPorTitulo(){
	//	ArrayList<OpenLivros> lista = new ArrayList<OpenLivros>(Arrays.asList(new OpenLivros("senhor,tolkien,1997"),new OpenLivros("senhor2,tolkien2,1777")));
		
	//	return (Collection<OpenLivros>) lista;
	//}	
	public Collection<OpenLivros> obterLista(ArrayList<String> listaDeNomes){
		ArrayList<OpenLivros> lista = new ArrayList<OpenLivros>();
		for (String s : listaDeNomes) {
			OpenLivros opLivro=openLivrosClient.obterPorTitulo(s);
			opLivro.setNome(s);
			lista.add(opLivro);
		}
		return lista;
	}	
	public Collection<DetalhesOpenLivros> obterDetalhes(String titulo){
		ArrayList<DetalhesOpenLivros> lista = openLivrosClient.obterPorTitulo(titulo).getDocs();		
		return lista;
	}
	
	
}
