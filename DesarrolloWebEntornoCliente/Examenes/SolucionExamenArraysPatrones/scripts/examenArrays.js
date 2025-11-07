function comenzarAccion(accion) {
    let textoBusqueda = (document.getElementById("textArea").value).toUpperCase();
    let arrayPalabras = textoBusqueda.split(" ");
    
    switch (accion) {
        case "patrones":
            buscarPatrones(arrayPalabras);
            break;
        case "palabras":
            ordenarPalabras(arrayPalabras);
            break;
        case "numPalabras":
            calcularNumPalabras(arrayPalabras);
            break;
        default:
            break;
    }
}

function buscarPatrones(arrayPalabras) {
    let patronesABuscar = ["34","101", "ES", "HO"];
    let resultadoBusqueda = "";

    patronesABuscar.forEach( patron => {
        let encontrados = arrayPalabras.filter(p => p.includes(patron));
        if (encontrados.length > 0) {
            resultadoBusqueda += `El patrón ${patron} lo contienen ${encontrados.length} palabras \n`;
        }
    });
    alert(resultadoBusqueda);
}

function ordenarPalabras(arrayPalabras) {
    (arrayPalabras.sort()).reverse();
    alert(arrayPalabras);
}

function calcularNumPalabras(arrayPalabras) {
    let palabrasLongitudMas7 = arrayPalabras.filter(palabra => palabra.length >= 7);
    console.log(`Hay ${palabrasLongitudMas7.length} palabras con una longitud igual o mayor a 7`);
}