package controle;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antlr.collections.List;
import dominio.Categoria;
import dominio.Produto;
import servico.CategoriaServico;
import servico.ProdutoServico;

/**
 * Servlet implementation class Produtos
 */
@WebServlet("/Produtos")
public class Produtos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ProdutoServico produto;
	
	@Inject
	private CategoriaServico categoria;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produtos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		if (request.getParameter("categoria") != null ||
			request.getParameter("ordem") != null) {
			
			Categoria categoriaDominio = (request.getParameter("categoria") != null) ? categoria.buscaPorCodigo(Integer.parseInt(request.getParameter("categoria"))) : null;
			String ordem = request.getParameter("ordem");

				request.setAttribute("produtos", produto.listaProdutosPorCategoriaOrdenada(categoriaDominio, ordem));
				rd = request.getRequestDispatcher("produtos.jsp");
				rd.forward(request, response);
			
			

		}
		else {
			request.setAttribute("produtos", produto.listaTodosProdutos());
			rd = request.getRequestDispatcher("produtos.jsp");
			rd.forward(request, response);
		}
	}

}
