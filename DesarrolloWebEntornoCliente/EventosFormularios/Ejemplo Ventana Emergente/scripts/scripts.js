window.onload = () => {
  let form1 = document.getElementById("form1");
  form1.addEventListener("submit", validarFormulario);
};

function validarFormulario(event) {
  event.preventDefault();

  let nombre = document.getElementById("nombre");
  let nombreError = document.getElementById("errorNombre");
  let email = document.getElementById("mail");
  let emailError = document.getElementById("errorEmail");

  let todoCorrecto = true;
  nombreError.textContent = nombre.validationMessage;
  if (!nombre.validity.valid) {
    todoCorrecto = false;
  }
  emailError.textContent = email.validationMessage;
  if (!email.validity.valid) {
    todoCorrecto = false;
  }
  if (todoCorrecto) {
    let datosUsuario = {
        nombreUsuario: nombre.value,
        emailUsuario: email.value 
    };

    sessionStorage.setItem("datosUsuario", JSON.stringify(datosUsuario));

    let ventanilla = window.open(
      "./src/emergente.html", "pop-up","width=500,height=300");   
  }
}
