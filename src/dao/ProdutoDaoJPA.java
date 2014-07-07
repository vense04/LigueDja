package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dominio.Categoria;
import dominio.ItemPedido;
import dominio.Pedido;
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

	@Override
	public List<Produto> buscaTodosPorCategoriaOrdenada(Categoria categoria,
			String ordem) {
		
		String categoriaSql = (categoria != null) ? " WHERE p.categoria = " + categoria.getCodCategoria() : "";
		
		String sql = "SELECT p FROM " + Produto.class.getName()
				+ " p";
		
		String ordenacao = "";
		if (ordem != null) {
			ordenacao = " ORDER BY ";
			if (ordem.equalsIgnoreCase("maiorPreco")) {
				ordenacao += "p.preco DESC";
			}
			else if (ordem.equalsIgnoreCase("menorPreco")) {
				ordenacao +=  "p.preco";
			}
			else if (ordem.equalsIgnoreCase("popularidade")) {
				ordenacao = ", " + ItemPedido.class.getName() + " IP "
						+ 	", " + Pedido.class.getName() + " PED ";
				
				String ordenacaoWhere = "	PED.codPedido = IP.codPedido "
						+ 	"AND "
						+ 	"	PED.datPagamento != NULL "
						+	"AND "
						+ 	"	IP.produto = P.codProduto "
						+ 	"GROUP BY "
						+ 	"	P.codProduto "
						+ 	"ORDER BY "
						+ 	"	IP.quantidade DESC";
				ordenacao += (categoriaSql.equalsIgnoreCase("")) ? " WHERE " + ordenacaoWhere : ordenacaoWhere;
			}
		}
		System.out.println(sql+categoriaSql+ordenacao);
		return em.createQuery(sql+categoriaSql+ordenacao).getResultList();
	}

}
