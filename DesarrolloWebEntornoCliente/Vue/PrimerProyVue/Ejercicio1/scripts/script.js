const { createApp, ref, reactive } = Vue;

const appObj1 = createApp({
  setup() {

    let valor = ref("default");
    return {
        valor
    };
  }
});

const appObj2 = createApp({
  setup() {

    const personas = reactive([
      { nombre: "A", apellido: "B", dni: "1" },
      { nombre: "C", apellido: "D", dni: "2" },
      { nombre: "E", apellido: "F", dni: "3" },
    ]);
    
    return {
        personas
    };
  }
});