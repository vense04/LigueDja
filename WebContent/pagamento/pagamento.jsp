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
<style type="text/css">
			
			.logo {
				list-style: none;
				margin: 0;
				padding: 0;
			}
			
			.logo:after {
				content: "";
				clear: both;
			}
			
			.logo {
				border: 1px solid #ccc;
				box-sizing: border-box;
				float: left;
				height: 104px;
				position: relative;
				width: 250px;
			}
			
			.logo label {
				background: #fff no-repeat center center;
				bottom: 1px;
				cursor: pointer;
				display: block;
				font-size: 0;
				left: 1px;
				position: absolute;
				right: 1px;
				text-indent: 100%;
				top: 1px;
				white-space: nowrap;
			}
			.logo + .logo {
				margin-left: 25px;
			}
			
			.paypal label {
				background-image: url(../images/paypal.png);
			}
			
			.pagSeguro label {
				background-image: url(../images/pagSeguro.png);
			}
			
			.logos input:focus + label {
			  outline: 2px dotted #21b4d0;
			}
			
			.logos input:checked + label {
			  outline: 4px solid #21b4d0;
			}
			
			input {
				width: 250px;
				heigth: 104px;
				border: 2px solid #21b4d0;
			}
			
			.logos input:checked + label:after {
			  background: url(../images/checked.png);
			  bottom: -10px;
			  content: "";
			  display: inline-block;
			  height: 20px;
			  position: absolute;
			  right: -10px;
			  width: 20px;
			}
			
    </style>
</head>
<body>
	<%@ include file="/Template/header.jsp"%>
	<article id="basket">
	<button class="continue" onclick="parent.location.href='Pedido'">Finalizar Compra</button>
	<h1>Métodos de pagamento</h1>
	<ul class="logos">
<form action="https://www.paypal.com/cgi-bin/webscr" method="post">
	<input type="hidden" name="cmd" value="_xclick">
	<input type="hidden" name="business" value="rodrigofonsecajr@gmail.com">
	<input type="hidden" name="lc" value="BR">
	<c:if test="${sessionScope.carrinho.quantidadeProdutos() > 1}">
		<input type="hidden" name="item_name" value="Vários itens">
	</c:if>
	<c:if test="${sessionScope.carrinho.quantidadeProdutos() == 1}">
		<input type="hidden" name="item_name" value="${sessionScope.carrinho.getItens().get(0).produto.nomProduto}">
	</c:if>
	<input type="hidden" name="amount" value="${sessionScope.carrinho.valorTotal()}">
	<input type="hidden" name="currency_code" value="BRL">
	<input type="hidden" name="button_subtype" value="services">
	<input type="hidden" name="no_note" value="0">
	<input type="hidden" name="cn" value="Adicionar instruções especiais para o vendedor">
	<input type="hidden" name="no_shipping" value="2">
	<input type="hidden" name="bn" value="PP-BuyNowBF:btn_buynowCC_LG.gif:NonHosted">
	<input type="image" src="../images/paypal.png" border="0" name="submit" alt="PayPal - A maneira mais fácil e segura de efetuar pagamentos online!">
	<img alt="" border="0" src="https://www.paypalobjects.com/pt_BR/i/scr/pixel.gif" width="1" height="1">
</form>
	</ul>
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
	<button class="continue" onclick="parent.location.href='Pedido'">Finalizar Compra</button>
	</article>

	<%@ include file="/Template/footer.jsp"%>
</body>
</html>