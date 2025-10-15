/*function recuperarDatos() {
  let idUser = document.getElementById("idUser").value;
  if (isNaN(idUser) || idUser == "") {
    alert("Debes introducir un número");
  } else {
    fetch("https://jsonplaceholder.typicode.com/posts?" + "userId=" + idUser)
      .then((response) => response.json()) //En la ejecucuión del primer then, recuperamos los datos incluidos en la respuesta
      .then((infoPosts) => mostrarDatos(infoPosts))
      .catch((error) => console.error(error));
  }
}

function mostrarDatos(infoPosts) {
  let tbody = document.getElementsByTagName("tbody")[0];
  tbody.innerHTML = "";
  infoPosts.forEach((post) => {
    const newPost = document.createElement("tr");
    newPost.innerHTML = `
                <td>${post.userId}</td>
                <td>${post.id}</td>
                <td>${post.title}</td>
                <td>${post.body}</td>`;
    tbody.appendChild(newPost);
  });
}*/
/*
function mostrarConsola() {
  fetch("https://jsonplaceholder.typicode.com/users/1") //devuelve una promesa
    .then((response) => response.json()) //El método json() devuelve otra promesa
    .then((datosUsuario) => console.log(datosUsuario)) //then() de la segunda promesa
    .catch((error) => console.error(error));
}
*/

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
    .then((tareaCreada) => console.log(tareaCreada))
    .catch((error) => console.error(error));
}
/*
function recuperarTareas() {
  recuperar("https://jsonplaceholder.typicode.com/todos");
}
*/
function recuperar55() {
  recuperar("https://jsonplaceholder.typicode.com/todos/76");
}
/*
function recuperar201() {
  recuperar("https://jsonplaceholder.typicode.com/todos/201");
}
*/

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
