package dominio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dao.ProdutoDao;



@Entity
@Table(name="TAB_PRODUTO")
@NamedQuery(name="Produto.findAll", query="SELECT t FROM Produto t")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="codProduto"
	 */
	@Id
	private int codProduto;

	/**
	 * @uml.property  name="descricao"
	 */
	private String descricao;

	/**
	 * @uml.property  name="preco"
	 */
	private float preco;

	/**
	 * @uml.property  name="qteEstoque"
	 */
	private int qteEstoque;
	
	/**
	 * @uml.property  name="nomProduto"
	 */
	private String nomProduto;

	//bi-directional one-to-one association to TabEntrada
	/**
	 * @uml.property  name="tabEntrada"
	 * @uml.associationEnd  inverse="tabProduto:model.TabEntrada"
	 */
	@OneToOne(mappedBy="produto")
	private Entrada entrada;

	//bi-directional many-to-one association to TabItemPedido
	/**
	 * @uml.property  name="tabItemPedidos"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="tabProduto:model.TabItemPedido"
	 */
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itemPedidos;

	//bi-directional many-to-one association to TabCategoria
	/**
	 * @uml.property  name="tabCategoria"
	 * @uml.associationEnd  inverse="tabProdutos:model.TabCategoria"
	 */
	@ManyToOne
	@JoinColumn(name="codCategoria")
	private Categoria categoria;
	
	@Inject
	private static ProdutoDao produtoDao;

	public Produto() {
	}

	/**
	 * @return
	 * @uml.property  name="codProduto"
	 */
	public int getCodProduto() {
		return this.codProduto;
	}

	/**
	 * @param codProduto
	 * @uml.property  name="codProduto"
	 */
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	/**
	 * @return
	 * @uml.property  name="descricao"
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * @param descricao
	 * @uml.property  name="descricao"
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	 * @uml.property  name="qteEstoque"
	 */
	public int getQteEstoque() {
		return this.qteEstoque;
	}

	/**
	 * @param qteEstoque
	 * @uml.property  name="qteEstoque"
	 */
	public void setQteEstoque(int qteEstoque) {
		this.qteEstoque = qteEstoque;
	}

	/**
	 * @return
	 * @uml.property  name="tabEntrada"
	 */
	public Entrada getEntrada() {
		return this.entrada;
	}

	/**
	 * @param entrada
	 * @uml.property  name="tabEntrada"
	 */
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public ItemPedido addItemPedido(ItemPedido itemPedido) {
		getItemPedidos().add(itemPedido);
		itemPedido.setProduto(this);

		return itemPedido;
	}

	public ItemPedido removeItemPedido(ItemPedido itemPedido) {
		getItemPedidos().remove(itemPedido);
		itemPedido.setProduto(null);

		return itemPedido;
	}

	/**
	 * @return
	 * @uml.property  name="tabCategoria"
	 */
	public Categoria getCategoria() {
		return this.categoria;
	}

	/**
	 * @param categoria
	 * @uml.property  name="tabCategoria"
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getNomProduto() {
		return nomProduto;
	}

	public void setNomProduto(String nomProduto) {
		this.nomProduto = nomProduto;
	}
	
	/**
	 * Lista todos os produtos na base de dados
	 * @return List<Produto>
	 */
	
	public static List<Produto> buscaTodos() {
		
		return produtoDao.buscaTodos();
	}
	
	/**
	 * Estorna com o produto escolhido pelo código
	 * @return Produto
	 */
	
	public static Produto buscaPorCodigo(int cod) {
		return produtoDao.buscaPorCodigo(cod);
	}

}