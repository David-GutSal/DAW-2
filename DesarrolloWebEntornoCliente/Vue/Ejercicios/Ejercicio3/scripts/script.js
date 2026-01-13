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

        let borrar = () => {
            alert("jj");
        }
        
        return {
            nuevoProp,
            propositos,
            hecho,
            borrar
        };
    }
});