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
		String s = "SELECT U.nome FROM TAB_USUARIO U "
				+ "INNER JOIN TAB_USUARIO_PERMISSAO UP"
				+  "ON U.codUsuario = UP.codUsuario WHERE UP.permissao = ROLE_CLIENTE AND U.ativo = 1";
		Query query = em.createQuery(s);
		return query.getResultList();
	}
	
	
	
}
