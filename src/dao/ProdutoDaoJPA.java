package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dominio.Categoria;
import dominio.Produto;

public class ProdutoDaoJPA implements ProdutoDao {

	@Inject
	private EntityManager em;

	@Override
	public void inserir(Produto produto) {
		em.persist(produto);
	}

	@Override
	public void remover(Produto produto) {
		em.remove(produto);
	}

	@Override
	public void atualizar(Produto produto) {
		em.merge(produto);
	}

	@Override
	public Produto buscaPorCodigo(int cod) {
		return em.find(Produto.class, cod);
	}

	@Override
	public List<Produto> buscaTodos() {
		return em.createQuery(
				"SELECT p FROM " + Produto.class.getName()
						+ " p ORDER BY p.codProduto").getResultList();
	}

	@Override
	public List<Produto> buscaTodosPorCategoria(Categoria categoria) {
		return em.createQuery(
				"SELECT p FROM " + Produto.class.getName()
						+ " p WHERE p.categoria = "
						+ categoria.getCodCategoria()
						+ " ORDER BY p.codProduto").getResultList();
	}

}
