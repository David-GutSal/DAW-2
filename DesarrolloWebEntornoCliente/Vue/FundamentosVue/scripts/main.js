const { createApp, ref, reactive } = Vue;

const app = createApp({
  setup() {
    
    const mensaje = ref("¡Hola Mundo!");
    const valor = ref(0);
    const enlace = ref("https://v3.vuejs.org/guide/introduction.html#what-is-vue-js");
    const tipo = ref("1");

    return {
      mensaje,
      valor,
      enlace,
      tipo
    };
  }
});


const lista = createApp({
  setup() {

    const libros = reactive([
      { titulo: "La villa de las telas" },
      { titulo: "La isla de las tormentas" },
      { titulo: "Dime quien soy" },
    ]);

    const mostrarAlerta = () => {
      alert("Número de libros almacenados: " + libros.length);
    };

    return {
      libros,
      mostrarAlerta
    };
  }
});