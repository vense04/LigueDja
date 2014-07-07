package dao;

import java.util.List;


import dominio.Endereco;

public interface EnderecoDao {
	
	public void inserir( Endereco Endereco);
	
	public void editar(Endereco Endereco);
	
	public Endereco buscaPorCodigo(int cod);
	
	public List<Endereco> buscaTodos();
	

}
