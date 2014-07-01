package servico;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.CategoriaDao;
import dominio.Categoria;

public class CategoriaServico {
	
	@Inject
	EntityManager em;
	
	@Inject
	private CategoriaDao categoriaDao;
	
	
	public Categoria buscaPorCodigo(Integer codCategoria) {
		
		return categoriaDao.buscaPorCodigo(codCategoria);
	}
	
	public List<Categoria> listaCategorias() {
		
		return categoriaDao.buscaTodos();
	}

}
