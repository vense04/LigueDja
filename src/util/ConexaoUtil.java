package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConexaoUtil {

	/* Este metodo acessa o datasource da aplicacao para obter uma 
	 * conexao com o banco de dados, necessaria para a execucao do 
	 * relatorio */
	public static Connection getConexao() throws RuntimeException {
		java.sql.Connection conexao = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env/");
			javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/datasource");
			conexao = (java.sql.Connection) ds.getConnection();
		} catch (NamingException e) {
			throw new RuntimeException("Nao foi possivel encontrar o nome da conexao do banco.", e);
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro de SQL.", e);
		}
		return conexao;
	}
}
