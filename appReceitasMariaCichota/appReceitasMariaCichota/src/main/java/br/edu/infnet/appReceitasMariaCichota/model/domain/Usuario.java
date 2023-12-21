package br.edu.infnet.appReceitasMariaCichota.model.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private int codigo;
	private String nome;
	
	@OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	private String email;
	private String telefone;
	private String senha;
	private String foto;
	private String descricao;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private List<Receita> receitas;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private List<FeedBack> feedbacks;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private List<ReceitaFavoritada> receitaFavoritadas;
	
	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public List<FeedBack> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<ReceitaFavoritada> getReceitaFavoritadas() {
		return receitaFavoritadas;
	}

	public void setReceitaFavoritadas(List<ReceitaFavoritada> receitaFavoritadas) {
		this.receitaFavoritadas = receitaFavoritadas;
	}

	public Usuario(Integer codigo, String nome, Endereco endereco, String email, String telefone, String senha,
			String foto, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.foto = foto;
		this.descricao = descricao;
	}

	public Usuario() {
	}

	@Override
	public String toString() {

		return String.format(
				"Codigo (%d) - Nome (%s) - E-mail (%s) - Telefone (%s) - Senha (%s) - Foto (%s) - Descrição (%s)",
				codigo, nome, email, telefone, senha, foto, descricao);
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public Usuario(Integer id) {
		this.Id = id;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
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
