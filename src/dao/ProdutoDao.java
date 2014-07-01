package dao;

import java.util.List;

import dominio.Categoria;
import dominio.Produto;

public interface ProdutoDao {

	public void inserir(Produto produto);

	public void remover(Produto produto);

	public void atualizar(Produto produto);

	public Produto buscaPorCodigo(int cod);

	public List<Produto> buscaTodos();
	
	public List<Produto> buscaTodosPorCategoria(Categoria categoria);
	
}
