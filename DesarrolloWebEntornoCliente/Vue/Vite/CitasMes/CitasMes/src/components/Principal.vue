<script setup>

let fecha = new Date("2021");

</script>

<template>
    <div class="row">
            <table class="col-12 mx-5 mt-5">
                <tr>
                    <th>Lunes</th>
                    <th>Martes</th>
                    <th>Miercoles</th>
                    <th>Jueves</th>
                    <th>Viernes</th>
                    <th>Sábado</th>
                    <th>Domingo</th>
                </tr>
                <tr >
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                </tr>
            </table>
        <div class="col mx-4 mt-5 cita-texto">

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
.cita-texto{
    border: 1px solid black;
}
</style>