<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>LigueDjá - Suas muambas direto da China</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Terminal+Dosis'
	rel='stylesheet' type='text/css'>
	<!-- The below script Makes IE understand the new html5 tags are there and applies our CSS to it -->
	<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>


<script type="text/javascript">
$(document).ready(function(){
		$("input.datanas").mask("99/99/9999");
        $("input.cpf").mask("999.999.999-99");
        $("input.cep").mask("99.999-999");
        $("input.telefone").mask("(99) 9999-9999");
});
</script>
</head>
<body>
	<%@ include file="/Template/header.jsp"%>
	<article id="address">
	
		<br/>
		<h1>Lista de Clientes </h1><br/>
	
			
		
		<table border=1>
		        <thead>
		            <tr>
		                <th>Nome</th>
		                <th>Email</th>
		                <th>Dt Nascimento</th>
		                <th>Renda</th>
		                <th>Ação</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach items="${lista}" var="us">
		                <tr>
		                   
		                    <td><c:out value="${us.nome}" /></td>
		                    <td><c:out value="${us.email}" /></td>
		                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${us.datNascimento}" /></td>
		                    <td><c:out value="${us.renda}" /></td>
		                    <td><a href="<%=request.getContextPath()%>/AlterarCadastroClienteServlet?cmd=editar&cod=<c:out value="${us.codUsuario}"/>">Editar</a></td>
		                    
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		

	
	</article>

	<%@ include file="/Template/footer.jsp"%>

</body>
</html>