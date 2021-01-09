package org.generation.cadastro.repository;



import java.util.Optional;
import org.generation.cadastro.model.CadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*AQUI A INTERFACE IRÁ ERDAR A ENTIDADE QUE ESTAMOS TRABALHANDO QUE É A CadastroModel PELO EXTENDS
E ATRAVÉS DA INTERFACE JPA IREI PASSAR OS PARAMETROS DESSA ENTIDADE E O TIPO DO ID QUE É A NOSSA
CHAVE PRIMÁRIA OU SEJA É UM ID LONG.*/

@Repository//ESTA ANOTAÇÃO INDICA QUE ESSA CLASSE É UM REPOSITORY
public interface CadastroRepository extends JpaRepository<CadastroModel,Long>{
	Optional<CadastroModel> findByCpf(String cpf);// AQUI NAO SEI EXPLICAR OQUE ESTA ACONTECENDO E NEM O PORQUE DE USAR O OPTIONAL.

}


//COMO CRIAR A INTERFACE E EXPLICAR AS ANOTATIONS