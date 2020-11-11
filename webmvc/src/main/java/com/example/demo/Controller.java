package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/teste")

public class Controller implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry index) 
	{
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	@Autowired
	private ManutencaoRepository repository;

	//LOCALHOST:8080/MANUTENCOES
	@GetMapping("/manutencoes")
	public List<ManutencaoTable> buscarTodos() {
		return repository.findAll();
	}
	
	//POST É INSERIR, (LOCALHOST:8080/MANUTENCOES)
	@PostMapping("/manutencoes")
	public ManutencaoTable criar(@RequestBody ManutencaoTable objetoManutencao) {
		repository.save(objetoManutencao);
		return objetoManutencao;
	}
	
//	@GetMapping("/manutencoes/id/{id}")
//	public ResponseEntity<ManutencaoTable> getById(@PathVariable long id){
//		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
//				.orElse(ResponseEntity.notFound().build());
//	}

	//DESTE JEITO NÃO RETORNAR ERRO
	@GetMapping("/manutencoes/id/{id}")
	public Optional<ManutencaoTable> buscarUm(@PathVariable Long id) {
		return repository.findById(id);
	}
		
	@PutMapping("/manutencoes/{id}")
		public ManutencaoTable atualizar(@PathVariable Long id, @RequestBody ManutencaoTable objetinho) 
	{
	objetinho.setId(id); //FORÇA A ALTERAÇÃO DO BODY, SETAR = MUDAR
	repository.save(objetinho);
	return objetinho;
	}
	
	//GET COM 2 ATRIBUTOS
	@GetMapping ("/manutencoes/{nome}/{categoria}")
	public Optional<ManutencaoTable> buscarPorNomeECategoria(@PathVariable String nome,@PathVariable String categoria) 
	{		
		return repository.findByNomeAndCategoria(nome, categoria);
	}
	
	
	@DeleteMapping("/manutencoes/{id}")
	public void delete (@PathVariable Long id) {
		 repository.deleteById(id);   
	}
	
	@Autowired
	private Services Services;
	
	@GetMapping("/teste")
    public ResponseEntity<List<ManutencaoTable>> listAllItens() {
        List<ManutencaoTable> itens= Services.findAllItems();
        if(itens.isEmpty()){
            return new ResponseEntity<List<ManutencaoTable>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ManutencaoTable>>(itens, HttpStatus.ACCEPTED);
    }



}