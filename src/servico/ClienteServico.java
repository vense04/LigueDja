package servico;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.UsuarioDao;
import dominio.Usuario;

public class ClienteServico {
	
	@Inject
	EntityManager em;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	public List<Usuario> listarClientes(){
		return usuarioDao.buscaTodos();
	}
	
	public void inserir( Usuario us) throws RuntimeException{
		try{
			em.getTransaction().begin();
			usuarioDao.inserir(us);
			em.getTransaction().commit();
		} catch(Throwable e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException(" Erro ao Inserir Cadastro");
		}
	}
	public void editar( Usuario us) throws RuntimeException{
		try{
			em.getTransaction().begin();
			usuarioDao.editar(us);
			em.getTransaction().commit();
		} catch(Throwable e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException(" Erro ao Atualizar Cadastro");
		}
	}
	

}
