package controle;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servico.CategoriaServico;
import dao.CategoriaDao;
import dominio.Categoria;

/**
 * Servlet implementation class Principal
 */
@WebServlet(description = "Controle da página principal, index", urlPatterns = { "/Home" })
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaServico categoria;
	
	@Inject
	dominio.Carrinho carrinho;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Acesso via get a tela inicial da loja
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession sessao = request.getSession(false);
		
		if (sessao == null) {
			sessao = request.getSession(true);
		}
		sessao.setAttribute("categorias", categoria.listaCategorias());
		
		if (sessao.getAttribute("carrinho") == null) {
			sessao.setAttribute("carrinho", carrinho);
		}
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
