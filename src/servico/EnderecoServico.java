package servico;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.EnderecoDao;
import dominio.Endereco;

public class EnderecoServico {
	
	@Inject
	EntityManager em;
	
	@Inject
	private EnderecoDao enderecoDao;
	
	
	
	public List<Endereco> listarClientes(){
		return enderecoDao.buscaTodos();
		
	}
	
	public Endereco carregar(int cod) {
		return enderecoDao.buscaPorCodigo(cod);
	}
	
	public void inserir( Endereco us) throws RuntimeException{
		try{
			em.getTransaction().begin();
			enderecoDao.inserir(us);
			em.getTransaction().commit();
		} catch(Throwable e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException(" Erro ao Inserir Cadastro");
		}
	}
	public void editar( Endereco us) throws RuntimeException{
		try{
			em.getTransaction().begin();
			enderecoDao.editar(us);
			em.getTransaction().commit();
		} catch(Throwable e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException(" Erro ao Atualizar Cadastro Cliente");
		}
	}
	

}
