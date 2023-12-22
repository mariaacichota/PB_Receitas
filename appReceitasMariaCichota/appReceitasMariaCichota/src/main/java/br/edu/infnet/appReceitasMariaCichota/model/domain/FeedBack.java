package br.edu.infnet.appReceitasMariaCichota.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "feed_back")
public class FeedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	private String descricao;

	@ManyToOne
	@JoinColumn(name = "idReceita")
	private Receita receita;
	
	private int iLike;
	private int iDeslike;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {

		return String.format("Codigo (%d) - Descrição (%s) ", Id, descricao);
	}
	
	public FeedBack (Integer id) {
		this.Id = id;
	}
	
	public FeedBack () {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Receita getCodigoReceita() {
		return receita;
	}

	public void setCodigoReceita(Receita receita) {
		this.receita = receita;
	}

	public int getiLike() {
		return iLike;
	}

	public void setiLike(int iLike) {
		this.iLike = iLike;
	}

	public int getiDeslike() {
		return iDeslike;
	}

	public void setiDeslike(int iDeslike) {
		this.iDeslike = iDeslike;
	}

}
