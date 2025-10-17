function recuperar(url, init) {
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
    .then((result) => console.log(result))
    .catch((error) => console.error(error));
}

function recuperarAnimales() {
    init = { method: "GET" };
    recuperar("http://localhost:3000/animales", init);

}

function mostrarAnimales(animales) {
    let select = document.getElementById("lista-animales");
    animales.forEach(animal => {
        let opcion = document.createElement("option");
        opcion.value = animal.id;
        opcion.textContent = animal.Tipo;
        select.appendChild(opcion);
    });
    }

/*
function nuevaTarea() {
  let url = "https://jsonplaceholder.typicode.com/todos";
  let tarea = {
    userID: 5,
    title: "Prueba de POST",
    completed: false,
  };
  let init = {
    method: "POST",
    body: JSON.stringify(tarea),
    headers: {
      "Content-type": "application/json",
    },
  };
  recuperar(url, init);
}

function editarTarea(){
  let url = "https://jsonplaceholder.typicode.com/todos/76";
  let tarea = {
    userID: 4,
    title: "Tarea modificada",
    completed: true,
  };
  let init = {
    method: "PUT",
    body: JSON.stringify(tarea),
    headers: { 
      "Content-type": "application/json",
    },
  };
  recuperar(url, init);
}

function eliminarTarea(){
  let url = "https://jsonplaceholder.typicode.com/todos/32";
  let init = {
    method: "DELETE",
  };
  recuperar(url, init);
}
*/