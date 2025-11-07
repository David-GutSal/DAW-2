function comenzarAccion(accion) {
    let textoBusqueda = (document.getElementById("textArea").value).toUpperCase();
    let arrayPalabras = textoBusqueda.split(" ");
    
    switch (accion) {
        case "modificar":
            modificarTexto(arrayPalabras);
            break;
        case "palabras":
            ordenarPalabras(arrayPalabras);
            break;
        case "ocurrencias":
            calcularOcurrencias(arrayPalabras);
            break;
        default:
            break;
    }
}

function modificarTexto(arrayPalabras) {
   
    let nuevoArray = arrayPalabras.map(palabra => palabra+"ria");
    
    console.log(nuevoArray);
    alert(nuevoArray.slice(-10));
}

function ordenarPalabras(arrayPalabras) {
    (arrayPalabras.sort((palabra1, palabra2) => {
        if (palabra1.length < 2)
            return -1;
        if (palabra2.length < 2)
                return 1;
        if (palabra1[1] > palabra2[1]) {
            return 1;
        }
        if (palabra1[1] < palabra2[1]) {
            return -1;
        } 
        return 0;
    }));

    let concatenacionPrimerasLetras = arrayPalabras.reduce((valorAnt, valorAct) => valorAnt+ valorAct[0], "*");
    console.log(concatenacionPrimerasLetras);

    let resultado = arrayPalabras.join("_");
    alert(resultado);
}

function calcularOcurrencias(arrayPalabras) {
    let algunaEmpiezaPorX = arrayPalabras.some(palabra => palabra[0] == "X");
    if (algunaEmpiezaPorX) {
        console.log("Si hay alguna palabra que empieza por X");
    }
    let todasMayoresQue5 = arrayPalabras.every(palabra => palabra.length > 5);
    if (todasMayoresQue5) {
        console.log("Todas las palabras tienen una longitud superior a 5");
    }
}