package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.ItemCarrinho;
import dominio.Produto;
import servico.ProdutoServico;

/**
 * Servlet implementation class Carrinho
 */
@WebServlet("/Carrinho")
public class Carrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	dominio.Carrinho carrinho;
	
	@Inject
	ProdutoServico produto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		if (sessao == null) {
			sessao = request.getSession(true);
		}
		
		if (request.getParameter("codProduto") != null) {
			Produto produtoP = produto.getProduto(Integer.parseInt(request.getParameter("codProduto")));
			if (request.getParameter("acao").equals("mais")) {
				carrinho.adicionar(produtoP);
			}
			else {
				carrinho.remover(produtoP);
			}
			
			sessao.setAttribute("carrinho", carrinho);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			if (carrinho.buscaItem(produtoP) != null) {
				out.print("{\"qtdeProdutos\": \"" + carrinho.quantidadeProdutos() + "\",  \"codProduto\": \"" + produtoP.getCodProduto() +  "\",  \"qteProduto\": \"" + carrinho.buscaItem(produtoP).getQuantidade() +  "\",  \"totProduto\": \"" + NumberFormat.getCurrencyInstance().format(carrinho.buscaItem(produtoP).getQuantidade() * produtoP.getPreco()) +  "\",  \"totalCarrinho\": \"" + NumberFormat.getCurrencyInstance().format(carrinho.valorTotal()) +  "\"}");
			}
			else {
				out.print("{\"qtdeProdutos\": \"" + carrinho.quantidadeProdutos() + "\",  \"codProduto\": \"0\",  \"totProduto\": \"0\",  \"totalCarrinho\": \"" + carrinho.valorTotal() +  "\"}");	
			}
			out.flush();
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("carrinho.jsp");
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
