// Importa la función para crear la aplicación Vue
import { createApp } from 'vue';

/*Se importa el componente principal de la aplicación, que será el parámetro que 
    luego se pase para crear el objeto Vue principal*/
import App from './App.vue';

/*Paso para enlazar el componente principal con el elemento
 html con id=app incluido en index.html.
 Este paso equivale a los ya conocidos:
    app = Vue.createApp(): Lo incluíamos en main.js
    app.mount("#app"); : Lo incluíamos en index.html
    */
createApp(App).mount('#app');