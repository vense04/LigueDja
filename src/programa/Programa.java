package programa;

import java.util.Scanner;

import dominio.Carrinho;
import dominio.ItemCarrinho;
import dominio.Produto;


public class Programa {
	
	static Scanner leitura = new Scanner(System.in);
	static Carrinho carrinho = new Carrinho();

	public static void main(String[] args) {
		
		listaProdutos();
		
	}
	
	/**
	 * Esta função lista todos os produtos e encaminha para tela de detalhes com o código do produto escolhido
	 */
	
	public static void listaProdutos() {
		
		System.out.println("Produtos");
		for (Produto produto : Produto.buscaTodos()) {
			System.out.println(produto.getCodProduto() + " - " + produto.getNomProduto() + "  -  " + produto.getPreco());
		}
		
		System.out.println("Digite o código do produto desejado: ");
		detalhes(leitura.nextInt());
	}
	
	/**
	 * Este método mostra os detalhes do produdo informado pelo código, e tem opção de comprar ou remover os itens comprados
	 * @param codProduto
	 */
	
	public static void detalhes(int codProduto) {
		
		Produto produto = Produto.buscaPorCodigo(codProduto);
		if (produto != null) {
			System.out.println("*********************  DETALHES DO PRODUTO  ***********************");
			System.out.println("NOME: " + produto.getNomProduto());
			System.out.println("DESCRIÇÃO: " + produto.getDescricao());
			System.out.println("VALOR: " + produto.getPreco());
			System.out.println("*******************************************************************");
			System.out.println("O QUE VOCÊ DESEJA FAZER ? COMPRAR (C), REMOVER (R), LIMPAR CARRINHO (L)");
			String aux = leitura.next();
			if (aux.equalsIgnoreCase("C")) {
				System.out.println("QUANTOS VOCÊ DESEJA COMPRAR ?? ");
				int qtde = leitura.nextInt();
			/*	int qtdeInserida = carrinho.adicionar(produto);
				if (qtde > qtdeInserida) {
					System.out.println("INFELIZMENTE TEMOS APENAS " + qtdeInserida + " EM NOSSO ESTOQUE.");
				} */
			}
			if (aux.equalsIgnoreCase("R")) {
				carrinho.remover(produto);
			}
			if (aux.equalsIgnoreCase("L")) {
				carrinho.limparCarrinho();
			}
		}
		else {
			System.out.println("Este produto não existe, você deve ter digitado o código errado, favor tentar novamente.");
		}
		mostraCarrinho();
		listaProdutos();
	}
	
	/**
	 * Esta função monstra no console os itens presentes no carrinho
	 */
	
	public static void mostraCarrinho() {
		
		System.out.println("********************  ITENS NO SEU CARRINHO  **********************");
		for (ItemCarrinho item : carrinho.getItens()) {
			System.out.println(item.getProduto().getNomProduto() + " x " + item.getQuantidade() + " = " + item.valorTotal());
		}
		System.out.println("Total no carrinho: " + carrinho.valorTotal());
		System.out.println("*******************************************************************");
	}

}
