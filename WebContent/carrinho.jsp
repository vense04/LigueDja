<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>LigueDjá - Suas muambas diretos da China</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Terminal+Dosis'
	rel='stylesheet' type='text/css'>
	<!-- The below script Makes IE understand the new html5 tags are there and applies our CSS to it -->
	<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<%@ include file="/Template/header.jsp"%>
	<article id="basket">
	<button class="continue" onclick="parent.location.href='pagamento/Pedido'">Finalizar Compra</button>
	<h1>Carrinho de Compra</h1>
	<table width="100" border="1">
		<tr>
			<th scope="col" class="description">Produtos</th>
			<th scope="col" class="options">Opções</th>
			<th align="right" scope="col" class="price">Preço</th>
		</tr>
		<c:forEach items="${sessionScope.carrinho.getItens()}" var="item">
			<tr id="${item.produto.codProduto}">
				<td align="left" valign="top" class="description"><a
					href="Detalhes?produto=${item.produto.codProduto}"><img src="${item.produto.thumb}"
						alt="${item.produto.nomProduto} - ${item.produto.descricao}" class="left" /></a>
					<p>
						<a href="Detalhes?produto=${item.produto.codProduto}">${item.produto.nomProduto}</a><br />${item.produto.descricao}
					</p><p><button class="continue"  onclick="adicionaProdutoCarrinho(${item.produto.codProduto}, 'menos')">-</button><button class="continue" onclick="adicionaProdutoCarrinho(${item.produto.codProduto}, 'mais')">+</button></p>
        
        </td>
				<td align="left" valign="top" class="options">
					<dl>
						<dt>Cód produto:</dt>
						<dd>${item.produto.codProduto}</dd>
						<dt>Quantidade:</dt>
						<dd id="qtdeProduto${item.produto.codProduto}">${item.quantidade}</dd>
					</dl>
					<button>Change details</button>
				</td>
				<td align="right" valign="top" class="price" id="totalProduto${item.produto.codProduto}"><fmt:formatNumber value="${item.produto.preco}" type="currency"/></td>
			</tr>
		</c:forEach>
	</table>
	<img src="images/creditcards.gif" class="safe" />
	<div class="right">
		<strong>Subtotal (Sem custos de envio)</strong> <em id="subTotal"><fmt:formatNumber value="${sessionScope.carrinho.valorTotal()}" type="currency"/></em><br />
		<p>
			<select>
				<option>Grátis (07-10 dias úteis)</option>
				<option>04 dias úteis <em id="subTotalFrete"><fmt:formatNumber value="${sessionScope.carrinho.valorTotal() * 0.10}" type="currency"/></em></option>
			</select> <em>R$ 0.00</em>
		</p>
		<strong>Total</strong> <em id="total"><fmt:formatNumber value="${sessionScope.carrinho.valorTotal()}" type="currency"/></em>
	</div>
	<button class="continue" onclick="parent.location.href='pagamento/Pedido'">Finalizar Compra</button>
	</article>

	<%@ include file="/Template/footer.jsp"%>
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		function adicionaProdutoCarrinho(codProduto, acao) {
			$.get("Carrinho?codProduto=" + codProduto +"&acao=" + acao).done(function(data) {
				if (data["totProduto"] != 0) {
					$("#qtdeProduto" + codProduto).html(data["qteProduto"]);
					$("#totalProduto" + codProduto).html(data["totProduto"]);
				}
				else {
					$("#" + codProduto + "").remove();
				}
				$("#subTotal").html(data["totalCarrinho"]);
				$("#subTotalFrete").html(parseInt(data["totalCarrinho"]) * 0.10);
				$("#total").html(data["totalCarrinho"]);
			});
		}
	</script>
</body>
</html>