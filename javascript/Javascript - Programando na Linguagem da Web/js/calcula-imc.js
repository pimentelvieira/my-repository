var titulo = document.querySelector(".titulo");
titulo.textContent = "Aparecida Nutricionista";

var pacientes = document.querySelectorAll(".paciente");

for (var i = 0; i < pacientes.length; i++) {
	var paciente = pacientes[i];

	var peso = paciente.querySelector(".info-peso").textContent;
	var altura = paciente.querySelector(".info-altura").textContent;

	if (validaPaciente(peso, altura)) {
		var imc = calculaImc(peso, altura);
		paciente.querySelector(".info-imc").textContent = imc;
	} else {
		paciente.querySelector(".info-imc").textContent = "Inválido";
		paciente.classList.add("paciente-invalido");
	}
}

function calculaImc(peso, altura) {
	var imc = 0;
	imc = peso / (altura * altura);
	return imc.toFixed(2);
}

function validaPaciente(peso, altura) {
	var erros = [];
	if(!(peso >= 0 && peso < 1000
		&& altura >= 0 && altura <= 3)) {
		erros.push("Dados inválidos!");
	}

	return erros;
}