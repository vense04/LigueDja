package dominio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}
	
	public Integer quantidadeProdutos() {
		
		Integer total = 0;
		
		for (ItemCarrinho itemCarrinho : itens) {
			total += itemCarrinho.getQuantidade();
		}
		
		return total;
	}
	
	/**
	 * Busca o item no carrinho, caso este não exista, o cria e retona ao método que o chamou
	 * @param produto
	 * Produto passado por parâmetro
	 * @return
	 */
	
	public ItemCarrinho buscaItem(Produto produto) {
		
		if (itens != null) {
			for (ItemCarrinho itemCarrinho: itens) {
				if (itemCarrinho.getProduto().getCodProduto() == produto.getCodProduto()) {
					return itemCarrinho;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Adiciona o produto e a quantidade passadas por parâmetro ao carrinho, caso este produto não exista o insere no carrinho
	 * @param produto
	 * O produto a ser adicionado
	 * @param quantidade
	 * A quantidade a ser adicionada
	 * @return
	 */
	
	public void adicionar(Produto produto) {
		
		boolean item = false;

		if (itens.size() > 0) {
			for (ItemCarrinho itemCarrinho: itens) {
				if (itemCarrinho.getProduto().getCodProduto() == produto.getCodProduto()) {
					itemCarrinho.incrementarQuantidade(1);
					item = true;
				}
			}
		}
		if (item == false) {
			ItemCarrinho aux = new ItemCarrinho();
			aux.setProduto(produto);
			aux.incrementarQuantidade(1);
			itens.add(aux);	
		}
		
	}
	
	/**
	 * Remove o produto do carrinho
	 * @param produto
	 * O produto a ser removido
	 */
	
	public Integer remover(Produto produto) {
		
		for (ItemCarrinho itemCarrinho : itens) {
			if (itemCarrinho.getProduto().getCodProduto() == produto
					.getCodProduto()) {
				if (itemCarrinho.getQuantidade() > 1) {
					itemCarrinho.decrementarQuantidade(1);
				} else {
					itens.remove(itens.indexOf(itemCarrinho));
					return 0;
				}

			}
		}
		return 0;
	}
	
	/**
	 * Remove todos os itens do carrinho
	 */
	
	public void limparCarrinho() {
		
		itens.removeAll(itens);
	}
	
	/**
	 * Calcula o valor total do carrinho de compras
	 * @return
	 * Um double com o valor total do carrinho
	 */
	
	public double valorTotal() {
		
		double total = 0;
		for (ItemCarrinho itemCarrinho: itens) {
			total += itemCarrinho.valorTotal();
		}
		return total;
	}

}
