let idInterval;
function cargarEventos() {
  document
    .getElementById("botton1")
    .addEventListener(`click`, mostrarAlert, false);
  document
    .getElementById("botton2")
    .addEventListener(`click`, pararAlert, false);
}
function mostrarAlert() {
    idInterval = setInterval(()=>{
        alert(`Este sábado a las 3 son las 2`);
    }, 5000);

  }
function pararAlert(){
    clearInterval(idInterval);
}
