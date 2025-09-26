    let array = [];
    let exit = true;

    function name() {

        let add = true;
        let numero = 0;
        let nombre = "";


        numero = Number.prompt("Numero");
        nombre = prompt("Nombre");
        add = confirm("Añadir?");

        if (numero == Number) {
            if (add) {
                if (numero < 0) {
                    array.push(nombre);
                } else {
                    array[numero] = nombre;
                }
            } else {
                if (numero < 0) {
                    array.shift();
                } else {
                    array[numero] = "";
                }
            }
        } else {
            exit = false;
        }
    }
    while (exit);
    console.log(array);