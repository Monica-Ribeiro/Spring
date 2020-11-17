package integracao.bancodedados.contatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
	ContatoModel findFirstByNome(String nome);
	List<ContatoModel>findAllByNomeIgnoreCaseContaining(String nome);
	
	
	}

	
