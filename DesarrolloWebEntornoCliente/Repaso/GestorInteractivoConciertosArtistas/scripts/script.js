window.onload = () => {
  cargarDesplegable();

  document
    .getElementsByTagName("li")[0]
    .addEventListener("click", gestionArtista, false);
  document
    .getElementsByTagName("li")[1]
    .addEventListener("click", gestionConcierto, false);
  document
    .getElementsByTagName("li")[2]
    .addEventListener("click", listarInformacion, false);
};

function cargarDesplegable() {
  fetch("http://localhost:3000/generosMusicales")
    .then((r) => r.json())
    .then((data) => {
      generos = data;
      mostrarDesplegableGenerosM(generos);
    })
    .catch((err) => console.error(err));

  fetch("http://localhost:3000/paises")
    .then((r) => r.json())
    .then((data) => {
      paises = data;
      mostrarDesplegablePais(paises);
    })
    .catch((err) => console.error(err));
}

function mostrarDesplegableGenerosM(generos) {
  let desplegable = document.getElementById("generosM");
  Array.from(generos).forEach((genero) => {
    let option = document.createElement("option");
    option.innerText = genero.nombre;
    option.value = genero.id;
    desplegable.appendChild(option);
  });
}

function mostrarDesplegablePais(paises) {
  let desplegable = document.getElementById("paisesDesplegable");
  Array.from(paises).forEach((pais) => {
    let option = document.createElement("option");
    option.innerText = pais.nombre;
    option.value = pais.id;
    desplegable.appendChild(option);
  });
}

function gestionArtista(){
    
}