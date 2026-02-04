<template>
    <input type="text" v-model="nuevoProp" placeholder="Nuevo proposito">
    <button @click="agregarProp">Agregar</button>
</template>

<script setup>
import { ref } from "vue"

let hecho = ref(false);
let nuevoProp = ref("");


const emit = defineEmits(["agregarProp"]);

const agregarProp = () => {
    let proposito = { texto: nuevoProp.value, hecho: hecho }
    emit("agregarProp", proposito);
    nuevoProp.value = "";
}

</script>

<style scoped></style>