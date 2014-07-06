<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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


<title>Entrada - LigueDjá</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="glyphicon glyphicon-bookmark"></span> Painel Administrativo
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<%@ include file="/administrativo/menuAdmin.jsp"%>
					</div>
				</div>
			</div>
			<div class="col-md-12 custyle">

				<form class="form-horizontal col-md-12" method="get"
					action="<%=request.getContextPath()%>/administrativo/entrada/EntradaCRUD"
					name="formEntr">
					<fieldset>

						<!-- Form Name -->
						<legend>Entrada</legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">Código</label>
							<div class="col-md-6">
								<input id="textinput" name="codEntrada" readonly="readonly"
									type="text" class="form-control input-md"
									value="<c:out value="${entr.codEntrada}" />" />
							</div>
						</div>

						<c:choose>
							<c:when test="${empty entr.codEntrada}">
								<div class="form-group">
									<label class="col-md-4 control-label" for="selectbasic">Categoria</label>
									<div class="col-md-6">
										<select id="categorias" name="codCategoria"
											class="form-control">
											<c:forEach items="${sessionScope.categorias}" var="categoria">
												<option value="${categoria.codCategoria}">${categoria.nomCategoria}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="selectbasic">Produtos</label>
									<div class="col-md-6">
										<select id="produtos" name="codProduto" class="form-control"></select>
									</div>
								</div>
							</c:when>

							<c:otherwise>

								<div class="form-group">
									<label class="col-md-4 control-label" for="textinput">Nome do Produto:</label>
									<div class="col-md-6">
										<input id="textinput" name="codProduto" type="hidden" value="${entr.produto.codProduto}"> 
									</div>
									<div class="col-md-6">
										<input type="Text}" class="form-control input-md" disabled value="${entr.produto.nomProduto}" />
									</div>
									
																			
								</div>


							</c:otherwise>

						</c:choose>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">Quantidade</label>
							<div class="col-md-6">
								<input id="textinput" name="quantidade" type="text"
									placeholder="digite a quantidade" class="form-control input-md"
									required="" value="<c:out value="${entr.quantidade}" />">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="textinput">Data</label>
							<div class="col-md-6">
								<input type="text" name="data"
									value="<fmt:formatDate pattern="dd/MM/yyyy" value="${entr.data}"/>"
									placeholder="digite a data Ex: 01/01/2001"
									class="data form-control input-md" required=""> <span
									class="help-block">Ex: 01/01/2001</span>
							</div>
						</div>

						<!-- Button (Double) -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="button1id"></label>
							<div class="col-md-8">
								<button id="button1id" name="button1id" class="btn btn-success"
									type="submit">Cadastrar</button>
								<button id="button2id" name="button2id" class="btn btn-danger"
									type="reset">Limpar</button>
							</div>
						</div>

					</fieldset>
				</form>
			</div>


		</div>
	</div>

	<script type="text/javascript">
		$("#categorias")
				.on(
						'change',
						function() {
							$
									.get("Teste?codCategoria=" + this.value)
									.done(
											function(data) {
												$('#produtos').empty();
												for ( var produto in data["Produtos"]) {
													$('#produtos')
															.append(
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

