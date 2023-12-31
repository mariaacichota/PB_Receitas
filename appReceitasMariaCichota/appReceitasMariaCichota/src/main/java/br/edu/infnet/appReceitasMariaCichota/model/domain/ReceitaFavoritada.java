package br.edu.infnet.appReceitasMariaCichota.model.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "receita_favoritada")
public class ReceitaFavoritada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idReceita")
	private Receita receita;
	
	private Date dataModificacao;
	private int iLike;
	private int iDeslike;
	
	public String formatDate(Date data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        return dateFormat.format(data);
    }
	
	public ReceitaFavoritada(Integer id) {
		this.Id = id;
	}
	
	public ReceitaFavoritada() {
	}
	
	@Override
	public String toString() {

		return String.format("Codigo (%d) - Codigo Usuario (%s) - Codigo Receita (%s) - Like (%d) - Deslike (%d) ", 
				Id, usuario, receita, iLike, iDeslike
			);
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Receita getCodigoReceita() {
		return receita;
	}
	
	public void setCodigoReceita(Receita receita) {
		this.receita = receita;
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
