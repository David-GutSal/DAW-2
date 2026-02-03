<template>
    <input type="text" v-model="nuevoProp" placeholder="Nuevo proposito">
    <button @click="agregarProp">Agregar</button>
</template>

<script setup>
import { ref } from "vue"
const propos = defineProps(["propositos"]);

let hecho = ref(false);
let nuevoProp = ref("");
const agregarProp = () => {
    let proposito = { texto: nuevoProp.value, hecho: false }
    propos.propositos.push(proposito);
    nuevoProp.value = "";
}

</script>

<style scoped></style>