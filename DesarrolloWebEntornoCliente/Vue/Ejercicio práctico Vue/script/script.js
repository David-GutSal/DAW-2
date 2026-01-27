const { createApp, ref, computed } = Vue;

const app = createApp({
  setup() {

    let nuevaPrenda = ref({
        prenda: "",
        color: "",
        talla: "default",
        precio: 0
  })
    let prendas = ref([{
        prenda: "dawdfsef",
        color:  'rgb(245, 23, 4)',
        talla: "A",
        precio: 8
  },
{
        prenda: "vxdvx",
        color:  'rgb(54, 19, 16)',
        talla: "C",
        precio: 2
  },
{
        prenda: "kukhk",
        color:  'rgb(145, 126, 125)',
        talla: "B",
        precio: 4
  },
{
        prenda: "gdg",
        color:  'rgb(145, 126, 125)',
        talla: "B",
        precio: 4
  },
{
        prenda: "grdgfsfsef",
        color:  'rgb(145, 126, 125)',
        talla: "B",
        precio: 4
  },
{
        prenda: "grdgrdgfsef",
        color:  'rgb(145, 126, 125)',
        talla: "B",
        precio: 4
  },
{
        prenda: "grdgfseggfsef",
        color:  'rgb(145, 126, 125)',
        talla: "B",
        precio: 4
  }]);

    let vendidos = ref([]);

    let vender = (index) =>{
        prendas.splice(1,index);
        vendidos.push(index);
    }
    let guardarPrenda = () =>{
        prendas.value.push({ ...nuevaPrenda.value });
        nuevaPrenda.value = { prenda: "", color: "", talla: "default", precio: 0 };
    }
    return {
        nuevaPrenda,
        prendas,
        guardarPrenda,
        vendidos,
        vender
    };
  },
});