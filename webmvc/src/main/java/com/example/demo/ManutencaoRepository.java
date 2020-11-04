package com.example.demo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<ManutencaoTable, Long> {

	Optional<ManutencaoTable> findByNomeAndCategoria(String nome, String categoria);
	

}
