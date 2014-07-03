<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>LigueDjá - Suas muambas direto da China</title>
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


<!-- The below script Makes IE understand the new html5 tags are there and applies our CSS to it -->
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-md-10 col-sm-8 col-xs-9 bhoechie-tab-container">
				<div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 bhoechie-tab-menu">
					<div class="list-group">
						<a href="#" class="list-group-item active text-center">
							<h4 class="glyphicon glyphicon-briefcase"></h4> <br />Cadastro
							Produto
						</a> <a href="#" class="list-group-item text-center">
							<h4 class="glyphicon glyphicon-briefcase"></h4> <br />Editar
							Produto
						</a> <a href="#" class="list-group-item text-center">
							<h4 class="glyphicon glyphicon-retweet"></h4> <br />Cadastro
							Entrada
						</a> <a href="#" class="list-group-item text-center">
							<h4 class="glyphicon glyphicon-phone"></h4> <br />Relatório de
							Produto
						</a> <a href="#" class="list-group-item text-center">
							<h4 class="glyphicon glyphicon-shopping-cart"></h4> <br />Relatório
							de Vendas
						</a> <a href="#" class="list-group-item text-center">
							<h4 class="glyphicon glyphicon-user"></h4> <br />Listar Usuarios
						</a> </a> <a href="#" class="list-group-item text-center">
							<h4 class="glyphicon glyphicon-transfer"></h4> <br />Relatorio
							de Entrada
						</a> </a>
						<div class="list-group-item text-center">
							<a style="color: #5A55A3 !important;"
								href="<%=request.getContextPath()%>/index.jsp"><h4
									class="glyphicon glyphicon-home"></h4> <br />Voltar ao site</a>
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 bhoechie-tab">
					<%@ include file="/administrativo/Template/cadastroProduto.jsp"%>
					<%@ include file="/administrativo/Template/editarProduto.jsp"%>
					<%@ include file="/administrativo/Template/cadastroEntrada.jsp"%>
					<%@ include file="/administrativo/Template/editarEntrada.jsp"%>
					
					<!-- hotel search -->
					<div class="bhoechie-tab-content">
						<center>
							<h1 class="glyphicon glyphicon-phone"
								style="font-size: 12em; color: #55518a"></h1>
							<h2 style="margin-top: 0; color: #55518a">Relatório de
								Produtos</h2>
						</center>
					</div>
					<div class="bhoechie-tab-content">
						<center>
							<h1 class="glyphicon glyphicon-shopping-cart"
								style="font-size: 12em; color: #55518a"></h1>
							<h2 style="margin-top: 0; color: #55518a">Relatório de
								Vendas</h2>
						</center>
					</div>
					<div class="bhoechie-tab-content">
						<center>
							<h1 class="glyphicon glyphicon-user"
								style="font-size: 12em; color: #55518a"></h1>
							<h2 style="margin-top: 0; color: #55518a">Listar Usuario</h2>
						</center>
					</div>
					<div class="bhoechie-tab-content">
						<center>
							<h1 class="glyphicon glyphicon-transfer"
								style="font-size: 12em; color: #55518a"></h1>
							<h2 style="margin-top: 0; color: #55518a">Relatorio de
								Entrada</h2>
						</center>
					</div>
				</div>
					
					
				
				</div>
			</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$("div.bhoechie-tab-menu>div.list-group>a").click(
							function(e) {
								e.preventDefault();
								$(this).siblings('a.active').removeClass(
										"active");
								$(this).addClass("active");
								var index = $(this).index();
								$("div.bhoechie-tab>div.bhoechie-tab-content")
										.removeClass("active");
								$("div.bhoechie-tab>div.bhoechie-tab-content")
										.eq(index).addClass("active");
							});
				});
	</script>
	<script type="text/javascript">
		$("#categorias").on('change',
						function() {
							$.get("Teste?codCategoria=" + this.value).done(function(data) {
								$('#produtos').empty();
								for ( var produto in data["Produtos"]) {
									$('#produtos').append('<option value=' + data["Produtos"][produto]["codProduto"] + '>'
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