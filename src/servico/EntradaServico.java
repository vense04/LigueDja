package servico;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.EntradaDao;
import dominio.Entrada;

public class EntradaServico {

	@Inject
	EntityManager em;

	@Inject
	private EntradaDao entradaDao;

	public List<Entrada> listarEntradas() {
		return entradaDao.buscaTodos();
	}
	public Entrada carregar(int cod) {
		return entradaDao.buscaPorCodigo(cod);
	}

	public void deletar(int cod) throws RuntimeException {
		try {
			em.getTransaction().begin();
			Entrada entrada = entradaDao.buscaPorCodigo(cod);
			entradaDao.remover(entrada);
			em.getTransaction().commit();
		} catch (Throwable e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("Erro ao deletar");
		}
	}

	public void inserir(Entrada entrada) throws RuntimeException {
		try {
			em.getTransaction().begin();
			entradaDao.inserir(entrada);
			em.getTransaction().commit();
		} catch (Throwable e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("Erro ao inserir");
		}
	}

	public void atualizar(Entrada entrada) {
		try {
			em.getTransaction().begin();
			entradaDao.atualizar(entrada);
			em.getTransaction().commit();
		} catch (Throwable e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("Erro ao atualizar");
		}
	}
}
