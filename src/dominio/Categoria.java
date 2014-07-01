package dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.sun.org.apache.bcel.internal.generic.DADD;

import dao.CategoriaDao;

import java.util.List;


/**
 * The persistent class for the TAB_CATEGORIA database table.
 * 
 */
@Entity
@Table(name="TAB_CATEGORIA")
@NamedQuery(name="Categoria.findAll", query="SELECT t FROM Categoria t")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="codCategoria"
	 */
	@Id
	private int codCategoria;

	/**
	 * @uml.property  name="nomCategoria"
	 */
	private String nomCategoria;

	//bi-directional many-to-one association to TabProduto
	/**
	 * @uml.property   name="tabProdutos"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="Categoria:model.Produto"
	 */
	@OneToMany(mappedBy="categoria")
	private List<Produto> produtos;

	public Categoria() {
	}

	/**
	 * @return
	 * @uml.property  name="codCategoria"
	 */
	public int getCodCategoria() {
		return this.codCategoria;
	}

	/**
	 * @param codCategoria
	 * @uml.property  name="codCategoria"
	 */
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	/**
	 * @return
	 * @uml.property  name="nomCategoria"
	 */
	public String getNomCategoria() {
		return this.nomCategoria;
	}

	/**
	 * @param nomCategoria
	 * @uml.property  name="nomCategoria"
	 */
	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setCategoria(this);

		return produto;
	}


	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setCategoria(null);

		return produto;
	}

}