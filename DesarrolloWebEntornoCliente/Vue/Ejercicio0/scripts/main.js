const { createApp, ref } = Vue;

const app = Vue.createApp({
  setup() {
    let nombre = ref("Luke");
    let apellidos = ref("Skywalker");
    let edad = ref(20);
    
    let numeroAleatorio = Math.random();
    

    let imagen = ref("https://static.wixstatic.com/media/c422f6_bc774b70c09140d1843378ee4290b273~mv2.png/v1/fit/w_2500,h_1330,al_c/c422f6_bc774b70c09140d1843378ee4290b273~mv2.png");
    let textoImagen = ref("Foto de Luke Skywalker");
    let estilos = ref(false);
    let enlaces = ref([
      "https://www.starwars.com/",
      "https://starwars.fandom.com/es/wiki/Databank_(sitio_web)",
      "https://www.lafosadelrancor.com/",
    ]);

    return {
      nombre,
      apellidos,
      edad,
      imagen,
      textoImagen,
      estilos,
      enlaces,
      numeroAleatorio
    };
  },
});
