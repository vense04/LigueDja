package dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TAB_USUARIO_PERMISSAO database table.
 * 
 */
@Entity
@Table(name="TAB_USUARIO_PERMISSAO")
@NamedQuery(name="UsuarioPermissao.findAll", query="SELECT t FROM UsuarioPermissao t")
public class UsuarioPermissao implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="codUsuario"
	 */
	@Id
	private int codUsuario;

	/**
	 * @uml.property  name="permissao"
	 */
	private String permissao;

	//bi-directional one-to-one association to TabUsuario
	/**
	 * @uml.property   name="tabUsuario"
	 * @uml.associationEnd   inverse="tabUsuarioPermissao:model.Usuario"
	 */
	@OneToOne
	@JoinColumn(name="codUsuario")
	private Usuario usuario;

	public UsuarioPermissao() {
	}

	/**
	 * @return
	 * @uml.property  name="codUsuario"
	 */
	public int getCodUsuario() {
		return this.codUsuario;
	}

	/**
	 * @param codUsuario
	 * @uml.property  name="codUsuario"
	 */
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	/**
	 * @return
	 * @uml.property  name="permissao"
	 */
	public String getPermissao() {
		return this.permissao;
	}

	/**
	 * @param permissao
	 * @uml.property  name="permissao"
	 */
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	/**
	 * @return
	 * @uml.property  name="tabUsuario"
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * @param usuario
	 * @uml.property  name="tabUsuario"
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}