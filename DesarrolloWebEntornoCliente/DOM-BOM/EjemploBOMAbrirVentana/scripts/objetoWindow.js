function cargarInformacion() {
    window.name = "Ventana";
    mostrarInfoInicial();

    //5 segundos después de cargar la página, se ejecutará la función que creará una ventana emergente
    setTimeout(() => {
        //Se crea una ventana nueva sin url específica, con el nombre "pop-up" y con las siguientes características:
        //sin toolbar, de tamañan 500*300, sin barra de menú, sin barras de scroll 
        //y a 300px del margen superior
        let ventanaNueva = window.open("", "pop-up", "toolbar=Yes,width=500,height=300,menubar=Yes,scrollbars=Yes,screenY=300,screenX=300");
        //se añade un elemento de tipo p a la nueva ventana que incliurá el nombre de la ventana que la ha creado
        let textoAMostrar = "En un agujero en el suelo, vivía un hobbit. No un agujero sucio, húmedo, repugnante, con restos de gusanos y olor a fango, ni tampoco un agujero seco, desnudo y arenoso, sin nada en qué sentarse o qué comer: era un agujero hobbit, y eso significa comodidad. Tenía una puerta redonda, perfecta como un ojo de buey pintado de verde, con una manilla de bronce dorada y brillante, justo en el medio. La puerta se abría a un vestíbulo cilíndrico, como un túnel: un túnel muy cómodo, sin humos, con paredes revestidas de maderas y suelos enlosados y alfombrados, provistos de sillas barnizadas y montones y montones de perchas para sombreros y abrigos; el hobbit era aficionado a las visitas. El túnel se extendía serpenteando, y penetraba bastante, pero no directamente, en la ladera de la Colina, y muchas puertecitas redondas se abrían en él, primero en un lado y luego al otro. Nada de subir escaleras para el hobbit: dormitorios, cuartos de baño, bodegas, despensas (muchas), armarios (habitaciones enteras dedicadas a ropa), cocinas, comedores se encontraban en la misma planta, y en el mismo pasillo. Las mejores habitaciones estaban todas a la izquierda de la puerta principal, pues eran las únicas que tenían ventanas, ventanas redondas, profundamente excavadas, que miraban al jardín y los prados de más allá, camino del río.";

        ventanaNueva.document.write(`<p>Soy un pop-up creado por ${ventanaNueva.opener.name} </p> <p> ${textoAMostrar}</p>`);
        //tras 5 segundos se modificará el tamaño de la página nueva
        setTimeout(() => {
            ventanaNueva.resizeTo(400, 150);
        }, 5000);

        //Si se recargara la página sin cerrar el pop-up, no se abriría uno nuevo, sino que, 
        //al existir ya uno con el nombre "Ventana", se cargarían los datos de nuevo sobre ese.
    }, 5000);
}

function mostrarInfoInicial() {
    let infoVentana = "Información de la ventana principal: ";
    infoVentana += `<br> Nombre de la ventana: ${window.name}`;
    infoVentana += `<br> Ancho/Alto externos: ${window.outerWidth + "/" + window.outerHeight}`;
    infoVentana += `<br> Ancho/Alto internos: ${window.innerWidth + "/" + window.innerHeight}`;
    infoVentana += `<br> Scrolls: ${window.scrollX} / ${window.scrollY}`;
    infoVentana += `<br> Distancia desde la esquina superior izquierda: ${window.screenX} / ${window.screenY}`;

    (document.getElementById("parrafo")).innerHTML = infoVentana;

    if (typeof(Storage) !== "undefined") {
        // Código a ejecutar en caso de que el navegador soporte Storage
        localStorage.setItem("colorFondo", "blue");
        console.log(localStorage);
        localStorage.colorFondo = "red";
        console.log(localStorage);
        localStorage.removeItem("colorFondo");
        console.log(localStorage);
      } else {
        // Código a ejecutar en caso contrario
      }

}