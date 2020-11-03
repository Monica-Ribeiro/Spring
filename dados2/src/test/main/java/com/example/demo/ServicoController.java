package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//PONTO NO ENDERECO DO SITE
@RequestMapping("/hello")
@RestController
public class ServicoController {
	
	@GetMapping("/get1")
	public String hello1() {
		return "hey get1 hello world";
	}
	
	@GetMapping("/get2")
	public String hello2( ) {
		return "hey get2 hello world";
	}

	//INJETEI O REPOSTORIO PARA COMUNICAR COM A TABELA DO BANCO
		@Autowired
		private ServicoRepository repository;
		
		//GET COM FIND ALL(METODO)
		@GetMapping ("/servicos")
		public List<ServicoModel> pegarTodos() {		
			return repository.findAll();
		}

		//POST É RESPONSAVEL POR INSERIR
		@PostMapping("/servicos")
		public ServicoModel criar (@RequestBody ServicoModel tabelaServico) {
			repository.save(tabelaServico);
			return tabelaServico;
		}
}
