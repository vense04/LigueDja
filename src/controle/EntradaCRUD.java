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
import servico.ProdutoServico;
import dominio.Entrada;

@WebServlet("/administrativo/EntradaCRUD")
public class EntradaCRUD extends HttpServlet {
	
	@Inject
	ProdutoServico produtoDao;
	
	private static final long serialVersionUID = 1L;

	private static String INSERIR_OU_ALTERAR = "/administrativo/Template/cadastrarEntrada.jsp";
	private static String LISTAR = "/administrativo/admin.jsp";

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
			if (entrada.getCodEntrada() == null) {
				System.out.println("entrada");
				entradaServico.inserir(entrada);
			} else {
				System.out.println("atualizar");
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
			
			entrada.setProduto(produtoDao.getProduto(Integer.parseInt(req.getParameter("codProduto"))));
			entrada.setData(sdf.parse(req.getParameter("data")));
			entrada.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
			
			System.out.println(entrada.getProduto().getNomProduto() + "------------");
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ParseException("Erro ao instanciar um entrada!", 0);
		}
		return entrada;
	}
}
