<template>
  <div :class="footerEstilos">
    <h3>Sitio Web de Sonia Gutiérrez</h3>
    <h4>{{ mensaje }} - {{ telUser }}</h4>
    <h5>{{ dir }}</h5>
  </div>
</template>

<script setup>
  import { ref } from "vue";

  // Props recibidas desde el componente padre
  defineProps({
    telUser: {
      type: Number,
      required: true
    },
    dir: {
      type: String,
      required: true
    }
  })
  const footerEstilos = ref("footer")
  // Estado interno del componente
  const mensaje = ref("Librería especializada")
</script>

<style>
  h2,h3,h4,h5 {
    text-align: center;
  }

  .footer {
    background-color: aquamarine;
    width: 100%;
}
</style>
