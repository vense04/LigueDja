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

import dominio.Carrinho;

/**
 * Servlet implementation class Pedido
 */
@WebServlet("/pagamento/Pedido")
public class Pedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	Carrinho carrinho;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		RequestDispatcher rd;
		
		carrinho = (Carrinho) sessao.getAttribute("carrinho");
		
		if (carrinho == null) {
			rd = request.getRequestDispatcher("pagamento.jsp?pedido=vazio");
		}
		else {
			if (carrinho.getItens().size() == 0) {
				rd = request.getRequestDispatcher("pagamento.jsp?pedido=vazio");
			} 
			else {
				rd = request.getRequestDispatcher("pagamento.jsp");
			}
			
		}
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
