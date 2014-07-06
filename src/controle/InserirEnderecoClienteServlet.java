package controle;

import java.io.IOException;
import java.text.ParseException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.ClienteServico;
import servico.EnderecoServico;
import dominio.Endereco;
import dominio.Usuario;

@WebServlet("/InserirEnderecoClienteServlet")
public class InserirEnderecoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSERIR_ENDERECO = "/endereco.jsp";

	@Inject
	private ClienteServico clienteservico;
		
	@ Inject
	private EnderecoServico enderecoServico;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String cmd = request.getParameter("cmd");

		if (cmd.equalsIgnoreCase("inserir")) {
			forward = INSERIR_ENDERECO;
		}
		int cod = Integer.parseInt(request.getParameter("codUsuario"));
		Usuario usuario = ClienteServico.bus(cod); 
		
		
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		try {
			Endereco end = instanciar2(request);
			enderecoServico.inserir(end);

		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServletException("Erro no post" + e.getMessage());

		}

		RequestDispatcher rd = request.getRequestDispatcher("/carrinho.jsp");
		rd.forward(request, response);
	}

	
	
	
	private Endereco instanciar2(HttpServletRequest req) throws ParseException {
		
		String auxiliar2;
		
		Endereco end = new Endereco();
		try {

			auxiliar2 = req.getParameter("codEndereco");
			System.out.println(auxiliar2);
			if (auxiliar2 != null && auxiliar2.isEmpty())
				end.setCodEndereco(Integer.parseInt(auxiliar2));

			auxiliar2 = req.getParameter("logradouro");
			end.setLogradouro(auxiliar2);
			System.out.println(auxiliar2);
			auxiliar2 = req.getParameter("numero");
			end.setNumero(auxiliar2);
			System.out.println(auxiliar2);
			auxiliar2 = req.getParameter("complemento");
			end.setComplemento(auxiliar2);
			System.out.println(auxiliar2);
			auxiliar2 = req.getParameter("cidade");
			end.setCidade(auxiliar2);
			System.out.println(auxiliar2);
			auxiliar2 = req.getParameter("uf");
			end.setUf(auxiliar2);
			System.out.println(auxiliar2);
			auxiliar2 = req.getParameter("cep");
			end.setCep(auxiliar2);
			System.out.println(auxiliar2);
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ParseException("Erro ao cadastrar um Usu�rio!", 0);

		}
		return end;
	}
	
}
