package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import dominio.Produto;
import servico.CategoriaServico;
import servico.ProdutoServico;

/**
 * Servlet implementation class Teste
 */
@WebServlet("/Teste")
public class Teste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	ProdutoServico produto;
	
	@Inject
	CategoriaServico categoria;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("codCategoria") != null) {
			response.setContentType("application/json");
			String Json = "{\"Produtos\" : [";
			for (Produto produtos : produto.listaProdutosPorCategoria(categoria.buscaPorCodigo(Integer.parseInt(request.getParameter("codCategoria"))))) {
				Json += "{ \"codProduto\" : \"" + produtos.getCodProduto() + "\", \"nomProduto\" : \"" + produtos.getNomProduto() + "\" },";
			}
			Json = Json.substring(0, (Json.length() -1));
			Json += "]}";
			PrintWriter out = response.getWriter();
			out.print(Json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
