package controle;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.ClienteServico;
import dominio.Usuario;

@WebServlet("/ListarCadastroClienteServlet")
public class ListarCadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String LISTAR_CLIENTE = "/cliente/ListarClientes.jsp";

	@Inject
	private ClienteServico clienteservico;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
	
			
			request.setAttribute("lista",clienteservico.listarClientes());
			
			for (Usuario usuario : clienteservico.listarClientes()) {
				System.out.println(usuario.getNome());
			}	
			
			RequestDispatcher rd =request.getRequestDispatcher(LISTAR_CLIENTE);
			rd.forward(request, response);
		
	}
}
