package br.edu.infnet.appReceitasMariaCichota.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "idReceita")
	private Receita receita;

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	@Override
	public String toString() {

		return String.format("Código (%d) - Descrição (%s) ", 
				Id, descricao
			);
	}

	public Ingrediente (Integer id) {
		this.Id = id;
	}

	public Ingrediente () {
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
