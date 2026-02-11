import { createStore } from 'vuex';

export default createStore({
    state: {
        custionario: {
            temas: [
                {
                    id: 1,
                    nombre: "Star Wars"
                },
                {
                    id: 2,
                    nombre: "Regreso al futuro"
                },
                {
                    id: 3,
                    nombre: "El señor de los anillos"
                }
            ],
            preguntas: [
                {
                    id: 1,
                    tema: 1,
                    pregunta: "¿En qué año se estrenó la primera película de la saga?",
                    correcta: "3",
                    _1: "1965",
                    _2: "1968",
                    _3: "1977",
                    _4: "1979"
                },
                {
                    id: 2,
                    tema: 1,
                    pregunta: "¿Cuál es la frase más famosa del personaje de Darth Vader?",
                    correcta: "4",
                    _1: "Me ha fallado por última vez, almirante",
                    _2: "Su falta de fe me resulta perturbadora",
                    _3: "Ese nombre ya no significa nada para mí",
                    _4: "No, yo soy tu padre"
                },
                {
                    id: 3,
                    tema: 1,
                    pregunta: "¿Cómo se llama la primera jedi protagonista?",
                    correcta: "2",
                    _1: "Elaine",
                    _2: "Rey",
                    _3: "Hodor",
                    _4: "Leia"
                },
                {
                    id: 4,
                    tema: 3,
                    pregunta: "¿Cuál es la criatura que lleva más tiempo viviendo en la Tierra Media?",
                    correcta: "3",
                    _1: "Gandalf",
                    _2: "El Balrog",
                    _3: "Tom Bombadil",
                    _4: "Sauron"
                },
                {
                    id: 5,
                    tema: 3,
                    pregunta: "En la película, ¿quién pronunció en el Concilio de Elrond la siguiente frase: “os hace falta gente inteligente para este tipo de... misión... cometido... cosa”?",
                    correcta: "2",
                    _1: "Merry",
                    _2: "Pippin",
                    _3: "Sam",
                    _4: "Gimpli"
                },
                {
                    id: 6,
                    tema: 3,
                    pregunta: "¿Dónde está Gandalf cuando el Nazgûl persigue a los Hobbits en la frontera de la comarca?",
                    correcta: "1",
                    _1: "En la Torre de Orthanc",
                    _2: "En Rivendel",
                    _3: "En las Colinas del Viento",
                    _4: "En Bree"
                },
                {
                    id: 7,
                    tema: 2,
                    pregunta: "¿Qué modelo es el auto donde Marty y Doc viajan en el tiempo?",
                    correcta: "2",
                    _1: "Mustang",
                    _2: "Delorean",
                    _3: "Honda",
                    _4: "Tesla"
                },
                {
                    id: 8,
                    tema: 2,
                    pregunta: "¿A qué fecha retrocede Marty accidentalmente?",
                    correcta: "2",
                    _1: "12 de noviembre de 1975",
                    _2: "5 de noviembre de 1955",
                    _3: "25 de noviembre de 1965",
                    _4: "5 de diciembre de 1955"
                },
                {
                    id: 9,
                    tema: 2,
                    pregunta: "Cuando Marty viaja al pasado y se encuentra con su madre de joven, ¿cómo le dice que se llama?",
                    correcta: "3",
                    _1: "David",
                    _2: "Bob",
                    _3: "Calvin",
                    _4: "Clint"
                },
                {
                    id: 10,
                    tema: 2,
                    pregunta: "¿Qué canción tocaba McFly en el baile de instituto de la película?",
                    correcta: "4",
                    _1: "Suspicius mind – Elvis Presley",
                    _2: "Hey Jude - The Beatles",
                    _3: "Sitting on the dock of the bay Otis Redding",
                    _4: "Chuck Berry – Johnny B. Goode"
                }
            ]
        }
    },
    mutations: {
        guardarNuevoTema(state, nuevoTema) {
            state.custionario.temas.push(nuevoTema);
            console.log(state.custionario.temas);
        },
        guardarPregunta(state, nuevaPregunta) {
            state.custionario.preguntas.push(nuevaPregunta);
        }
    },
    actions: {

    }
});
