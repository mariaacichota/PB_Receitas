package br.edu.infnet.appReceitasMariaCichota.model.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Receita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String titulo;
	private String descricao;
	private double quantidade;
	private String medida;
	private int tempoPreparo;
	private String anexos;
	private String aprovada;
	private String catalogada;
	private LocalDate dataPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "idTipoReceita")
	private TipoReceita tipoReceita;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idReceita")
    private List<Ingrediente> ingredientes;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idReceita")
	private List<ReceitaFavoritada> receitaFavoritada;
	

	@Override
	public String toString() {

		return String.format("Codigo (%d) - Título (%s) - Descrição (%s) - Quantidade (%f) - Medida (%s)"
		        + " - Tempo de Preparo (%d) - Anexos (%s) - Aprovada (%s) - Catalogada (%s)"
		        + " - Tipo de Receita (%s) - Usuario (%s)",
		        Id, titulo, descricao, quantidade, medida, tempoPreparo, anexos, aprovada, catalogada,
		        tipoReceita, usuario
		);
	}
	
	public List<ReceitaFavoritada> getReceitaFavoritada() {
		return receitaFavoritada;
	}

	public void setReceitaFavoritada(List<ReceitaFavoritada> receitaFavoritada) {
		this.receitaFavoritada = receitaFavoritada;
	}

	
	public Receita(Integer id) {
		this.Id = id;
	}
	
	public Receita() {
	}
	
	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String formatDate(Date data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        return dateFormat.format(data);
    }
	
	public void setDataPublicacao(LocalDate dataPublicacao2) {
		this.dataPublicacao = dataPublicacao2;
    }
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getMedida() {
		return medida;
	}
	
	public void setMedida(String medida) {
		this.medida = medida;
	}
	
	public int getTempoPreparo() {
		return tempoPreparo;
	}
	
	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
	
	public String getAnexos() {
		return anexos;
	}
	
	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}
	
	public String getAprovada() {
		return aprovada;
	}

	public void setAprovada(String aprovada) {
		this.aprovada = aprovada;
	}

	public String getCatalogada() {
		return catalogada;
	}

	public void setCatalogada(String catalogada) {
		this.catalogada = catalogada;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
}
