<script setup>
import { ref } from 'vue';
import store from '../../store/store';

const cita = ref({
    fecha: 1,
    texto: ""
});


const guardarCita = () => {
    store.commit('guardarCita', cita.value);
}

</script>

<template>
    <form class="mt-5 mx-4 w-50">
        <h3 class="d-flex justify-content-center">Guardar cita</h3>
        <label for="dia">Dia: </label>
        <select name="dia" id="dia" v-model="cita.fecha">
            <option v-for="n in 28" :value="n">{{ n }}</option>
        </select>
        <div class="row mt-2">
            <label for="texto" class="w-25">Nota: </label>
            <input type="text" name="texto" id="texto" maxlength="75" class="w-50" v-model="cita.texto">
        </div>
        <div class="w-25 mb-2">
            <input type="submit" value="Almacenar Cita" @click.prevent="guardarCita">
        </div>
    </form>
</template>

<style scoped>
form {
    border: 1px solid black;
}
</style>