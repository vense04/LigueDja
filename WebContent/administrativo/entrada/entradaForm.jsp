<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

<title>Entrada</title>
</head>
<body>


	<div id="geral">

		<div id="conteudo">

			<form method="post" action="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD" name="formEntr">
			
				Código : <input type="text" readonly="readonly" name="codEntrada"
					value="<c:out value="${entr.codEntrada}" />" /> <br /> 
		<c:choose>
			<c:when test="${empty entr.codEntrada}">
					Categoria
					<select id="categorias" name="" class="form-control">
					<c:forEach items="${sessionScope.categorias}" var="categoria">
						<option value="${categoria.codCategoria}">${categoria.nomCategoria}</option>
					</c:forEach>
				</select> 
				Nome Produto: <select id="produtos" name="codProduto"
					class="form-control" required>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="codProduto" value="${entr.produto.codProduto}" />
				<input type="Text}" disabled value="${entr.produto.nomProduto}" />
			</c:otherwise>
		</c:choose>
				</select> Quantidade : <input type="text" name="quantidade"
					value="<c:out value="${entr.quantidade}" />" /> <br /> Data : <input
					type="text" name="data"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${entr.data}" />"class="data" />
				<br /> <input type="submit" value="Enviar" />
			</form>

		</div>


	</div>
	<script type="text/javascript">
		$("#categorias") .on( 'change',
			function() {
				$.get("Teste?codCategoria=" + this.value).done(
					function(data) {
						$('#produtos').empty();
							for ( var produto in data["Produtos"]) {
								$('#produtos').append(
										'<option value=' + data["Produtos"][produto]["codProduto"] + '>'
										+ data["Produtos"][produto]["nomProduto"]
										+ '</option>');
							}
					});
			});
		$(document).ready(function() {
			$('#categorias').change();
		});
	</script>
</body>
</html>

