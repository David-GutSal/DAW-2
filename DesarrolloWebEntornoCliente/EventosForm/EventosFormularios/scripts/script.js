let idInterval;
function cargarEventos() {
  document
    .getElementById("botton1")
    .addEventListener(`click`, mostrarAlert, false);
  document
    .getElementById("botton2")
    .addEventListener(`click`, pararAlert, false);

  document.addEventListener("keydown", (event) => {
    let parraph = document.getElementById("keyCode");
    parraph.innerText = "Codigo de tecla pulsado: " + event.keyCode;
  });

  document.addEventListener("dblclick", () => {
    let body = document.getElementsByTagName("body")[0];
    body.style.backgroundColor = randomColor();
  });

  document
    .getElementById("cDigitos")
    .addEventListener(`click`, comprobarCadena, false);

  document
    .getElementById("cFecha")
    .addEventListener(`click`, comprobarFecha, false);

}

function mostrarAlert() {
  idInterval = setInterval(() => {
    alert(`Este sábado a las 3 son las 2`);
  }, 5000);
}

function pararAlert() {
  clearInterval(idInterval);
}

function randomColor() {
  let colors = [
    "#ffd7d5",
    "#ffe9d6",
    "#ffffd1",
    "#d6ffda",
    "#d7eeff",
    "#dad6ff",
    "#ffd6e8",
    "#f5f5dc",
    "#f4e4e4",
    "#e4e6f4",
  ];

  let color = colors[Math.floor(Math.random() * colors.length)];
  return color;
}

function comprobarCadena(){
  let cadena = prompt("Introduce una cadena de 10 digitos seguidos alfanumericos");
  let patron = /\w{10,}/;
  alert(patron.test(cadena));
}

function comprobarFecha(){
  let fecha = prompt("Introduce una fecha");
  let patron = /\d{2}[-|/]{1}\d{2}[-|/]{1}[\d{4}|\d{2}]/;
  alert(patron.test(fecha));
}