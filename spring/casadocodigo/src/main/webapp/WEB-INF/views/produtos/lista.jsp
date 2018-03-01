<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Livros de Java, iPhone, Android - Casa do C�digo</title>
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Casa do C�digo</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${s:mvcUrl('PC#listar').build()}">Lista de Produtos</a></li>
					<li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="#">
							Usu�rio: <security:authentication property="principal.username" />
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<h1>Lista de Produtos</h1>
		<div>${sucesso}</div>
		<div>${falha}</div>
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>T�tulo</th>
				<th>Descri��o</th>
				<th>Pre�os</th>
				<th>P�ginas</th>
			</tr>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td><a
						href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
					</td>
					<td>${produto.descricao}</td>
					<td>${produto.precos}</td>
					<td>${produto.paginas}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>