<template>
  <ol v-if="libros.length > 0">
    <li v-for="(libro, index) in libros" :key="index">
      {{ libro.titulo }}
    </li>
  </ol>
  <hr />
</template>

<script setup>
  // Definición de props usando Composition API
  defineProps({
    libros: {
      type: Array,
      required: true
    }
})
</script>

<!-- <script>
export default {
  name: "ListaLibros",
  props: {
    libros: {
      type: Array,
      required: true
    }
  }
}
</script>
 -->