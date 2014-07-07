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
	<article id="grid">
	<div id="breadcrumb">
		<a href="Home">Home</a> > <a href="Produtos">Smartphones</a> > 
		<h1>
			<c:choose>
			    <c:when test="${empty param.categoria}">
			        Todos
			    </c:when>
			    <c:otherwise>
			        ${produtos[0].categoria.nomCategoria}
			    </c:otherwise>
			</c:choose>
		</h1>
	</div>
    <header>
        <div class="paging">
        <c:if test="${produtos.size()>10}">
        	<c:if test="${!empty param.inicio}">
            	Página: <a href="Produtos?categoria=${param.categoria}&inicio=${(param.inicio-10)}">${(param.inicio\10)-1}</a>&nbsp; | &nbsp;${(param.inicio\10)}&nbsp; | &nbsp;<a href="Produtos?categoria=${param.categoria}&inicio=${(param.inicio+10)}">${(param.inicio\10)+1}</a>
            </c:if>
        </c:if>
        </div>
        <form action="#" >
         Filtrar por: 
        <select name="ordem" id="ordem">
            <option value="">Ordem</option>
            <option value="maiorPreco<c:if test="${!empty param.categoria}">&categotia=${param.categoria}</c:if>" <c:if test="${param.ordem == 'maiorPreco'}"> selected </c:if>>Maior preço</option>
            <option value="menorPreco<c:if test="${!empty param.categoria}">&categotia=${param.categoria}</c:if>" <c:if test="${param.ordem == 'menorPreco'}"> selected </c:if>>Menor preço</option>
            <option value="popularidade<c:if test="${!empty param.categoria}">&categotia=${param.categoria}</c:if>" <c:if test="${param.ordem == 'popularidade'}"> selected </c:if>>Popularidade</option>
        </select> 
        &nbsp; Exibindo ${(param.inicio == null)? 1 : param.inicio} - ${(param.fim == null)? produtos.size() : param.fim} de ${produtos.size()} Celular(es)
        </form>
    </header>
    <ul id="categorias">
    	<h1>Marcas</h1>
    	<li><a href="Produtos">Todos</a></li>
		<c:forEach items="${sessionScope.categorias}" var="categoria">
			<li><a href="Produtos?categoria=${categoria.codCategoria}">${categoria.nomCategoria}</a></li>
		</c:forEach>
    </ul>
    <ul id="items">
     <c:forEach items="${produtos}" begin="${(param.inicio == null)? 0 : param.inicio}" end="${(param.fim == null)? 9 : param.fim}" var="produto">
	     <li>
	            <a href="Detalhes?produto=${produto.codProduto}"><img src="${produto.thumb}" width="170" height="259"
					alt="${produto.nomProduto} - ${produto.descricao}" /></a> <a href="detalhes.jsp" class="title">${produto.nomProduto}</a>
	            <strong><fmt:formatNumber value="${produto.preco}" type="currency"/></strong>
	      </li>
	 </c:forEach>
    </ul>
    

</article>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
		$("#ordem").on('change',
			function() {
				if (this.value != "") {
					window.location.href = "Produtos?ordem=" + this.value;
				}
		});
	</script>
	<%@ include file="/Template/footer.jsp"%>
</body>
</html>