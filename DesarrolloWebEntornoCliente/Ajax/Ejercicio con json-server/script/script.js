function recuperarTipo(url, init) {
  fetch(url, init)
    .then((response) => {
      console.log(response);
      if (response.ok) {
        return response.json();
      } else {
        return (
          "Error HTTP:" + response.status + "(" + response.statusText + ")"
        );
      }
    })
    .then((animales) => mostrarOpciones(animales))
    .catch((error) => console.error(error));
}

function recuperarAnimales(url, init) {
  fetch(url, init)
    .then((response) => {
      console.log(response);
      if (response.ok) {
        return response.json();
      } else {
        return (
          "Error HTTP:" + response.status + "(" + response.statusText + ")"
        );
      }
    })
    .then((animales) => mostrarAnimales(animales))
    .catch((error) => console.error(error));
}

function recuperarTipoAnimales() {
  init = { method: "GET" };
  recuperarTipo("http://localhost:3000/animales", init);
}

function recuperarAnimales() {
  init = { method: "GET" };
  recuperarAnimales("http://localhost:3000/animales", init);
}
/*
function nuevoAnimal() {
  let url = "http://localhost:3000/animales";
  let animal = {
    Tipo: "Gato",
    Nombre: "Holmes",
    Observacion: "No se",
    Ubicacion: "Se encuentra en robledo cerca a la quintana",
    Rasgos: "Tiene el pelo cafe",
    Imagen: "https://www.elpaisdelosjovenes.com/wp-content/uploads/2015/05/03_02.jpg"
  };
  let init = {
    method: "POST",
    body: JSON.stringify(animal),
    headers: {
      "Content-type": "application/json",
    },
  };
  recuperar(url, init);
}
*/
function mostrarOpciones(animales) {
  let select = document.getElementById("lista-animales");
  let tipoAnimales = [];
  animales.forEach((animal) => {
    if (tipoAnimales.find((tipo) => animal.Tipo == tipo)) {
      console.log("tipo repetido");
    } else {
      tipoAnimales.push(animal.Tipo);
    }
  });
  console.log(tipoAnimales);
  tipoAnimales.forEach((tipo) => {
    let opcion = document.createElement("option");
    opcion.value = tipo;
    opcion.textContent = tipo;
    select.appendChild(opcion);
  });
}

function mostrarAnimales(animales) {
  let tabla = document.createElement("table");
  animales.forEach((animal) => {
    console.log(animal);
    let columna = document.createElement("tr");
    columna.innerHTML = `
                <td>${animal.Nombre}</td>
                <td>${animal.Rasgos}</td>`;
    tabla.appendChild(columna);
  });
  let body = document.getElementsByTagName("body")[0];
  body.appendChild(tabla);
}

