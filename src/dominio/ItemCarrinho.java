package dominio;

public class ItemCarrinho {
	
	private Produto produto;
	private Integer quantidade = 0;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	/**
	 * Soma a quantidade passada por parêmetro deste item no carrinho de compras
	 */
	
	public void incrementarQuantidade(Integer quantidadeCompra) {
		
		quantidade += quantidadeCompra;
	}
	
	/**
	 * Diminui a quantidade passada por parêmetro deste item no carrinho de compras 
	 */
	
	public void decrementarQuantidade(Integer quantidadeCompra) {
		
		quantidade -= quantidadeCompra;
	}
	
	/**
	 * Este método retorna 
	 * @return O valor total desse item no carrinho de compras
	 */
	
	public double valorTotal() {
		
		return produto.getPreco() * quantidade;
	}

}
