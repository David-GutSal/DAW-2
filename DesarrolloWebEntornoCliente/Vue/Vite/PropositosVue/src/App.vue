<template>
    <div class="container-fluid">
        <h1 :class="[propositos.length > 5 ? 'verde' : 'azul']">Propósitos de año nuevo</h1>
        <div class="row">
            <div class="col">
                <MostrarPropositos :propositos="propositos" @borrar="borrarP"></MostrarPropositos>
                <NuevoProposito @agregarProp="agregarProp"></NuevoProposito>
            </div>
            <div class="col">
                <PropositosCumplidos :propositos="propositos"></PropositosCumplidos>
            </div>
        </div>
    </div>

    <button @click="borrarLista">Borrar lista</button>
</template>

<script setup>
import { reactive } from "vue"
import MostrarPropositos from "./components/MostrarPropositos.vue"
import NuevoProposito from "./components/NuevoProposito.vue"
import PropositosCumplidos from "./components/PropositosCumplidos.vue"

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
    console.log('Valor de nuevoProp.value:', proposito.texto);
    propositos.push(proposito);
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
