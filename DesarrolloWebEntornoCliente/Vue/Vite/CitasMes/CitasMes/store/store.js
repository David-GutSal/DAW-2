import { createStore } from 'vuex';

export default createStore({
  state: {
    cita: [{
      fecha: 1,
      texto: ["Hola Mundo", "Otra Nota"]
    }]
  },
  mutations: {
    guardarCita(state, nuevacita) {
      state.cita.forEach((citaGuardada) => {
        if (citaGuardada.fecha == nuevacita.fecha) {
          citaGuardada.texto.push(nuevacita.texto);
        } else {
          state.cita.push(nuevacita);
        }
      });
      console.log(state.cita);
    }
  },
  actions: {
    accionGuardar({ commit }) {
      commit('guardarCita')
    }
  }
});
