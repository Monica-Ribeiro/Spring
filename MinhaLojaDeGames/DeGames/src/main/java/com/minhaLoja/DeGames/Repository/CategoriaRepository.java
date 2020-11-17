package com.minhaLoja.DeGames.Repository;
//ESTE É O REPOSITORIO DA ENTIDADE CATEGORIA.JAVA
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.minhaLoja.DeGames.Model.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List <Categoria> findAllByTituloContainingIgnoreCase(String titulo);

}
