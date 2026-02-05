
document.addEventListener('DOMContentLoaded', function() {
    const boton = document.getElementById('btn-menu');
    const fondoEnlace = document.getElementById('fondo-enlace');
    const barraLateral = document.getElementById('barra-lateral-izquierda');

    if (boton) {
        boton.addEventListener('click', function(e) {
            e.preventDefault();
            fondoEnlace.classList.toggle('active');
            barraLateral.classList.toggle('active');
        });
    }

    if (fondoEnlace) {
        fondoEnlace.addEventListener('click', function(e) {
            e.preventDefault();
            fondoEnlace.classList.toggle('active');
            barraLateral.classList.toggle('active');
        });
    }
});