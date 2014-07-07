package dao;

import java.util.List;





import dominio.Usuario;

public interface UsuarioDao {
	
	public void inserir( Usuario Usuario);
	
	public void editar(Usuario Usuario);
	
	public Usuario buscaPorCodigo(int cod);
	
	public List<Usuario> buscaTodos();
	
	public List<Usuario> UsuariosEntre(String datInicial, String datFinal);

	public Integer getLastId();

}
