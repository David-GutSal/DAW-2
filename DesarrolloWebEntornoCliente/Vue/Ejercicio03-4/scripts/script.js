const { createApp, ref } = Vue;

const app = Vue.createApp({
  setup() {
    let imgs = ref(["img/img-1.jpg", "img/img-2.jpg","img/img-3.jpg","img/img-4.jpg","img/img-5.jpg","img/img-6.jpg"]);
    let color = ref("borde-azul");
    let cambiarColor = ref([false, false, false, false, false, false]);
    let click = ref([0, 0, 0, 0, 0, 0]);
    let nombre = ref(["a", "b", "c", "d", "e", "f"]);

    let guardar = (event, index)=> {
      const valorRecogido = event.target.value;
      nombre[index] = valorRecogido;
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