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

<article id="mainview">
    <div id="breadcrumb"><a href="Home">Home</a> > <a href="Produtos">Smartphones</a> > <a href="Produtos?categoria=${produto.categoria.codCategoria}">${produto.categoria.nomCategoria}</a> > ${produto.nomProduto}</div>
    <div id="description">
        <h1>${produto.nomProduto}</h1>
        <strong id="price"><span>Antes <fmt:formatNumber value="${produto.preco}" type="currency"/></span> <fmt:formatNumber value="${produto.preco * 0.9}" type="currency"/></strong><p>${produto.descricao}</p>
       
        <p><button class="continue"  onclick="adicionaProdutoCarrinho(${produto.codProduto}, 'menos')">-</button><button type="submit" class="continue">Carrinho</button><button class="continue" onclick="adicionaProdutoCarrinho(${produto.codProduto}, 'mais')">+</button></p>
        <p><button type="button">Enviar para um amigo</button></p>

    </div>
    <div id="images">
    	<a href="${produto.imagem }"><img src="${produto.imagem }" width="438" height="668"></a>
    </div>
</article>


	<%@ include file="/Template/footer.jsp"%>
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		function adicionaProdutoCarrinho(codProduto, acao) {
			$.get("Carrinho?codProduto=" + codProduto +"&acao=" + acao).done(function(data) {
				$("#itensCarrinho").html(data["qtdeProdutos"]);
			});
		}
	</script>
</body>
</html>