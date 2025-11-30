var deporteAGuardar = {};
var calendarioGenerado = false;

function nuevoCalendario() {
    let deporteIntroducido = document.getElementById("deporte").value;

    if (deporteIntroducido === "") {
        alert("Debe introducir un deporte");
        return;
    }

    deporteAGuardar = {
        deporte: deporteIntroducido,
        numeroReservas: 0
    }

    pintarCalendario();
}

/* function pintarCalendario() {
    let dias = Array.from(document.getElementsByTagName("td"));

    for (let index = 0; index < 30; index++) {
        dias[index].textContent = index + 1;

    }
    calendarioGenerado = true;
    crearIntervalo();
}
 */

function pintarCalendario() {
    let dias = Array.from(document.getElementsByTagName("td"));

    let fechaActual = new Date();
    let mes = fechaActual.getMonth();
    let anio = fechaActual.getFullYear();
    let numeroDeDiasDelMes = new Date(anio, mes + 1, 0).getDate();
    let posicionEnLaSemana = new Date(anio, mes, 1).getDay();

    let posicionInicial = 0;
    if (posicionEnLaSemana == 0) {
        posicionInicial = 6;
    } else {
        posicionInicial = posicionEnLaSemana - 1;
    }

    let numeroPintados = 1;
    for (let index = posicionInicial; index < numeroDeDiasDelMes + posicionInicial; index++) {
        dias[index].textContent = numeroPintados++;
    }

    calendarioGenerado = true;
    crearIntervalo();
}

function crearIntervalo() {
    let idItervalo = setInterval(() => {
        let numero = calcularNumeroCeldasLibres();
        let avisoNuevo = document.createElement("p");
        avisoNuevo.textContent = `Quedan ${numero} días libres`;

        let divAvisos = document.getElementById("divAvisos");
        divAvisos.appendChild(avisoNuevo);

    }, 3000);
}

function calcularNumeroCeldasLibres() {

    let celdasReservables = Array.from(document.getElementsByTagName("td"));

    let numero = 0;
    celdasReservables.forEach(element => {
        if ((element.textContent != "" && !element.classList.contains("fondoViolet")) &&
            !element.classList.contains("casillaSeleccionada")) {
            numero++;
        }
    });

    return numero;
}

function cambiarColor(celda) {

    if (calendarioGenerado && celda.textContent != "" &&
        !celda.classList.contains("casillaSeleccionada")) {
        celda.classList.add("casillaSeleccionada");
        deporteAGuardar.numeroReservas++;
        let numero = calcularNumeroCeldasLibres();
        if (numero === 0) {
            alert("No quedan días libres");
            guadarDatosReserva();
            window.location.reload();
        }
    }
}

function guadarDatosReserva() {
    let url = "http://localhost:3000/reservas";

    let init = {
        method: "POST",
        body: JSON.stringify(deporteAGuardar),
        headers: { 'Content-Type': 'application/json' }
    }

    fetch(url, init);
}