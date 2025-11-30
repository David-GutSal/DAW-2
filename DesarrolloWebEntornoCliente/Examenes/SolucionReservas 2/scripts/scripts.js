var diasDisponibles = 0;
var nuevoDeporte = {
      deporte: "",
      numeroReservas: 0
};
var mesGenerado = false;
var idIntervaloAvisos = null;


function nuevoCalendario() {
  let deporte = document.getElementById("deporte").value;
  if (deporte == null || deporte == "") {
    alert("Introduzca un deporte para el que reservar pistas");
    return;
  }
  nuevoDeporte.nombreDeporte = deporte;
  completarCalendario();
  activarAvisos();  
}

function completarCalendario() {
  let fechaActual = new Date(); //Día en que se ejecuta la acción
  let diaACompletar = new Date( fechaActual.getFullYear(),fechaActual.getMonth(),1); //Fecha del primer día del mes, que será la primera en escribirse en el calendario
  let numDiasMes = new Date(fechaActual.getFullYear(),fechaActual.getMonth()+1,0); //Fecha del último día del mes
  let diaUnoSemana = diaACompletar.getDay(); //Posición del primer día de mes en la semana (domingo, lunes, martes, etc.)
  

  let casillasMes = document.getElementsByTagName("td");
  let indexDia = diaUnoSemana == 0 ? 7 : diaUnoSemana; //Si el primer día cae en domingo, para nosotros es 7(el sistema anglosajón lo considera le primer día de la semana) 
  for (let index = 1; index <= numDiasMes.getDate(); index++) { //Desde el primer día de mes hasta el último
    casillasMes[indexDia-1].innerText = index; //Escribe el día del mes en la posición adecuada dentro de la semana
    //Si no es sábado ni domingo será día seleccionable
    if (!(diaACompletar.getDay() == 0) && !(diaACompletar.getDay() == 6)) { //Si no es sábado ni domingo
      diasDisponibles++; //Se van contabilizando los días disponibles para ser reservados
    }
    diaACompletar.setDate(diaACompletar.getDate() + 1);
    indexDia++;
  }

  mesGenerado = true;
}

function activarAvisos() {
  let numAvisos = 0;
  clearInterval(idIntervaloAvisos);

  let divAvisosTemp = document.createElement("div");
  document.getElementById("divAvisos").appendChild(divAvisosTemp);

  idIntervaloAvisos = setInterval(() => {
    if (diasDisponibles === 0 || numAvisos === 15) {
      alert("No se puede seguir reservando");
      almacenarDatos();
      resetearCalendario();
    } else {
      let aviso = document.createElement("p");
      aviso.innerText = `Quedan ${diasDisponibles} libres`;
      divAvisosTemp.appendChild(aviso);
      aviso.scrollIntoView();
      numAvisos++;
    }
  }, 3000);
}

function cambiarColor(casilla) {

  if (mesGenerado && (casilla.innerText!="")) {
    if (!casilla.classList.contains("casillaSeleccionada")) {
      casilla.classList.add("casillaSeleccionada");
      diasDisponibles--;
      nuevoDeporte.numReservas++;
      if (diasDisponibles === 0) {
        alert("No queda días para reservar");
        almacenarDatos();
        resetearCalendario();
      }
    }
  }
}

function resetearCalendario() {
  clearInterval(idIntervaloAvisos);

  mesGenerado = false;
  idIntervaloAvisos = null;
  diasDisponibles = 0;
  nuevoDeporte = {
    deporte: "",
    numeroReservas: 0
  };

  let casillasMes = document.getElementsByTagName("td");
  for (var i = 0; i < casillasMes.length; i++) {
    casillasMes[i].innerText = "";
    casillasMes[i].classList.remove("casillaSeleccionada");
  }

  document.getElementById("deporte").value = "";
  let divAvisos = document.getElementById("divAvisos");
  divAvisos.removeChild(divAvisos.lastElementChild);

}

function almacenarDatos() {
  let init = {
    method: "POST",
    body: JSON.stringify(nuevoDeporte),
    headers: { "Content-Type": "application/json" }
  };

  fetch("http://localhost:3000/reservas", init)
  .catch(error => {
    console.error("Se ha producido un error en la petición");
    alert("No se ha podido procesar el almacenamiento de los datos");
  });
}