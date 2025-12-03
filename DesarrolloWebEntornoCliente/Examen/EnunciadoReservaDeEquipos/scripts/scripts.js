window.onload = () => {
  cargarDesplegable();

  let campoDuracion = document.getElementById("grupoDuracion");

  campoDuracion.getElementsByTagName("label")[0].addEventListener("mouseover", aplicarNuevoEstilo, false);
  campoDuracion.getElementsByTagName("label")[1].addEventListener("mouseover", aplicarNuevoEstilo, false);
  campoDuracion.getElementsByTagName("label")[2].addEventListener("mouseover", aplicarNuevoEstilo, false);
  campoDuracion.getElementsByTagName("label")[0].addEventListener("mouseout", eliminarNuevoEstilo, false);
  campoDuracion.getElementsByTagName("label")[1].addEventListener("mouseout", eliminarNuevoEstilo, false);
  campoDuracion.getElementsByTagName("label")[2].addEventListener("mouseout", eliminarNuevoEstilo, false);

  document.getElementById("formularioReserva").addEventListener("submit", validarFormulario, false);
};

function cargarDesplegable(){
    fetch("http://localhost:3000/tiposEquipo")
    .then(r => r.json())
    .then(data => {
      equipos = data;
      mostrarEnDesplegable(equipos);
    })
    .catch(err => console.error(err));
}

function mostrarEnDesplegable(equipos){
    let desplegable = document.getElementById("equipo");
   Array.from(equipos).forEach(equipo => {
        let option = document.createElement("option");
        option.innerText = equipo.tipo;
        option.value = equipo.tipo;
        desplegable.appendChild(option);
    });
}

function validarFormulario(event){
  event.preventDefault();
  let expedienteInput = document.getElementById("expediente");
  let emailInput = document.getElementById("email");
  let equipoSeleccionado = document.getElementById("equipo");
  let fechaInput = document.getElementById("fecha");
  let horaInput = document.getElementById("hora");
  let radioButton = document.getElementsByTagName("radio");
  let textObservaciones = document.getElementById("observaciones");

  let todoCorrecto = true;
  if(!expedienteInput.validity.valid){
    expedienteInput.classList.add("error-input");
    todoCorrecto = false;
  }
  if(!emailInput.validity.valid){
    emailInput.classList.add("error-input");
    todoCorrecto = false;
  }
  if(!equipoSeleccionado.validity.valid){
    equipoSeleccionado.classList.add("error-input");
    todoCorrecto = false;
  }
  if(!fechaInput.validity.valid){
    fechaInput.classList.add("error-input");
    todoCorrecto = false;
  }
  if(!horaInput.validity.valid){
    horaInput.classList.add("error-input");
    todoCorrecto = false;
  }

  if(textObservaciones.innerText == null){
    textObservaciones.values = "";
  }

  if (todoCorrecto) {
    let datos = {
        numExpediente: expedienteInput.value,
        correoE: emailInput.value,
        tipoEquipo: equipoSeleccionado.value,
        fecha: fechaInput.value,
        hora: horaInput.value,
        duracion: radioButton.value, 
        observaciones: textObservaciones.values
    };

    let init = {
    method: "POST",
    body: JSON.stringify(datos),
    headers: { "Content-Type": "application/json" }
  };

  fetch("http://localhost:3000/reservas", init)
  .catch(error => {
    console.error("Se ha producido un error en la petición :" + error);
  });

  limpiarDatos();

}

function limpiarDatos(){
    let input = document.getElementsByTagName("input");
    for(let i = 0; i<input.length; i++){
        input[i].value = "";
    }
}
}

function aplicarNuevoEstilo(){
    this.classList.add("hover-duracion");
}

function eliminarNuevoEstilo(event){
    this.classList.remove("hover-duracion");
}