const { createApp, ref, reactive } = Vue;

const app = createApp({
  setup() {
    let estilosBorde = ref([true,true,true,true,true,true]);
    let nombreTemporal = ref(["","","","","",""]);

    let datosImagenes = ref([
      {
        url: "./img/coliseo.webp",
        nombre: "Coliseo1",
        contador: 0
      },
      {
        url: "./img/coliseo2.webp",
        nombre: "Coliseo2",
        contador: 0
      },
      {
        url: "./img/coliseo3.webp",
        nombre: "Coliseo3",
        contador: 0
      },
      {
        url: "./img/temploApolo.webp",
        nombre: "TemploApolo",
        contador: 0
      },
      {
        url: "./img/temploApolo2.webp",
        nombre: "TemploApolo2",
        contador: 0
      },
      {
        url: "./img/temploApolo3.webp",
        nombre: "TemploApolo3",
        contador: 0
      }
    ]); 


    let cambiarEstiloBorde = index => estilosBorde.value[index] = !estilosBorde.value[index];
  

    let aumentarContador = (index) =>{
      datosImagenes.value[index].contador++;
    };

    let actualizarNombre = (index) => {
      datosImagenes.value[index].nombre = nombreTemporal.value[index];
      nombreTemporal.value[index] = "";
    }

    return {
      datosImagenes,
      estilosBorde,
      cambiarEstiloBorde,
      aumentarContador,
      nombreTemporal,
      actualizarNombre
    };
  }
});
