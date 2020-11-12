package integracao.bancodedados.contatos;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import integracao.bancodedados.ContatoModel;
import integracao.bancodedados.ContatoRepository;

//RUN WITH RODARÁ COM O SPRING RUNNER
//QUE SUPORTA TESTES DE INTEGRAÇÃO DE INTERFACES
@RunWith(SpringRunner.class)
@DataJpaTest
public class ContatosRepositoryIntegrationTest {
	private ContatoModel contato;
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Before
	public void start() {
		contato = new ContatoModel("Gabriel","Olly","9xxxxxxx9");
	}
	
	//regra, não aceita exceções, é a maneira de especificar que a execução de um teste lançará uma exceção
	@Rule
	public ExpectedException esperadaExcecao = ExpectedException.none();

	@Test
	public void salvarComTelNulo() throws Exception{
		esperadaExcecao.expect(ConstraintViolationException.class);
		esperadaExcecao.expectMessage("O Telefone deve ser preenchido");
		
		contato.setTelefone(null);
		contatoRepository.save(contato);
	}
	
	
	
	
	
	
	
	
	
	
	
}