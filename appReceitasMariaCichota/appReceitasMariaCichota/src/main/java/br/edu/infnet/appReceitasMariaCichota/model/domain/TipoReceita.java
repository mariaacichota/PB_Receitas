package br.edu.infnet.appReceitasMariaCichota.model.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_receita")
public class TipoReceita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String descricao;
	
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idTipoReceita")
	private List<Receita> receitas;
	
	public TipoReceita(String descricao) {
		this.descricao = descricao;
	}

	public TipoReceita() {
	}

	public TipoReceita(Integer id) {
		this.Id = id;
	}
	
	@Override
	public String toString() {

		return String.format("Código (%d) - Descrição (%s) ", 
				Id, descricao
			);
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
