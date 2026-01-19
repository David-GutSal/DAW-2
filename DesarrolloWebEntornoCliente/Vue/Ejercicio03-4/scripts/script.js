const { createApp, ref } = Vue;

const app = Vue.createApp({
  setup() {
    const imgs = ref("img/slide1.jpg");
    let color = ref("borde-azul");
    let cambiarColor = ref(false);
    return {
        imgs,
        color,
        cambiarColor
    };
  },
});