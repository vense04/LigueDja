
package controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.ClienteServico;
import dominio.Usuario;

@WebServlet("/AlterarCadastroClienteServlet")
public class AlterarCadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String ALTERAR_CLIENTE = "/listarCadastro.jsp";

	@Inject
	private ClienteServico clienteservico;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String cmd = request.getParameter("cmd");

		if (cmd.equalsIgnoreCase("editar")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			Usuario usuar = clienteservico.carregar(cod);
			System.out.println("usuario="+usuar.getNome());
			request.setAttribute("us", usuar);
			RequestDispatcher rd = request.getRequestDispatcher("/listarCadastro.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Usuario usuar = instanciar(request);
			if(usuar.getCodUsuario()!=null)
			clienteservico.editar(usuar);

		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServletException("Erro no post" + e.getMessage());

		}

		RequestDispatcher rd = request.getRequestDispatcher("/carrinho.jsp");
		rd.forward(request, response);

	}

	private Usuario instanciar(HttpServletRequest req) throws ParseException {
		String auxiliar;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Usuario usuar = new Usuario();
		try {

			auxiliar = req.getParameter("codUsuario");
			usuar.setCodUsuario(Integer.parseInt(auxiliar));

			
			
			auxiliar = req.getParameter("nome");
			usuar.setNome(auxiliar);

			auxiliar = req.getParameter("email");
			usuar.setEmail(auxiliar);

			auxiliar = req.getParameter("senha");
			usuar.setSenha(auxiliar);

			auxiliar = req.getParameter("dtnasc");
			usuar.setDatNascimento(sdf.parse(auxiliar));

			auxiliar = req.getParameter("renda");
			usuar.setRenda(Float.parseFloat(auxiliar));

			auxiliar = req.getParameter("ativo");
			usuar.setAtivo(Boolean.parseBoolean(auxiliar));

		} catch (Throwable e) {
			e.printStackTrace();
			throw new ParseException("Erro ao cadastrar um Usu�rio!", 0);

		}

		return usuar;
	}
}
