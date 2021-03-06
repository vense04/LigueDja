package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
	private Integer codEntrada;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int quantidade;

	// bi-directional one-to-one association to TabProduto
	@OneToOne
	@JoinColumn(name = "codProduto")
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
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