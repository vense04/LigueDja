<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
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
	<article id="login"> 
	<c:if test="${not empty param.erro}">
		<div class="bloco_erro">
			Erro no login. Tente novamente.<br /> Causa :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<form id="login" action="<c:url value='j_spring_security_check' />" method="post">
		<h1>Já sou cliente LigueDjá</h1>
		<p>
			<label for="email">Email</label> <input type='text' name='j_username' />
		</p>
		<p>
			<label for="pasword">Senha</label> <input type='password' name='j_password' />
		</p>
		<label> <input type="checkbox"
			name="_spring_security_remember_me" /> Entrar automaticamente <br />
		</label>
		<p>
			<button type="submit" value="Entrar">Entrar</button>
			<script>
				document.getElementById("login").j_username.value = "${SPRING_SECURITY_LAST_USERNAME}";
			</script>
			<a href="#">Esqueceu a minha senha?</a>
		</p>
	</form>
	<section>
		<h2>Ainda não e cliente LigueDjá</h2>
		<p>
			<a href="cadastro.jsp">Cadastre-se</a>
		</p>
	</section> 
	</article>

	<%@ include file="/Template/footer.jsp"%>
</body>
</html>