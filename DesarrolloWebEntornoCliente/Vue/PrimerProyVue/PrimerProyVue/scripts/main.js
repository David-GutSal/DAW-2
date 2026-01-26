/**
 * Declaración de un objeto tipo Vue.
 * Este objeto se relaciona con un elemento HTML. Esto se hace en la directiva incluida 
 * en el documento index.html: const mountedApp = appObj.mount("#app");
 */
const { createApp, ref } = Vue; // Importamos lo necesario desde la CDN

const appObj = createApp({
  setup() {
    // Declaramos las propiedades reactivas usando ref()
    const mensaje = ref('¿Esto es VUE?');
    const valor = ref(0);

    // Las variables y funciones que devolvemos estarán disponibles en el template
    return {
      mensaje,
      valor
    };
  }
});