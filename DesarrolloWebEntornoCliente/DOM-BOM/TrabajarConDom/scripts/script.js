/*
let id = document.getElementById("apellido1");
let p = document.getElementsByTagName("p");
let div = document.getElementById("seccionTercera").getElementsByTagName("p");
let inputs = document.getElementsByTagName("input");
let imputsName = document.getElementsByName("sexo");
let classpar = document.getElementsByClassName("par");

let p1sec = document.querySelector("#seccionPrimera p");
let p3d = document.getElementById("seccionPrimera").lastChild;
let ulist = document.getElementsByTagName("ul").lastChild;
let labelN = document.getElementsByName("nombre").previousElementSibling;
*/
function incertarAtributo(){
    let sT = document.getElementById("seccionTercera");
    let sS = document.getElementById("seccionSegunda");
    let sP = document.getElementById("seccionPrimera");
}

function incerth2() {
  let elh2 = document.createElement("h2");
  elh2.innerText = "Lorem Ipsum de nuevo";
  let sT = document.getElementById("seccionTercera");
  let felem = sT.getElementsByTagName("p")[0];
  sT.insertBefore(elh2, felem);
}

function move(){
    let sP = document.getElementById("seccionPrimera");
    let sT = document.getElementById("seccionTercera");
    let p3 = sP.getElementsByTagName("p")[2];
    let felem = sT.getElementsByTagName("p")[0];
    sT.insertBefore(p3, felem);

}

function que(){
    let div = document.createElement("div");
    div.setAttribute("id", "clon");
    let body = document.getElementsByTagName("body")[0];
    body.appendChild(div);
    let lista = document.getElementById("seccionLista");
    let clon = lista.cloneNode(true);
    div.appendChild(clon);
}

function removeFromList(){
    let clon = document.getElementById("clon");
    let elemento = clon.getElementsByTagName("li")[4];
    elemento.remove();
}