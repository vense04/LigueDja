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
		$(document).ready(function() {
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
	<form method="post"
		action="<%=request.getContextPath()%>/InserirCadastroClienteServlet"
		name="inserecliente">
		<div id="form">


			<h1>Formulário de Cadastro</h1>

			<span class="alert"> * Obrigatorio</span>
			<p>
				<label>Nome:</label> <input id="" name="nome"
					value="<c:out value="${us.nome}"/>" type="text" required><span
					class="alert">*</span>
			</p>
			<p>
				<label>Email:</label> <input id="" name="email"
					value="<c:out value="${us.email}"/>" type="email" required><span
					class="alert">*</span>
			</p>
			<p>
				<label>Senha:</label> <input id="" name="senha"
					value="<c:out value="${us.senha}"/>" type="password" required><span
					class="alert">*</span>
			</p>

			<p>
				<label>Data de Nascimento:</label> <input id="datanas" name="dtnasc"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${us.datNascimento}"/>"
					" class="datanas" type="text"><span class="alert">*</span>
			</p>
			<p>
				<label>Renda:</label> <input id="" class="" name="renda"
					value="<c:out value="${us.renda}"/>" type="text"><span
					class="alert">*</span>
			</p>
			<!--  
			<p>
			<label>Ativo:</label>
			<input id="" class="" name="ativo" value="<c:out value="${us.ativo}"/>"  type="hidden"></input>
			</p>
			-->
			<p>
			<label>&nbsp;</label>
			<button type="submit" class="continue">Proximo</button>
		</p>
		</div>

	</form>
	</article>

	<%@ include file="/Template/footer.jsp"%>

</body>
</html>