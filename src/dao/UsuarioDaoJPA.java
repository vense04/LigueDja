package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;




import dominio.Usuario;

public class UsuarioDaoJPA implements UsuarioDao {

	@Inject
	private EntityManager em;

	public void inserir(Usuario usuario) {
		em.persist(usuario);
	}

	
	public void editar(Usuario usuario) {
		em.merge(usuario);
		
	}
	public Usuario buscaPorCodigo(int cod) {
		return em.find(Usuario.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscaTodos() {
		String s = "SELECT u FROM Usuario u";
				
		Query query = em.createQuery(s);
		return query.getResultList();
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> UsuariosEntre(String datInicial, String datFinal) {
		String consulta = "SELECT u from Usuario u where u.datInicial >= :arg1 AND u.datFinal <= :arg2";
		Query query = em.createQuery(consulta);
		query.setParameter("arg1", datInicial);
		query.setParameter("arg2", datFinal);
		List<Usuario> lista = query.getResultList();
		return lista;
		
	}


	@Override
	public Integer getLastId() {
		
		return (Integer) em.createQuery("SELECT last_insert_id from Usuario").getSingleResult();
	}
	
	
	
}
