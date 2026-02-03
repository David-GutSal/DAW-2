<script setup>
import { reactive } from "vue"
import MostrarPropositos from "./components/MostrarPropositos.vue"
import NuevoProposito from "./components/NuevoProposito.vue"

let propositos = reactive([
    { texto: "Hacer deporte", hecho: false },
    { texto: "Comer más sano", hecho: false },
    { texto: "Viajar más", hecho: true }
]);
const borrar = (index) => {
    propositos.splice(index, 1);
}
const borrarLista = () => {
    propositos.length = 0;
}
</script>

<template>
    <h1>Propósitos de año nuevo</h1>
    <MostrarPropositos :propositos="propositos"></MostrarPropositos>
    <NuevoProposito :propositos="propositos"></NuevoProposito>

    <button @click="borrarLista">Borrar lista</button>
</template>

<style scoped></style>
