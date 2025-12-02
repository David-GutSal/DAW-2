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
  document
    .getElementById("cCorreo")
    .addEventListener(`click`, comprobarCorreo, false);
  document
    .getElementById("cPalabras")
    .addEventListener(`click`, comprobarPalabra, false);
  document
    .getElementById("cDNI")
    .addEventListener(`click`, comprobarDNI, false);

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

function comprobarCorreo(){
  let correo = prompt("Introduce un correo");
  let patron = /[a-z]{1,}@gmail[.][es|com|net|org]{1}/;
  alert(patron.test(correo));
}

function comprobarPalabra(){
  let texto = prompt("Escibe un texto");
  let patron = /\w{0,}[paca|vaca|baca|caca]{1,}\w{0,}/;
  let myArray;
  myArray = patron.exec(texto)
  var msg = "Se ha encontrado " + myArray;
  console.log(msg);
}

function comprobarDNI(){
  let texto = prompt("Escibe un DNI");
  let patron = /[A-Z]{1}\d{8}/;
  alert(patron.test(texto));
}