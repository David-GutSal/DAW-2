<script setup></script>

<template>
    <h1>Propósitos de año nuevo</h1>
    <div id="app">
        <ul v-if="propositos.length > 0">
            <div class="st" v-for="(propositos, index) in propositos" :key="index" v-on:dblclick.self="borrar(index)">
                <li v-if="propositos.hecho == false" >{{propositos.texto}}</li>
                <li v-else-if="propositos.hecho == true"><del>{{propositos.texto}}</del></li>
                <input type="checkbox" v-model="propositos.hecho">
                
            </div>
        </ul>
        <p v-else>La lista de propósitos está vacía</p>

        <input type="text" v-model="nuevoProp" placeholder="Nuevo proposito">
        <button @click="agregarProp">Agregar</button>

        <button @click="borrarLista">Borrar lista</button>
    </div>
</template>

<style scoped>
  .st{
      background-color: bisque;
      display: flex;
      flex-direction: row;
      margin-bottom: 1em;
  }
</style>
