package br.edu.infnet.appReceitasMariaCichota.model.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
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
	private int codigo;
	private int codigoIngrediente;
	private String titulo;
	private String descricao;
	private double quantidade;
	private String medida;
	private int tempoPreparo;
	private String anexos;
	private String aprovada;
	private int codigoTipo;
	private String catalogada;
	private Date dataPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "idTipoReceita")
	private TipoReceita tipoReceita;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name = "idReceita")
    private List<Ingrediente> ingredientes;

	@Override
	public String toString() {

		return String.format("Codigo (%d) - Codigo Ingrediente (%d) - Título (%s) - Descrição (%s) - Quantidade (%d) - Medida (%s)"
				+ " - Tempo de Preparo (%d) - Anexos (%s) - Aprovada (%s) - Código Tipo (%d) - Catalogada (%s) - Data de Publicação (%s)"
				+ " - Tipo de Receita (%s) - Usuario (%s) - Ingredientes (%s) ", 
				codigo, codigoIngrediente, titulo, descricao, quantidade, medida, tempoPreparo, anexos, aprovada, codigoTipo, catalogada, 
				formatDate(dataPublicacao), tipoReceita, usuario, ingredientes
			);
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
	
	public void setDataPublicacao(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            this.dataPublicacao = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace(); 
        }
    }
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigoIngrediente() {
		return codigoIngrediente;
	}
	
	public void setCodigoIngrediente(int codigoIngrediente) {
		this.codigoIngrediente = codigoIngrediente;
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
	
	public int getCodigoTipo() {
		return codigoTipo;
	}
	
	public void setCodigoTipo(int codigoTipo) {
		this.codigoTipo = codigoTipo;
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

	public Date getDataPublicacao() {
		return dataPublicacao;
	}
}
