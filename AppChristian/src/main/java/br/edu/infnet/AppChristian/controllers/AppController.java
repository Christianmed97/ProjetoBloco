package br.edu.infnet.AppChristian.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.AppChristian.model.service.AcademicoService;
import br.edu.infnet.AppChristian.model.service.ApiService;
import br.edu.infnet.AppChristian.model.service.BibliotecaService;
import br.edu.infnet.AppChristian.model.service.EnderecoService;
import br.edu.infnet.AppChristian.model.service.LiterarioService;
import br.edu.infnet.AppChristian.model.service.LivroService;

@Controller
public class AppController {

	@Autowired
	private BibliotecaService bibliotecaService;
	@Autowired
	private LivroService livroService;
	@Autowired
	private LiterarioService literarioService;
	@Autowired
	private AcademicoService academicoService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private ApiService apiService;
	
	@GetMapping(value = "/")
	public String home(Model model){
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	
	@GetMapping(value = "/biblioteca/listagem")
	public String listarBiblioteca(Model model){
		model.addAttribute("titulo","Listagem de Bibliotecas");
		model.addAttribute("listagem", bibliotecaService.obterLista());
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	@GetMapping(value = "/livro/listagem")
	public String listarLivro(Model model){
		model.addAttribute("titulo","Listagem de Livros");
		model.addAttribute("listagem", livroService.obterLista());
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	@GetMapping(value = "/literario/listagem")
	public String listarLiterario(Model model){
		model.addAttribute("titulo","Listagem de Literarios");
		model.addAttribute("listagem", literarioService.obterLista());
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	@GetMapping(value = "/academico/listagem")
	public String listarAcademico(Model model){
		model.addAttribute("titulo","Listagem de Academicos");
		model.addAttribute("listagem", academicoService.obterLista());
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	@GetMapping(value = "/endereco/listagem")
	public String listarEndereco(Model model){
		model.addAttribute("titulo","Listagem de Enderecos");
		model.addAttribute("listagem", enderecoService.obterLista());
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	@GetMapping(value = "/openLivros/listagem")
	public String listarOpenLivros(Model model){
		model.addAttribute("titulo","Listagem de OpenLivros");
		model.addAttribute("listagem", apiService.obterLista());
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	@GetMapping(value = "/DetalhesOpenLivros/listagem")
	public String listarDetalhesOpenLivros(Model model, @RequestParam String titulo){
		model.addAttribute("titulo","Listagem de Detalhes");
		model.addAttribute("listagem", apiService.obterDetalhes(titulo));
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	@GetMapping(value = "/api/listagem")
	public String listarApi(Model model){
		model.addAttribute("titulo","Listagem da Api");
		model.addAttribute("listagem", apiService.teste());
		model.addAttribute("qtdeBiblioteca", bibliotecaService.quantidade());
		model.addAttribute("qtdeLivros", livroService.quantidade());
		model.addAttribute("qtdeLiterarios", literarioService.quantidade());
		model.addAttribute("qtdeAcademicos", academicoService.quantidade());
		model.addAttribute("qtdeEnderecos", enderecoService.quantidade());
		return "home";
	}
	
	
}
