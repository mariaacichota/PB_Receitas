package br.edu.infnet.appReceitasMariaCichota.model.domain;

public class FeedBack {
	private int codigo;
	private String descricao;
	private int codigoUsuario;
	private int codigoReceita;
	private int like;
	private int deslike;
	
	@Override
	public String toString() {

		return String.format("Codigo (%d) - Descrição (%s) ", 
				codigo, descricao
			);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	public int getCodigoReceita() {
		return codigoReceita;
	}
	
	public void setCodigoReceita(int codigoReceita) {
		this.codigoReceita = codigoReceita;
	}
	
	public int getLike() {
		return like;
	}
	
	public void setLike(int like) {
		this.like = like;
	}
	
	public int getDeslike() {
		return deslike;
	}
	
	public void setDeslike(int deslike) {
		this.deslike = deslike;
	}
}
