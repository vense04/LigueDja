package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dominio.Categoria;

public class CategoriaDaoJpa implements CategoriaDao {

	@Inject
	private EntityManager em;

	@Override
	public void inserir(Categoria categoria) {
		em.persist(categoria);
	}

	@Override
	public void remover(Categoria categoria) {
		em.remove(categoria);
	}

	@Override
	public void atualizar(Categoria categoria) {
		em.merge(categoria);
	}

	@Override
	public Categoria buscaPorCodigo(int cod) {

		return em.find(Categoria.class, cod);
	}

	@Override
	public List<Categoria> buscaTodos() {
		return em.createQuery("SELECT u FROM Categoria u").getResultList();
	}

}
