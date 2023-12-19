package br.edu.infnet.appReceitasMariaCichota.model.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
public class ReceitaFavoritada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	private int codigoReceita;
	private Date dataModificacao;
	private int like;
	private int deslike;
	
	public String formatDate(Date data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        return dateFormat.format(data);
    }
	
	@Override
	public String toString() {

		return String.format("Codigo (%d) - Codigo Usuario (%s) - Codigo Receita (%s) - Data Modificacao (%s) - Like (%d) - Deslike (%d) ", 
				codigo, usuario, codigoReceita, formatDate(dataModificacao), like, deslike
			);
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCodigoReceita() {
		return codigoReceita;
	}
	
	public void setCodigoReceita(int codigoReceita) {
		this.codigoReceita = codigoReceita;
	}
	
	public Date getDataModificacao() {
		return dataModificacao;
	}
	
	public void setDataModificacao(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 

        try {
            this.dataModificacao = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace(); 
        }
	}
}
