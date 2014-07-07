package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Endereco;

public class EnderecoDaoJPA implements EnderecoDao {

	@Inject
	private EntityManager em;

	public void inserir(Endereco usuario) {
		em.persist(usuario);
	}

	public void editar(Endereco usuario) {
		em.merge(usuario);

	}

	public Endereco buscaPorCodigo(int cod) {
		return em.find(Endereco.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> buscaTodos() {
		String s = "SELECT u FROM Endereco u";
		Query query = em.createQuery(s);
		return query.getResultList();
	}
	
	
}
