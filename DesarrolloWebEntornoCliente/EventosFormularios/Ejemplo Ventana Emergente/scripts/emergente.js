window.onload = () => {
  let boton1 = document.getElementById("botonVolver");
  let boton2 = document.getElementById("botonTerminar");

  boton1.addEventListener( "click", (event) => { window.close(); },false );

  boton2.addEventListener( "click", (event) => { 
        window.opener.document.getElementById("form1").submit(); 
        window.close(); 
    }, false);

  let divDatosUsuario = document.getElementById("datosUsuario");
  const datosUsuario = JSON.parse(sessionStorage.getItem("datosUsuario"));

  let pNombre = document.createElement("p");
  pNombre.textContent = datosUsuario.nombreUsuario;
  divDatosUsuario.appendChild(pNombre);

  let pEmail = document.createElement("p");
  pEmail.textContent = datosUsuario.emailUsuario;
  divDatosUsuario.appendChild(pEmail);
};
