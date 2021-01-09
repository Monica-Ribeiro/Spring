package org.generation.cadastro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity//ESTA ANOTAÇÃO ESTÁ INDICANDO QUE ESSE COMPONENTE É UMA MODEL/ENTIDADE
@Table(name = "Cadastro_Usuario")//ESTA ANOTAÇÃO IRÁ CRIAR UMA TABELA NO BANCO DE DADOS
public class CadastroModel {

	//CRIANDO OS ATRIBUTOS:
	@Id//AQUI ESTOU INDICANDO QUE ESSE ATRIBUTO SE TRATA DE UM ID DO CADASTRO_USUARIO.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//AQUI ESTOU INDICANDO QUE ESSE VALOR SERÁ GERADO NO QUAL 
	private Long id;//A ESTRATÉGIA SERÁ UMA IDENTIDAE(IDENTITY) CRIANDO ENTÃO UMA CHAVE PRIMÁRIA
	
	@NotNull//AQUI ESTOU DETERMINADO QUE NENHUM NOME PODE VIR VAZIO
	//@Size AQUI ESTOU DETERMINANDO A QUANTIDADE DE CARACTERE QUE O CLIENTE CONSEGUE ENVIAR COMO NOME
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String cpf;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date dataNasc;
	
	
	/*GERANDO OS GETTERS E SETTERS,AQUI PARA GERAR BASTA CLICAR COM BOTÃO DIREITO DO MOUSE E CLICAR EM
	"Source" E EM SEGUIDA CLICAR EM "Generate GETTERS and SETTERS" E SELECIONAR OS ATRIBUTOS CRIADOS PARA GERAR.*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
	
	
}
