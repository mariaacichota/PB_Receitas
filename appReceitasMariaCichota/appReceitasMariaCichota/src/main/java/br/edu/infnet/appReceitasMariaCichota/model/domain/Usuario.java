package br.edu.infnet.appReceitasMariaCichota.model.domain;

public class Usuario {
	private int codigo;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private String senha;
	private String foto;
	private String descricao;
	
	@Override
	public String toString() {

		return String.format("Codigo (%d) - Nome (%s) - E-mail (%s) - Telefone (%s) - Senha (%s) - Foto (%s) - Descrição (%s)", 
				codigo, nome, email, telefone, senha, foto, descricao
			);
	}

	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
