package dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the TAB_USUARIO database table.
 * 
 */
@Entity
@Table(name="TAB_USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT t FROM Usuario t")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="codUsuario"
	 */
	@Id
	private int codUsuario;

	/**
	 * @uml.property  name="datNascimento"
	 */
	@Temporal(TemporalType.DATE)
	private Date datNascimento;

	/**
	 * @uml.property  name="email"
	 */
	private String email;

	/**
	 * @uml.property  name="nome"
	 */
	private String nome;

	/**
	 * @uml.property  name="renda"
	 */
	private float renda;

	/**
	 * @uml.property  name="senha"
	 */
	private String senha;
	
	private boolean ativo;
	
	@ElementCollection(targetClass=String.class) @JoinTable(
			name="TAB_USUARIO_PERMISSAO",
			uniqueConstraints = {@UniqueConstraint(columnNames={"codUsuario","permissao"})}, joinColumns = @JoinColumn(name="codUsuario"))
			@Column(name="permissao", length=50)
			private Set<String> permissoes = new HashSet<String>();

	//bi-directional many-to-one association to TabEndereco
	/**
	 * @uml.property  name="tabEnderecos"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="tabUsuario:model.TabEndereco"
	 */
	@OneToMany(mappedBy="usuario")
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to TabPedido
	/**
	 * @uml.property  name="tabPedidos"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="tabUsuario:model.TabPedido"
	 */
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedidos;

	//bi-directional one-to-one association to TabUsuarioPermissao
	/**
	 * @uml.property   name="tabUsuarioPermissao"
	 * @uml.associationEnd   inverse="tabUsuario:model.UsuarioPermissao"
	 */
	@OneToOne(mappedBy="usuario")
	private UsuarioPermissao usuarioPermissao;

	public Usuario() {
	}

	/**
	 * @return
	 * @uml.property  name="codUsuario"
	 */
	public Integer getCodUsuario() {
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
	 * @uml.property  name="datNascimento"
	 */
	public Date getDatNascimento() {
		return this.datNascimento;
	}

	/**
	 * @param datNascimento
	 * @uml.property  name="datNascimento"
	 */
	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}

	/**
	 * @return
	 * @uml.property  name="email"
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 * @uml.property  name="email"
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 * @uml.property  name="nome"
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @param nome
	 * @uml.property  name="nome"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 * @uml.property  name="renda"
	 */
	public float getRenda() {
		return this.renda;
	}

	/**
	 * @param renda
	 * @uml.property  name="renda"
	 */
	public void setRenda(float renda) {
		this.renda = renda;
	}

	/**
	 * @return
	 * @uml.property  name="senha"
	 */
	public String getSenha() {
		return this.senha;
	}

	/**
	 * @param senha
	 * @uml.property  name="senha"
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setUsuario(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setUsuario(null);

		return endereco;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setUsuario(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setUsuario(null);

		return pedido;
	}

	/**
	 * @return
	 * @uml.property  name="tabUsuarioPermissao"
	 */
	public UsuarioPermissao getUsuarioPermissao() {
		return this.usuarioPermissao;
	}

	/**
	 * @param usuarioPermissao
	 * @uml.property  name="tabUsuarioPermissao"
	 */
	public void setUsuarioPermissao(UsuarioPermissao usuarioPermissao) {
		this.usuarioPermissao = usuarioPermissao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}