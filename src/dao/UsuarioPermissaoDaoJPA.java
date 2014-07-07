package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dominio.Usuario;
import dominio.UsuarioPermissao;

public class UsuarioPermissaoDaoJPA implements UsuarioPermissaoDao {

	@Inject
	private EntityManager em;



	@Override
	public void inserirPermissao(UsuarioPermissao Usuario) {
		
		em.persist(Usuario);
	}

}
