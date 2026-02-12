<script setup>
import { ref } from 'vue';
import store from './store.js';
import Cuestionario from './components/Cuestionario.vue';

//Formulario 1
let temasDisponibles = ref(store.state.custionario.temas);
let temaCuestionario = ref(1);
const numeroPreguntas = ref(1);

let nuevoCuestionario = {
    numPreguntas: numeroPreguntas,
    texto: temaCuestionario
};

let generarCuestionario = () => {

}

//Formulario 2
const nuevoTema = ref({
    id: 0,
    nombre: ""
});

const guardarNuevoTema = () => {
    nuevoTema.value.id = (store.state.custionario.temas).length+1;
    store.commit('guardarNuevoTema', nuevoTema.value);
}

//Formulario 3
const nuevaPregunta = ref({
    id: 0,
    tema: 1,
    pregunta: "",
    correcta: "",
    _1: "",
    _2: "",
    _3: "",
    _4: ""
});

const guardarPregunta = () => {
    nuevaPregunta.value.id = (store.state.custionario.preguntas).length+1;
    store.commit('guardarPregunta', nuevaPregunta.value);
}

</script>

<template>
    <header>
        <h1>Generador de test de películas míticas</h1>
    </header>
    <main>
        <section id="formularios">
            <fieldset>
                <legend>Generar nuevo cuestionario</legend>
                <form id="nuevoTest">
                    <label for="numPreguntas">Nº de preguntas</label>
                    <input type="number" id="numPreguntas" min="1" required v-model="numeroPreguntas"><br>
                    <label for="temas"> Temas </label>
                    <select id="temas" v-model="temaCuestionario">
                        <option :value="index" v-for="(tema, index) in temasDisponibles" :key="index">{{ tema.nombre }}
                        </option>
                    </select>
                    <input type="submit" value="Generar" @click.prevent="generarCuestionario">
                </form>
            </fieldset>
            <form id="nuevoTema">
                <fieldset>
                    <legend>Nuevo tema</legend>
                    <label for="nuevoTemaText">Tema</label>
                    <input type="text" id="nuevoTemaText" required v-model="nuevoTema.nombre">
                    <input type="submit" value="Guardar" id="guardarTema" @click.prevent="guardarNuevoTema">
                </fieldset>
            </form>
            <form id="nuevaPregunta">
                <fieldset>
                    <legend>Nueva pregunta</legend>
                    <label for="tema" class="nuevaPregLabel"> Tema </label>
                    <select id="tema" class="nuevaPreg" v-model="nuevaPregunta.tema">
                        <option :value="index" v-for="(tema, index) in temasDisponibles" :key="index">{{ tema.nombre }}
                        </option>
                    </select>
                    <br>
                    <label for="pregunta" class="nuevaPregLabel">Enunciado</label>
                    <textarea id="pregunta" class="nuevaPreg" rows="10" required
                        v-model="nuevaPregunta.pregunta"></textarea>
                    <br>
                    <label for="op1" class="nuevaPregLabel">Opción 1</label>
                    <input type="text" id="op1" class="nuevaPreg" v-model="nuevaPregunta._1" required>
                    <br>
                    <label for="op2" class="nuevaPregLabel">Opción 2</label>
                    <input type="text" id="op2" class="nuevaPreg" v-model="nuevaPregunta._2" required>
                    <br>
                    <label for="op3" class="nuevaPregLabel">Opción 3</label>
                    <input type="text" id="op3" class="nuevaPreg" v-model="nuevaPregunta._3" required>
                    <br>
                    <label for="op4" class="nuevaPregLabel">Opción 4</label>
                    <input type="text" id="op4" class="nuevaPreg" v-model="nuevaPregunta._4" required>
                    <br>
                    <label for="respCorrecta">Respuesta correcta</label>
                    <input type="number" id="respCorrecta" min="1" max="4" v-model="nuevaPregunta.correcta" required>
                    <input type="submit" value="Guardar" id="guardarPreg" @click.prevent="guardarPregunta">
                </fieldset>
            </form>
        </section>
        <section id="cuestionario">
            <Cuestionario></Cuestionario>
        </section>
    </main>
</template>

<style scoped>
@import url(//db.onlinewebfonts.com/c/b51d30fb7966b76c8820e214edca3d6b?family=Back+ttf);

header {
    text-align: center;
    font-family: "Back ttf";
    font-size: xx-large;
    color: gold;
}

main {
    display: flex;
}

#formularios {
    float: left;
    width: 40%;
    border-right: 2px dashed gold;
    box-sizing: content-box;
    padding: 5px;
}

#cuestionario {
    float: right;
    width: 45%;
    margin-left: 2%;
    padding-left: 10%;
    border-left: 2px dashed gold;
    box-sizing: content-box;
}

input,
select,
textarea {
    margin: 3px;
    padding: 2px;
}

fieldset {
    margin-bottom: 15px;
    border-radius: 2em 2em;
    padding-left: 20px;
}

.nuevaPreg {
    width: 60%;
}

.nuevaPregLabel {
    display: block;
    width: 20%;
    float: left;
    font-weight: bold;
    text-align: right;
    margin-right: 5px;
}
</style>