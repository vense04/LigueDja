package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TAB_PEDIDO database table.
 * 
 */
@Entity
@Table(name="TAB_PEDIDO")
@NamedQuery(name="Pedido.findAll", query="SELECT t FROM Pedido t")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="codPedido"
	 */
	@Id
	private int codPedido;

	/**
	 * @uml.property  name="datPagamento"
	 */
	@Temporal(TemporalType.DATE)
	private Date datPagamento;

	/**
	 * @uml.property  name="datPedido"
	 */
	@Temporal(TemporalType.DATE)
	private Date datPedido;

	/**
	 * @uml.property  name="estado"
	 */
	private String estado;

	//bi-directional one-to-one association to TabItemPedido
	/**
	 * @uml.property  name="tabItemPedido"
	 * @uml.associationEnd  inverse="tabPedido:model.TabItemPedido"
	 */
	@OneToOne(mappedBy="pedido")
	private ItemPedido itemPedido;

	//bi-directional many-to-one association to TabUsuario
	/**
	 * @uml.property   name="tabUsuario"
	 * @uml.associationEnd   inverse="tabPedidos:model.Usuario"
	 */
	@ManyToOne
	@JoinColumn(name="codUsuario")
	private Usuario usuario;

	public Pedido() {
	}

	/**
	 * @return
	 * @uml.property  name="codPedido"
	 */
	public int getCodPedido() {
		return this.codPedido;
	}

	/**
	 * @param codPedido
	 * @uml.property  name="codPedido"
	 */
	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	/**
	 * @return
	 * @uml.property  name="datPagamento"
	 */
	public Date getDatPagamento() {
		return this.datPagamento;
	}

	/**
	 * @param datPagamento
	 * @uml.property  name="datPagamento"
	 */
	public void setDatPagamento(Date datPagamento) {
		this.datPagamento = datPagamento;
	}

	/**
	 * @return
	 * @uml.property  name="datPedido"
	 */
	public Date getDatPedido() {
		return this.datPedido;
	}

	/**
	 * @param datPedido
	 * @uml.property  name="datPedido"
	 */
	public void setDatPedido(Date datPedido) {
		this.datPedido = datPedido;
	}

	/**
	 * @return
	 * @uml.property  name="estado"
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * @param estado
	 * @uml.property  name="estado"
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return
	 * @uml.property  name="tabItemPedido"
	 */
	public ItemPedido getItemPedido() {
		return this.itemPedido;
	}

	/**
	 * @param itemPedido
	 * @uml.property  name="tabItemPedido"
	 */
	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	/**
	 * @return
	 * @uml.property  name="tabUsuario"
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * @param usuario
	 * @uml.property  name="tabUsuario"
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}