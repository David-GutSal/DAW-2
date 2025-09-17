function intro() {
    let num = prompt("Escribe un numero: ");
    if (num < 0) {
        alert("Es negativo");
    } else if (num > 0) {
        alert("Es positivo");
    } else {
        alert("Nulo");
    }

}

function convert() {
    let num1 = document.getElementsByTagName("input")[0];
    let num2 = document.getElementsByTagName("input")[1];
    let num1content = num1.value;
    num2.value = (num1content * 1.18);
}

function numPrimos() {
    let num = prompt("Numero menor que 100");
    if (num > 100) {
        alert("Nose");
    } else {
        let list = [];
        for (let i = 0; i < num; i++) {
            if (i % 2 == 0) {
                list.push(i);
            }
        }
        alert("Numeros primos: " + list);
    }
}