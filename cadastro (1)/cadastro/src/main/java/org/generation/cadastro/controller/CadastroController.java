package org.generation.cadastro.controller;

import org.generation.cadastro.model.CadastroModel;
import org.generation.cadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//ESTA ANOTAÇÃO INDICA QUE ESSA CLASSE É UM CONTROLLER
@RequestMapping("/Cadastro")//ESSA ANOTAÇÃO INDICA POR QUAL URL ESSA CLASSE SERÁ ACESSADA
@CrossOrigin("*")//COM ESSA ANOTAÇÃO ESTOU INDICANDO QUE ESSA CLASSE IRÁ ACEITAR REQUISIÇÕES DE QUALQUER ORIGEM
public class CadastroController {
	/* DEPOIS DE CONFIGURAR O CONTROLLER A PRIMEIRA COISA QUE TEMOS QUE FAZER É INJETAR A INTERFACE DO 
	 * REPOSITÓRIO(REPOSITORY) AQUI DENTRO DO CONTROLER QUE SERIA CHAMANDO A INTERFACE CadastroRepository E 
	 * LOGO EM SEGUIDA LHE DANDO O NOME:"repository".NESSE CASO PARA CONSEGUIR INSTANCIÁ-LA É NESCESSÁRIO USAR
	 * A ANOTAÇÃO DE INJEÇÃO DE DEPENDENCIAS DO SPRING QUE É A @Autowired GARANTINDO QUE TODOS OS SERVIÇOS DA 
	 * INTERFACE SEJA ACESSADO A PARTIR DO CONTROLLER:*/
	@Autowired
	private CadastroRepository repository;

	//LOGO EM SEGUIDA SERÁ CRIADO UM MÉTODO PARA CADASTRAR O USUÁRIO:
	@PostMapping("/cadastro")
	public ResponseEntity<CadastroModel> post (@RequestBody CadastroModel cadastro) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(cadastro));
	}
}
