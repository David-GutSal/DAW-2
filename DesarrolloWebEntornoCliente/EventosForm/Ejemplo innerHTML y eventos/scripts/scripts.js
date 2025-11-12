
window.onload = function () {
  document
    .getElementById("tablaDatos")
    .addEventListener(
      "click",
      crearNuevaFila.bind(document.getElementById("tablaDatos")),
      false
    );
};
//Ejemplo Punto 1.7 de los apuntes
function crearNuevaFila() {
  let numFilas = this.childElementCount;
  let fila = document.createElement("tr");
  fila.setAttribute("id", numFilas);
  let td1 = document.createElement("td");
  td1.innerText = numFilas+1;
  let td2 = document.createElement("td");
  td2.innerText = numFilas+2;
  fila.appendChild(td1);
  fila.appendChild(td2);
  this.appendChild(fila);
  document.getElementById(numFilas).addEventListener(
    "click",
    (event) => {
      alert("Id: " + event.currentTarget.id);
      event.stopPropagation();
    },
    false
  );
}
