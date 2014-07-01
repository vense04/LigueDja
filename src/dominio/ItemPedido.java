package dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TAB_ITEM_PEDIDO database table.
 * 
 */
@Entity
@Table(name="TAB_ITEM_PEDIDO")
@NamedQuery(name="ItemPedido.findAll", query="SELECT t FROM ItemPedido t")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="codPedido"
	 */
	@Id
	private int codPedido;

	/**
	 * @uml.property  name="preco"
	 */
	private float preco;

	/**
	 * @uml.property  name="quantidade"
	 */
	private int quantidade;

	//bi-directional one-to-one association to TabPedido
	/**
	 * @uml.property  name="tabPedido"
	 * @uml.associationEnd  inverse="tabItemPedido:model.TabPedido"
	 */
	@OneToOne
	@JoinColumn(name="codPedido")
	private Pedido pedido;

	//bi-directional many-to-one association to TabProduto
	/**
	 * @uml.property   name="tabProduto"
	 * @uml.associationEnd   inverse="tabItemPedidos:model.Produto"
	 */
	@ManyToOne
	@JoinColumn(name="codProduto")
	private Produto produto;

	public ItemPedido() {
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
	 * @uml.property  name="preco"
	 */
	public float getPreco() {
		return this.preco;
	}

	/**
	 * @param preco
	 * @uml.property  name="preco"
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}

	/**
	 * @return
	 * @uml.property  name="quantidade"
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * @param quantidade
	 * @uml.property  name="quantidade"
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return
	 * @uml.property  name="tabPedido"
	 */
	public Pedido getPedido() {
		return this.pedido;
	}

	/**
	 * @param pedido
	 * @uml.property  name="tabPedido"
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return
	 * @uml.property  name="tabProduto"
	 */
	public Produto getProduto() {
		return this.produto;
	}

	/**
	 * @param produto
	 * @uml.property  name="tabProduto"
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}