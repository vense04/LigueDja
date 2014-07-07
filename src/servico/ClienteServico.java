package servico;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sun.org.apache.regexp.internal.recompile;

import dao.EnderecoDao;
import dao.UsuarioDao;
import dao.UsuarioPermissaoDao;
import dominio.Usuario;
import dominio.UsuarioPermissao;

public class ClienteServico {
	
	@Inject
	EntityManager em;

	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private UsuarioPermissaoDao usuarioPerUsuarioDao;
	
	public List<Usuario> listarClientes(){
		return usuarioDao.buscaTodos();
		
	}
	
	public Usuario carregar(int cod) {
		return usuarioDao.buscaPorCodigo(cod);
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
	
	public void inserirPermissao(UsuarioPermissao usuarioPermissao) {
		
		em.getTransaction().begin();
		usuarioPerUsuarioDao.inserirPermissao(usuarioPermissao);
		em.getTransaction().commit();
	}
	
	public Integer getLastId() {
		
		return usuarioDao.getLastId();
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
			throw new RuntimeException(" Erro ao Atualizar Cadastro Cliente");
		}
	}
	
	

}
