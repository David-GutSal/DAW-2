<template>
  <PiePagina :telUser="telefono" dir="C/Arriba 15" />  
  <h1>{{ mensaje }}</h1>
  <hr />

  <span>Libros disponibles:</span>
  <ListaLibros :libros="libros" />

  <hr />

  <PiePagina :telUser="telefono" dir="C/Arriba 25" />
</template>

<script>
  import { ref } from "vue"
  import PiePagina from "./components/PiePagina.vue"
  import ListaLibros from "./components/ListaLibros.vue"

  export default {
    name: "App",
    components: {
      PiePagina,
      ListaLibros
    },
    setup() {
      const mensaje = ref("Librería Mi Mundo de Papel")
      const telefono = ref(923451111)
      const libros = ref([
        { titulo: "La villa de las telas" },
        { titulo: "La isla de las tormentas" },
        { titulo: "Dime quien soy" }
      ])

      const mostrarAlerta = () => {
        alert("Número de libros almacenados: " + libros.value.length)
      }

      return {
        mensaje,
        telefono,
        libros,
        mostrarAlerta
      }
    }
  }
</script>

<style>
  h1 {
    text-align: center;
  }
</style>
