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
		
        $("input.cpf").mask("999.999.999-99");
        $("input.cep").mask("99.999-999");
        $("input.telefone").mask("(99) 9999-9999");
});
</script>
</head>
<body>
	<%@ include file="/Template/header.jsp"%>
	<article id="address">
	<form method="post" action="<%= request.getContextPath() %>/AlterarCadastroClienteServlet" name="alteracliente">
	<div id="ship">
		<h1>Atualizar Endereco</h1>
	
			<input type="hidden"  name="codUsuario" value="<c:out value="${us.codUsuario }"/>" />
		
		
		<p>
			<label>Logradouro:</label> 
			<input name="logradouro" value="<c:out value="${us.logradouro}"/>" type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label>Número:</label> 
			<input name="numero" value="<c:out value="${us.numero}"/>"type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label>Complemento:</label> 
			<input name="complemento" value="<c:out value="${us.complemento}"/>"type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label>Cidade:</label> 
			<input name="cidade" value="<c:out value="${us.cidade}"/>" type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label>Estado:</label>
				
			<select name="uf" value="<c:out value="${us.uf}"/>" id="" onchange="javascript:startDisplay();">
				<option value="0">Selecione seu Estado</option>
				<option value="ac">Acre</option>
				<option value="al">Alagoas</option>
				<option value="ap">Amapá</option>
				<option value="am">Amazonas</option>
				<option value="ba">Bahia</option>
				<option value="ce">Ceará</option>
				<option value="df">Distrito Federal</option>
				<option value="es">Espirito Santo</option>
				<option value="go">Goiás</option>
				<option value="ma">Maranhão</option>
				<option value="ms">Mato Grosso do Sul</option>
				<option value="mt">Mato Grosso</option>
				<option value="mg">Minas Gerais</option>
				<option value="pa">Pará</option>
				<option value="pb">Paraíba</option>
				<option value="pr">Paraná</option>
				<option value="pe">Pernambuco</option>
				<option value="pi">Piauí</option>
				<option value="rj">Rio de Janeiro</option>
				<option value="rn">Rio Grande do Norte</option>
				<option value="rs">Rio Grande do Sul</option>
				<option value="ro">Rondônia</option>
				<option value="rr">Roraima</option>
				<option value="sc">Santa Catarina</option>
				<option value="sp">São Paulo</option>
				<option value="se">Sergipe</option>
				<option value="to">Tocantins</option>
			</select>
		</p>
		<p>
			<label>CEP:</label> 
			<input name="cep" value="<c:out value="${us.cep}"/>"type="text" id="" class="cep" required><span class="alert">*</span>
		</p>
	
	<!--  
	<div id="ship">
		<h1>Endereço para entrega</h1>
		<p>
			<label for="">Logradouro:</label> 
			<input name="log" type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label for="">Número:</label> 
			<input name="num" type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label for="">Complemento:</label> 
			<input name="compl" type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label for="">Cidade:</label> 
			<input name="cidade" type="text" id="" required><span class="alert">*</span>
		</p>
		<p>
			<label for="">Estado:</label>
				
			<select name="estado" id=""name="" onchange="javascript:startDisplay();">
				<option value="0">Selecione seu Estado</option>
				<option value="ac">Acre</option>
				<option value="al">Alagoas</option>
				<option value="ap">Amapá</option>
				<option value="am">Amazonas</option>
				<option value="ba">Bahia</option>
				<option value="ce">Ceará</option>
				<option value="df">Distrito Federal</option>
				<option value="es">Espirito Santo</option>
				<option value="go">Goiás</option>
				<option value="ma">Maranhão</option>
				<option value="ms">Mato Grosso do Sul</option>
				<option value="mt">Mato Grosso</option>
				<option value="mg">Minas Gerais</option>
				<option value="pa">Pará</option>
				<option value="pb">Paraíba</option>
				<option value="pr">Paraná</option>
				<option value="pe">Pernambuco</option>
				<option value="pi">Piauí</option>
				<option value="rj">Rio de Janeiro</option>
				<option value="rn">Rio Grande do Norte</option>
				<option value="rs">Rio Grande do Sul</option>
				<option value="ro">Rondônia</option>
				<option value="rr">Roraima</option>
				<option value="sc">Santa Catarina</option>
				<option value="sp">São Paulo</option>
				<option value="se">Sergipe</option>
				<option value="to">Tocantins</option>
			</select>
		</p>
		<p>
			<label for="">CEP:</label> 
			<input name="cep" type="text" id="" class="cep" required><span class="alert">*</span>
		</p>
		<p>
			<label>&nbsp;</label>
			<button type="submit" class="continue" onclick="location. href=' "<%=request.getContextPath()%>/WebContent/InserirCadastroClienteServlet?cmd=inserir">Enviar </button>
		</p>
	</div>
	-->
		<p>
			<label>&nbsp;</label>
			<button type="submit" class="continue" onclick="location. href=' "<%=request.getContextPath()%>/AlterarCadastroClienteServlet?cmd=atualizar">Enviar </button>
		</p>
	</form>
	</article>

	<%@ include file="/Template/footer.jsp"%>

</body>
</html>