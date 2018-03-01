<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<c:url value="/" var="contextPath" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="icon"
	href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979"
	type="image/ico" />
<link href="https://plus.googlecom/108540024862647200608"
	rel="publisher" />
<title>Livros de Java, SOA, Android, iPhone, Ruby on Rails e
	muito mais - Casa do C�digo</title>
<link href="${contextPath}resources/css/cssbase-min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' />
<link href="${contextPath}resources/css/fonts.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-ie7.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-embedded.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/layout-colors.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/responsive-style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/guia-do-programador-style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/produtos.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="canonical" href="http://www.casadocodigo.com.br/" />
</head>
<tags:pageTemplate titulo="Livros de Java, Android, iOS, Mobile, e muito mais...">
<section class="container middle">
	<h2 id="cart-title">Seu carrinho de compras</h2>


	<table id="cart-table">
		<colgroup>
			<col class="item-col" />
			<col class="item-price-col" />
			<col class="item-quantity-col" />
			<col class="line-price-col" />
			<col class="delete-col" />
		</colgroup>
		<thead>
			<tr>
				<th class="cart-img-col"></th>
				<th width="65%">Item</th>
				<th width="10%">Pre�o</th>
				<th width="10%">Quantidade</th>
				<th width="10%">Total</th>
				<th width="5%"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrinhoCompras.itens}" var="item">
				<tr>
					<td class="cart-img-col"><img
						src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145"
						width="71px" height="100px" /></td>
					<td class="item-title">${item.produto.titulo}</td>
					<td class="numeric-cell">${item.preco}</td>
					<td class="quantity-input-cell"><input type="number" min="0"
						readonly="readonly" id="quantidade" name="quantidade"
						value="${carrinhoCompras.getQuantidade(item)}" /></td>
					<td class="numeric-cell">${carrinhoCompras.getTotal(item)}</td>
					<form:form
						action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1, item.tipoPreco).build()}"
						method="POST">
						<td><input type="image"
							src="${contextPath }resources/imagens/excluir.png" alt="Excluir"
							title="Excluir" /></td>
					</form:form>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3"><form:form
						action="${s:mvcUrl('PC#finalizar').build() }" method="POST">
						<input type="submit" class="checkout" id="checkout"
							name="checkout" value="Finalizar compra" />
					</form:form></td>
				<td class="numeric-cell">${carrinhoCompras.total}</td>
				<td></td>
			</tr>
		</tfoot>
	</table>

	<h2>Voc� j� conhece os outros livros da Casa do C�digo?</h2>
	<ul id="collection" class="related-books">
		<li class="col-left"><a href="/products/livro-plsql"
			class="block clearfix book-suggest"
			data-book="PL/SQL: Domine a linguagem do banco de dados Oracle">
				<img width="113px" height="160px"
				src="http:////cdn.shopify.com/s/files/1/0155/7645/products/plsql-featured_compact.png?v=1434740236"
				alt="PL/SQL: Domine a linguagem do banco de dados Oracle" />
		</a></li>
	</ul>

	<h2>
		<a href="http://www.casadocodigo.com.br">Veja todos os livros que
			publicamos!</a>
	</h2>
</section>
</tags:pageTemplate>
</html>