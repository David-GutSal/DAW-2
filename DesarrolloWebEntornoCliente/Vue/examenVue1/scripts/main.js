const { createApp, ref, reactive } = Vue;

const app = createApp({
  setup() {
    let textoBoton = ref ("Modificar");

    let prendaNueva = ref({
      prenda: "",
      color: "",
      talla: "",
      precio: 0,
      textoBoton: "Modificar"
    });

    let prendasDisponibles = ref([{
      prenda: "vestido",
      color: "#ffffff",
      talla: "s",
      precio: 23.5,
      textoBoton: "Modificar"
    },
  {
      prenda: "pantalón",
      color: "#ffaa33",
      talla: "xl",
      precio: 45,
      textoBoton: "Modificar"
    }]);

    let prendasVendidas = ref([]);

    let altaPrenda = () => {
      prendasDisponibles.value.push({...prendaNueva.value});
    }

    let modificar = (index) => {
      if (prendasDisponibles.value[index].textoBoton == "Guardar") 
        prendasDisponibles.value[index].textoBoton = "Modificar";
      else 
        prendasDisponibles.value[index].textoBoton = "Guardar";
    }

    let vender = (index) => {
      console.log(prendasDisponibles.value);
      let prendaVendida = prendasDisponibles.value.splice(index,1);
      prendasVendidas.value.unshift(prendaVendida[0]);
      if (prendasVendidas.value.length > 6) {
        prendasVendidas.value.pop();
      }
      console.log(prendasVendidas.value);
    }

    return {
      prendaNueva,
      prendasDisponibles,
      textoBoton,
      prendasVendidas,
      altaPrenda,
      modificar,
      vender
    };
  }
});
