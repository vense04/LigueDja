package controle;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.ProdutoServico;

/**
 * Servlet implementation class Detalhes
 */
@WebServlet("/Detalhes")
public class Detalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoServico produto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detalhes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("produto") != null) {
			request.setAttribute("produto", produto.getProduto(Integer.parseInt(request.getParameter("produto"))));
			RequestDispatcher rd = request.getRequestDispatcher("detalhes.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Home");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
