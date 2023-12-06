package br.edu.infnet.appReceitasMariaCichota.model.domain;

public class Ingrediente {
	private int codigo;
	private String descricao;
	
	@Override
	public String toString() {

		return String.format("Código (%d) - Descrição (%s) ", 
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
}
