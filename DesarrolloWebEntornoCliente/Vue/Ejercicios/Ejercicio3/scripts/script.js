const { createApp, ref, reactive } = Vue;

const appObj = createApp({
    setup() {

        let hecho = ref(false);
        let nuevoProp = ref("");
        const propositos = reactive([
            { texto: "Hacer deporte", hecho: false },
            { texto: "Comer más sano", hecho: false },
            { texto: "Viajar más", hecho: true }
        ]);

        const borrar = (index) => {
            propositos.splice(index, 1);
        }
        const agregarProp = () => {
            let proposito = {texto: nuevoProp.value , hecho: false}
            propositos.push(proposito);
            nuevoProp.value = "";
        }
        const borrarLista = () => {
            propositos.length = 0;
        }
        
        return {
            nuevoProp,
            propositos,
            hecho,
            borrar,
            agregarProp,
            borrarLista
        };
    }
});