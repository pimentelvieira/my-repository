function inserePlacar() {
	var corpoTabela = $(".placar").find("tbody");
	var usuario = "William";
	var numPalavras = $("#contador-palavras").text();

	var linha = novaLinha(usuario, numPalavras);
	corpoTabela.prepend(linha);
}

function novaLinha(usuario, numPalavras) {
	var linha = $("<tr>");
	var colunaUsuario = $("<td>").text(usuario);
	var colunaPalavras = $("<td>").text(numPalavras);
	var colunaRemover = $("<td>");
	var link = $("<a>").addClass("botao-remover").attr("href", "#");
	link.click(removeLinha);
	var icone = $("<i>").addClass("small").addClass("material-icons").text("delete");

	link.append(icone);
	colunaRemover.append(link);
	linha.append(colunaUsuario);
	linha.append(colunaPalavras);
	linha.append(colunaRemover);

	return linha;
}

function removeLinha() {
	event.preventDefault();
	$(this).parent().parent().remove();
}