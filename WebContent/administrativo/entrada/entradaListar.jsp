<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap/css/admin.css" />
<script
	src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>


<title>Lista de Entrada - LigueDjá</title>
</head>
<body>
	<div class="container">
		<div class="row col-md-10 col-md-offset-1 custyle">
			<table class="table table-striped custab">
				<thead>
					<a href="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD?cmd=inserir" class="btn btn-primary btn-xs pull-right"><b>+</b>
						Adicionar Entrada</a>
						
					<a href="<%=request.getContextPath()%>/administrativo/admin.jsp" class="btn btn-warning  btn-xs pull-left"><b><<< </b>Voltar Painel</a>	
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Quantidade</th>
						<th>Data</th>
						<th class="text-center">Ação</th>
					</tr>
				</thead>
				<c:forEach items="${lista}" var="entrada">
					<tr>
						<td><c:out value="${entrada.codEntrada}" /></td>
						<td><c:out value="${entrada.produto.nomProduto}" /></td>
						<td><c:out value="${entrada.quantidade}" /></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${entrada.data}" /></td>
						<td class="text-center"><a class='btn btn-info btn-xs'
							href="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD?cmd=editar&cod=<c:out value="${entrada.codEntrada}"/>">
								<span class="glyphicon glyphicon-edit"></span> Editar
						</a> <a
							href="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD?cmd=deletar&cod=<c:out value="${entrada.codEntrada}"/>"
							class="btn btn-danger btn-xs"> <span
								class="glyphicon glyphicon-remove"> </span>Excluir
						</a></td>


					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>

</body>
</html>


</body>
</html>

