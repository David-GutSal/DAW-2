<script setup>
import { ref, computed } from 'vue';
import store from '../../store/store';

let textos = ref(store.state.cita.texto);
const weekDays = ['Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab', 'Dom'];
const year = 2021;
const month = 1;

const calendarWeeks = computed(() => {

    const weeks = [];
    const firstDayOfMonth = new Date(year, month, 1).getDay();
    const startingDay = firstDayOfMonth === 0 ? 7 : firstDayOfMonth;
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    let currentWeek = [];

    for (let i = 1; i < startingDay; i++) {
        currentWeek.push(null);
    }

    for (let day = 1; day <= daysInMonth; day++) {
        currentWeek.push(day);
        if (currentWeek.length === 7) {
            weeks.push(currentWeek);
            currentWeek = [];
        }
    }

    if (currentWeek.length > 0) {
        while (currentWeek.length < 7) {
            currentWeek.push(null);
        }
        weeks.push(currentWeek);
    }
    return weeks;
});

</script>

<template>
    <div class="row">
        <h2>Febrero 2021</h2>
        <table class="col-12 mt-5 mx-4">
            <thead>
                <tr>
                    <th v-for="day in weekDays" :key="day">{{ day }}</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(week, index) in calendarWeeks" :key="index">
                    <td v-for="(day, dayIndex) in week" :key="dayIndex">
                        {{ day }}
                    </td>
                </tr>
            </tbody>
        </table>

        <div class="col mx-4 mt-5 cita-texto">
            <ul>
                <li v-for="texto in textos" :key="index">{{ textos.value[index] }}</li>
            </ul>
        </div>

    </div>
</template>

<style scoped>
table {
    width: 60%;
    border: 1px solid black;
}

tr {
    text-align: center;
    border: 1px solid black;
}

td {
    text-align: center;
    border: 1px solid black;
}

.cita-texto {
    border: 1px solid rgb(255, 26, 26);
}

.libre {
    font-size: 10px;
    color: black;
}

.cita {
    font-size: 20px;
    color: red;
}
</style>