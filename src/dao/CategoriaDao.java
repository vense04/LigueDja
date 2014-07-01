package dao;

import java.util.List;

import dominio.Categoria;

public interface CategoriaDao {
	
	public void inserir(Categoria categoria);

	public void remover(Categoria categoria);

	public void atualizar(Categoria categoria);

	public Categoria buscaPorCodigo(int cod);

	public List<Categoria> buscaTodos();

}
