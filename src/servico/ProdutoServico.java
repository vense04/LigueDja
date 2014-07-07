package servico;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.ProdutoDao;
import dominio.Categoria;
import dominio.Produto;

public class ProdutoServico {
	
	@Inject
	EntityManager em;
	
	@Inject
	private ProdutoDao produtoDao;
	
	
	
	
	public List<Produto> listaProdutosPorCategoria(Categoria categoria) {
		
		return produtoDao.buscaTodosPorCategoria(categoria);
	}
	
	public List<Produto> listaTodosProdutos() {
		
		return produtoDao.buscaTodos();
	}
	
	public Produto getProduto(Integer codProduto) {
		return produtoDao.buscaPorCodigo(codProduto);
	}

}
