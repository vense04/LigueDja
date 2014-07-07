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


	@Override
	@SuppressWarnings("unchecked")
	public List<Endereco> EnderecosEntre(String datInicial, String datFinal) {
		String consulta = "SELECT u from Endereco u where u.datInicial >= :arg1 AND u.datFinal <= :arg2";
		Query query = em.createQuery(consulta);
		query.setParameter("arg1", datInicial);
		query.setParameter("arg2", datFinal);
		List<Endereco> lista = query.getResultList();
		return lista;
		
	}
	
	
	
}
