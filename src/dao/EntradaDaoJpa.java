package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dominio.Entrada;

public class EntradaDaoJpa implements EntradaDao {

	@Inject
	private EntityManager em;

	@Override
	public void inserir(Entrada entrada) {
		em.persist(entrada);
	}

	@Override
	public void remover(Entrada entrada) {
		em.remove(entrada);
	}

	@Override
	public void atualizar(Entrada entrada) {
		em.merge(entrada);
	}

	@Override
	public Entrada buscaPorCodigo(int cod) {
		return em.find(Entrada.class, cod);
	}

	@Override
	public List<Entrada> buscaTodos() {
		return em.createQuery("SELECT u FROM Entrada u").getResultList();
	}

}


