package dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TAB_ENDERECO database table.
 * 
 */
@Entity
@Table(name="TAB_ENDERECO")
@NamedQuery(name="Endereco.findAll", query="SELECT t FROM Endereco t")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="codEndereco"
	 */
	@Id
	private int codEndereco;

	/**
	 * @uml.property  name="cep"
	 */
	private String cep;

	/**
	 * @uml.property  name="cidade"
	 */
	private String cidade;

	/**
	 * @uml.property  name="complemento"
	 */
	private String complemento;

	/**
	 * @uml.property  name="logradouro"
	 */
	private String logradouro;

	/**
	 * @uml.property  name="numero"
	 */
	private String numero;

	/**
	 * @uml.property  name="uf"
	 */
	private String uf;

	//bi-directional many-to-one association to TabUsuario
	/**
	 * @uml.property   name="tabUsuario"
	 * @uml.associationEnd   inverse="tabEnderecos:model.Usuario"
	 */
	@ManyToOne
	@JoinColumn(name="codUsuario")
	private Usuario usuario;

	public Endereco() {
	}

	/**
	 * @return
	 * @uml.property  name="codEndereco"
	 */
	public int getCodEndereco() {
		return this.codEndereco;
	}

	/**
	 * @param codEndereco
	 * @uml.property  name="codEndereco"
	 */
	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}

	/**
	 * @return
	 * @uml.property  name="cep"
	 */
	public String getCep() {
		return this.cep;
	}

	/**
	 * @param cep
	 * @uml.property  name="cep"
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return
	 * @uml.property  name="cidade"
	 */
	public String getCidade() {
		return this.cidade;
	}

	/**
	 * @param cidade
	 * @uml.property  name="cidade"
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return
	 * @uml.property  name="complemento"
	 */
	public String getComplemento() {
		return this.complemento;
	}

	/**
	 * @param complemento
	 * @uml.property  name="complemento"
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return
	 * @uml.property  name="logradouro"
	 */
	public String getLogradouro() {
		return this.logradouro;
	}

	/**
	 * @param logradouro
	 * @uml.property  name="logradouro"
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return
	 * @uml.property  name="numero"
	 */
	public String getNumero() {
		return this.numero;
	}

	/**
	 * @param numero
	 * @uml.property  name="numero"
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return
	 * @uml.property  name="uf"
	 */
	public String getUf() {
		return this.uf;
	}

	/**
	 * @param uf
	 * @uml.property  name="uf"
	 */
	public void setUf(String uf) {
		this.uf = uf;
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