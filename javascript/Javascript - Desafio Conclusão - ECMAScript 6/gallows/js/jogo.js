const criaJogo = sprite => {

	const setPalavraSecreta = palavra => {

		if(!palavra.trim()) throw new Error("Palavra secreta inválida!");
		palavraSecreta = palavra;
		criaLacunas();
		proximaEtapa();
	};

	const getLacunas = () => lacunas;

	const getEtapa = () => etapa;

	const processaChute = chute => {

		if(!chute.trim()) throw new Error("Chute inválido!");

		const exp = new RegExp(chute, "gi");
		let resultado, acertou = false;

		while(resultado = exp.exec(palavraSecreta)) {
			lacunas[resultado.index] = chute;
			acertou = true;
		}

		if(!acertou) sprite.nextFrame();
	};

	const criaLacunas = () => {
		for(let i = 0; i < palavraSecreta.length; i++) {
			lacunas.push("");
		}
	};

	const proximaEtapa = () => etapa = 2;

	const ganhou = () => lacunas.length == 0 ? false : palavraSecreta == lacunas.join("");

	const perdeu = () => sprite.isFinished();

	const ganhouOuPerdeu = () => ganhou() || perdeu();

	const reinicia = () => {
		etapa = 1;
		lacunas = [];
		palavraSecreta = "";
		sprite.reset();
	};

	let palavraSecreta = "";
	let lacunas = [];
	let etapa = 1;

	return {
		setPalavraSecreta,
		getLacunas,
		getEtapa,
		processaChute,
		ganhou,
		perdeu,
		ganhouOuPerdeu,
		reinicia
	};
};