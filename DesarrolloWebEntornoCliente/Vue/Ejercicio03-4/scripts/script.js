const { createApp, ref } = Vue;

const app = Vue.createApp({
  setup() {
    const imgs = ref("img/slide1.jpg");
    let color = ref("borde-azul");
    let cambiarColor = ref([false, false, false, false, false, false]);
    let click = ref([0, 0, 0, 0, 0, 0]);
    let nombre = ref(["a", "b", "c", "d", "e", "f"]);

    let guardar = () =>{

    }

    return {
      imgs,
      color,
      cambiarColor,
      click,
      nombre,
      guardar
    };
  },
});