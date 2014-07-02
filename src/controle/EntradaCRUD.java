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

import servico.EntradaServico;
import dominio.Entrada;

@WebServlet("/secretario/EntradaCRUD")
public class EntradaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSERIR_OU_ALTERAR = "/secretario/entradaeonatoForm.jsp";
	private static String LISTAR = "/secretario/entradaeonatoListar.jsp";

	@Inject
	private EntradaServico entradaServico;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String cmd = request.getParameter("cmd");
		if (cmd == null || cmd.equalsIgnoreCase(""))
			cmd = "listar";

		if (cmd.equalsIgnoreCase("deletar")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			entradaServico.deletar(cod);
			request.setAttribute("lista", entradaServico.listarEntradas());
			forward = LISTAR;
		}

		else if (cmd.equalsIgnoreCase("editar")) {
			int cod = Integer.parseInt(request.getParameter("cod"));
			Entrada entrada = entradaServico.carregar(cod);
			request.setAttribute("entrada", entrada);
			forward = INSERIR_OU_ALTERAR;
		}

		else if (cmd.equalsIgnoreCase("listar")) {
			request.setAttribute("lista", entradaServico.listarEntradas());
			forward = LISTAR;
		}

		else if (cmd.equalsIgnoreCase("inserir")) {
			forward = INSERIR_OU_ALTERAR;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			Entrada entrada = instanciar(request);
			if (entrada == null) {
				entradaServico.inserir(entrada);
			} else {
				entradaServico.atualizar(entrada);
			}
			RequestDispatcher rd = request.getRequestDispatcher(LISTAR);
			request.setAttribute("lista", entradaServico.listarEntradas());
			rd.forward(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServletException("Erro no post" + e.getMessage());
		}
	}

	private Entrada instanciar(HttpServletRequest req) throws ParseException {
		String aux;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Entrada entrada = new Entrada();
		try {
			aux = req.getParameter("codEntrada");
			if (aux!=null && !aux.isEmpty())
				entrada.setCodEntrada(Integer.parseInt(aux));

			aux = req.getParameter("nome");
			entrada.setData(sdf.parse(aux));
		
			aux = req.getParameter("finalizado");
			entrada.setQuantidade(Integer.parseInt(aux));
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ParseException("Erro ao instanciar um entradaeonato!", 0);
		}
		return entrada;
	}
}