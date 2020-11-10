package com.minhaLoja.DeGames.Repository;
//ESTE É O REPOSITORIO DA ENTIDADE JOGOS.JAVA
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.minhaLoja.DeGames.Model.Jogos;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Long> {
	public List <Jogos> findAllByTituloContainingIgnoreCase(String titulo);
}
