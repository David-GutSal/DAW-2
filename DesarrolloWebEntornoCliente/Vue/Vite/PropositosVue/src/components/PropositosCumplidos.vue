<template>
    <table v-if="propositos.length > 0">
        <tr v-for="(propositos, index) in propositos" :key="index">
            <th v-if="propositos.hecho == true">{{ propositos.texto }}</th>
        </tr>
    </table>
</template>

<script setup>
import { ref } from "vue"
defineProps(["propositos"]);

</script>

<style scoped></style>