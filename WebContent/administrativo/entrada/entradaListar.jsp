<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />


<script src="${pageContext.request.contextPath}/js/jquery.js"></script>


<title>Entrada</title>
</head>
<body>
 
	<div id="geral">
		<div id="conteudo">
		<h2>Lista de Entrada</h2>
		<br/>
		    <p><a href="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD?cmd=inserir">Adicionar nova entrada</a></p>
		    <p><a href="<%=request.getContextPath()%>">Relátorio</a></p>
		<table border=1>
		        <thead>
		            <tr>
		                <th>Código</th>
		                <th>Nome</th>
		                <th>Quantidade</th>
		                <th>Data</th>
		                <th colspan=2>Ação</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach items="${lista}" var="entr">
		                <tr>
		                    <td><c:out value="${entr.codEntrada}" /></td>
		                    <td><c:out value="" /></td>
		                    <td><c:out value="${entr.quantidade}" /></td>
		                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${entr.data}" /></td>
		                    <td><a href="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD?cmd=editar&cod=<c:out value="${entr.codEntrada}"/>">Editar</a></td>
		                    <td><a href="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD?cmd=deletar&cod=<c:out value="${entr.codEntrada}"/>">Excluir</a></td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		</div>

		<hr />

		
	</div>

</body>
</html>

