<template>
    <h1 :class="[propositos.length > 5 ? 'verde' : 'azul']">Propósitos de año nuevo</h1>
    <MostrarPropositos :propositos="propositos" @borrar="borrarP"></MostrarPropositos>
    <NuevoProposito @agregarProp="agregarProp"></NuevoProposito>

    <button @click="borrarLista">Borrar lista</button>
</template>

<script setup>
import { reactive } from "vue"
import MostrarPropositos from "./components/MostrarPropositos.vue"
import NuevoProposito from "./components/NuevoProposito.vue"

let propositos = reactive([
    { texto: "Hacer deporte", hecho: false },
    { texto: "Comer más sano", hecho: false },
    { texto: "Viajar más", hecho: true }
]);
const borrarP = (index) => {
    propositos.splice(index, 1);
}
const borrarLista = () => {
    propositos.length = 0;
}

const agregarProp = (proposito) => {
    let xd = { ...proposito };
    propositos.push(xd);
}

</script>

<style scoped>
.verde {
    background-color: green;
}

.azul {
    background-color: blue;
}
</style>
