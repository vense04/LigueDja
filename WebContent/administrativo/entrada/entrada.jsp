<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="dominio.Entrada"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Relátorio Entrada - LigueDjá</title>
</head>
<body>
<h1>Relatório de entrada</h1>
<hr/>
<h2>Selecione os intervalos</h2>

<table border="1">
		<a href="<%=request.getContextPath()%>/RelatServlet?nomeRelat=relatorioEntrada&dataInicial=01/02/2014&dataFinal=30/03/2014">Entre 01/02/2014 á 31/03/2014</a>
		<a href="<%=request.getContextPath()%>/RelatServlet?nomeRelat=relatorioEntrada&dataInicial=01/04/2014&dataFinal=31/05/2014">Entre 01/04/2014 á 31/05/2014</a>
		<a href="<%=request.getContextPath()%>/RelatServlet?nomeRelat=relatorioEntrada&dataInicial=01/06/2014&dataFinal=31/07/2014">Entre 01/06/2014 á 31/07/2014</a>
		<a href="<%=request.getContextPath()%>/RelatServlet?nomeRelat=relatorioEntrada&dataInicial=01/08/2014&dataFinal=30/09/2014">Entre 01/08/2014 á 30/09/2014</a>
		<a href="<%=request.getContextPath()%>/RelatServlet?nomeRelat=relatorioEntrada&dataInicial=01/10/2014&dataFinal=30/11/2014">Entre 01/10/2014 á 30/11/2014</a>
		<a href="<%=request.getContextPath()%>/RelatServlet?nomeRelat=relatorioEntrada&dataInicial=01/12/2014&dataFinal=31/01/2015">Entre 01/12/2014 á 31/01/2015</a>
</table>
</body>
</html>

