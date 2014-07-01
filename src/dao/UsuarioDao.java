package dao;

import java.util.List;

import dominio.Usuario;

public interface UsuarioDao {
	
	public void inserir( Usuario Usuario);
	
	public void editar(Usuario Usuario);
	
	public List<Usuario> buscaTodos();

}
