<template>
    <ul v-if="propositos.length > 0">
        <div class="st" v-for="(propositos, index) in propositos" :key="index" v-on:dblclick.self="borrar(index)">
            <li v-if="propositos.hecho == false">{{ propositos.texto }}</li>
            <li v-else-if="propositos.hecho == true"><del>{{ propositos.texto }}</del></li>
            <input type="checkbox" v-model="propositos.hecho">
        </div>
    </ul>
    <p v-else>La lista de propósitos está vacía</p>
</template>

<script setup>


defineProps(["propositos"]);

</script>

<style scoped>
.st {
    background-color: bisque;
    display: flex;
    flex-direction: row;
    margin-bottom: 1em;
}
</style>