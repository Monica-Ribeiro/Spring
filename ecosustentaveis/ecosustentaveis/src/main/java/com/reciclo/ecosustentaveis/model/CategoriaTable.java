package com.reciclo.ecosustentaveis.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class CategoriaTable {
	@Entity
	@Table(name="categoria")
	public class categoriaTable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String categoria_nome;
		
		private String categoria_descricao;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategoria_nome() {
			return categoria_nome;
		}

		public void setCategoria_nome(String categoria_nome) {
			this.categoria_nome = categoria_nome;
		}

		public String getCategoria_descricao() {
			return categoria_descricao;
		}

		public void setCategoria_descricao(String categoria_descricao) {
			this.categoria_descricao = categoria_descricao;
		}
		
		
		

	}


}
