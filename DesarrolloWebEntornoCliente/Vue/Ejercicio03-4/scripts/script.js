const { createApp, ref, computed } = Vue;

const app = Vue.createApp({
  setup() {
    let imgs = ref(["img/img-1.jpg", "img/img-2.jpg","img/img-3.jpg","img/img-4.jpg","img/img-5.jpg","img/img-6.jpg"]);
    let color = ref("borde-azul");
    let cambiarColor = ref([false, false, false, false, false, false]);
    let click = ref([0, 0, 0, 0, 0, 0]);
    let nombre = ref(["a", "b", "c", "d", "e", "f"]);

    const guardar = (event, index) => {
      const valorRecogido = event.target.value;
      nombre.value[index] = valorRecogido;
      cambiarColor.value[index] = false;
    };
    
    const cambiarBorde = computed((index) => {
      return click.value[index] == 5 ? 'nuevoBorde' : '';

    });

    return {
      imgs,
      color,
      cambiarColor,
      click,
      nombre,
      guardar,
      cambiarBorde
    };
  },
});