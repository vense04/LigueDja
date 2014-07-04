package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TAB_ENTRADA database table.
 * 
 */
@Entity
@Table(name = "TAB_ENTRADA")
@NamedQuery(name = "Entrada.findAll", query = "SELECT t FROM Entrada t")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int codEntrada;

	@Temporal(TemporalType.DATE)
	private Date data;

	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name="codProduto")
	private Produto produto;

	public Integer getCodEntrada() {
		return codEntrada;
	}

	public void setCodEntrada(Integer codEntrada) {
		this.codEntrada = codEntrada;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}