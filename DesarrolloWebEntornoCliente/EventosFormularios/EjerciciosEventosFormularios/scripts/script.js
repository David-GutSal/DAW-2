// =============================================
// EJERCICIO 1: Aviso Programado
// =============================================

let intervaloAviso = null;
const avisoBtn = document.getElementById('avisoBtn');
const pararAvisoBtn = document.getElementById('pararAvisoBtn');
const avisoStatus = document.getElementById('avisoStatus');

avisoBtn.addEventListener('click', function() {
    if (intervaloAviso) {
        clearInterval(intervaloAviso);
    }
    
    // Mostrar alert inmediatamente
    alert('Este sábado a las 3 son las 2');
    
    // Configurar intervalo para cada 5 segundos
    intervaloAviso = setInterval(function() {
        alert('Este sábado a las 3 son las 2');
    }, 5000);
    
    avisoStatus.textContent = 'Estado: Ejecutándose';
    avisoStatus.style.backgroundColor = '#d4edda';
    avisoStatus.style.color = '#155724';
});

pararAvisoBtn.addEventListener('click', function() {
    if (intervaloAviso) {
        clearInterval(intervaloAviso);
        intervaloAviso = null;
        avisoStatus.textContent = 'Estado: Detenido';
        avisoStatus.style.backgroundColor = '#f8d7da';
        avisoStatus.style.color = '#721c24';
    }
});

// =============================================
// EJERCICIO 2: Información de DNI por Letra
// =============================================

const letraInput = document.getElementById('letraInput');
const calcularDNIBtn = document.getElementById('calcularDNI');
const dniResult = document.getElementById('dniResult');

// Función para calcular la letra del DNI según el algoritmo oficial
function calcularLetraDNI(numero) {
    const letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
    return letras[numero % 23];
}

calcularDNIBtn.addEventListener('click', function() {
    const letra = letraInput.value.toUpperCase();
    
    if (!letra || !/^[A-Z]$/.test(letra)) {
        dniResult.innerHTML = '<p class="error">Por favor, introduce una letra válida (A-Z)</p>';
        return;
    }
    
    // Calcular cuántos DNIs de 4 cifras tienen esta letra
    let dnisConLetra = [];
    let contador = 0;
    
    for (let i = 1; i <= 9999; i++) {
        const numeroStr = i.toString().padStart(4, '0');
        const letraCalculada = calcularLetraDNI(parseInt(numeroStr));
        
        if (letraCalculada === letra) {
            contador++;
            dnisConLetra.push(numeroStr + letra);
        }
    }
    
    // Mostrar resultados
    let resultadoHTML = `<h3>Resultados para la letra ${letra}:</h3>`;
    resultadoHTML += `<p><strong>Total DNIs encontrados:</strong> ${contador}</p>`;
    
    // Mostrar solo los primeros 10 DNIs para no saturar la página
    if (contador > 0) {
        resultadoHTML += `<p><strong>Primeros 10 DNIs:</strong></p><ul>`;
        const primeros10 = dnisConLetra.slice(0, 10);
        primeros10.forEach(dni => {
            resultadoHTML += `<li>${dni}</li>`;
        });
        resultadoHTML += `</ul>`;
        
        if (contador > 10) {
            resultadoHTML += `<p>... y ${contador - 10} más</p>`;
        }
    }
    
    dniResult.innerHTML = resultadoHTML;
});

// =============================================
// EJERCICIO 3: Cambio de Fondo
// =============================================

const colorActual = document.getElementById('colorActual');
const colorPreview = document.getElementById('colorPreview');

// Función para generar un color hexadecimal aleatorio
function generarColorAleatorio() {
    const letras = '0123456789ABCDEF';
    let color = '#';
    
    for (let i = 0; i < 6; i++) {
        color += letras[Math.floor(Math.random() * 16)];
    }
    
    return color;
}

// Actualizar la vista previa del color
function actualizarVistaPreviaColor(color) {
    colorActual.textContent = color;
    colorPreview.style.backgroundColor = color;
}

// Inicializar con el color actual
actualizarVistaPreviaColor('#FFFFFF');

// Evento de doble click para cambiar el fondo
document.addEventListener('dblclick', function(e) {
    // No cambiar el fondo si se hace doble click en un input o botón
    if (e.target.tagName === 'INPUT' || e.target.tagName === 'BUTTON' || e.target.tagName === 'SELECT' || e.target.tagName === 'TEXTAREA') {
        return;
    }
    
    const nuevoColor = generarColorAleatorio();
    document.body.style.backgroundColor = nuevoColor;
    actualizarVistaPreviaColor(nuevoColor);
});

// =============================================
// EJERCICIO 4: Expresiones Regulares
// =============================================

// a) 10 dígitos seguidos
document.getElementById('regex1Btn').addEventListener('click', function() {
    const input = document.getElementById('regex1Input').value;
    const regex = /\d{10}/;
    const resultado = regex.test(input);
    
    document.getElementById('regex1Result').innerHTML = resultado 
        ? `<span style="color: green;">✓ Se encontraron 10 dígitos seguidos</span>` 
        : `<span style="color: red;">✗ No se encontraron 10 dígitos seguidos</span>`;
});

// b) 10 dígitos al final
document.getElementById('regex2Btn').addEventListener('click', function() {
    const input = document.getElementById('regex2Input').value;
    const regex = /\d{10}$/;
    const resultado = regex.test(input);
    
    document.getElementById('regex2Result').innerHTML = resultado 
        ? `<span style="color: green;">✓ Se encontraron 10 dígitos al final</span>` 
        : `<span style="color: red;">✗ No se encontraron 10 dígitos al final</span>`;
});

// c) Validar fecha DD-MM-AAAA o DD-MM-AA
document.getElementById('regex3Btn').addEventListener('click', function() {
    const input = document.getElementById('regex3Input').value;
    const regex = /^\d{2}-\d{2}-\d{2,4}$/;
    const resultado = regex.test(input);
    
    let mensaje = '';
    if (resultado) {
        // Verificar que los números sean válidos
        const partes = input.split('-');
        const dia = parseInt(partes[0]);
        const mes = parseInt(partes[1]);
        const anio = parseInt(partes[2]);
        
        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12) {
            mensaje = `<span style="color: green;">✓ Formato de fecha válido: ${input}</span>`;
        } else {
            mensaje = `<span style="color: orange;">⚠ Formato válido pero valores de fecha incorrectos</span>`;
        }
    } else {
        mensaje = `<span style="color: red;">✗ Formato de fecha inválido. Use DD-MM-AAAA o DD-MM-AA</span>`;
    }
    
    document.getElementById('regex3Result').innerHTML = mensaje;
});

// d) Validar email con dominio específico
document.getElementById('regex4Btn').addEventListener('click', function() {
    const input = document.getElementById('regex4Input').value;
    const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.(es|com|net|org)$/i;
    const resultado = regex.test(input);
    
    document.getElementById('regex4Result').innerHTML = resultado 
        ? `<span style="color: green;">✓ Email válido con dominio permitido</span>` 
        : `<span style="color: red;">✗ Email inválido o dominio no permitido (solo .es, .com, .net, .org)</span>`;
});

// e) Buscar palabras paca, vaca, baca, caca
document.getElementById('regex5Btn').addEventListener('click', function() {
    const texto = "Paca llevaba una vaca en la baca que se hizo caca";
    const regex = /(paca|vaca|baca|caca)/gi;
    const coincidencias = texto.match(regex);
    
    let resultadoHTML = `<p><strong>Texto:</strong> "${texto}"</p>`;
    
    if (coincidencias) {
        resultadoHTML += `<p><strong>Coincidencias encontradas (${coincidencias.length}):</strong> ${coincidencias.join(', ')}</p>`;
        resultadoHTML += `<p><strong>Array devuelto:</strong> [${coincidencias.map(c => `"${c}"`).join(', ')}]</p>`;
    } else {
        resultadoHTML += `<p><span style="color: red;">No se encontraron coincidencias</span></p>`;
    }
    
    document.getElementById('regex5Result').innerHTML = resultadoHTML;
});

// f) Validar formato DNI
document.getElementById('regex6Btn').addEventListener('click', function() {
    const input = document.getElementById('regex6Input').value.toUpperCase();
    const regex = /^\d{8}[A-Z]$/;
    const resultado = regex.test(input);
    
    document.getElementById('regex6Result').innerHTML = resultado 
        ? `<span style="color: green;">✓ Formato de DNI válido</span>` 
        : `<span style="color: red;">✗ Formato de DNI inválido. Debe ser 8 números seguidos de 1 letra</span>`;
});

// Validar letra del DNI
document.getElementById('regex6ValidarBtn').addEventListener('click', function() {
    const input = document.getElementById('regex6Input').value.toUpperCase();
    const regex = /^\d{8}[A-Z]$/;
    
    if (!regex.test(input)) {
        document.getElementById('regex6Result').innerHTML = `<span style="color: red;">✗ Formato inválido. Primero valide el formato</span>`;
        return;
    }
    
    const numero = parseInt(input.substring(0, 8));
    const letra = input.charAt(8);
    const letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
    const letraCalculada = letras[numero % 23];
    
    if (letra === letraCalculada) {
        document.getElementById('regex6Result').innerHTML = `<span style="color: green;">✓ DNI válido. Letra correcta: ${letra}</span>`;
    } else {
        document.getElementById('regex6Result').innerHTML = `<span style="color: red;">✗ DNI inválido. Letra debería ser ${letraCalculada}, no ${letra}</span>`;
    }
});

// =============================================
// EJERCICIO 5: Formulario Avanzado
// =============================================

const formularioAvanzado = document.getElementById('formularioAvanzado');
const formResult = document.getElementById('formResult');

// Datos para el select de ciudades
const ciudadesPorPais = {
    'España': [
        { valor: 'Madrid', texto: 'Madrid', capital: true },
        { valor: 'Salamanca', texto: 'Salamanca', capital: false },
        { valor: 'Zaragoza', texto: 'Zaragoza', capital: false }
    ],
    'Francia': [
        { valor: 'Paris', texto: 'París', capital: true },
        { valor: 'Burdeos', texto: 'Burdeos', capital: false },
        { valor: 'Niza', texto: 'Niza', capital: false }
    ],
    'Irlanda': [
        { valor: 'Dublin', texto: 'Dublín', capital: true },
        { valor: 'Cork', texto: 'Cork', capital: false },
        { valor: 'Kilkenny', texto: 'Kilkenny', capital: false }
    ]
};

// Actualizar ciudades según país seleccionado
document.getElementById('pais').addEventListener('change', function() {
    const pais = this.value;
    const ciudadSelect = document.getElementById('ciudad');
    
    // Limpiar opciones actuales
    ciudadSelect.innerHTML = '';
    ciudadSelect.disabled = !pais;
    
    if (pais && ciudadesPorPais[pais]) {
        // Agregar opciones
        ciudadesPorPais[pais].forEach(ciudad => {
            const option = document.createElement('option');
            option.value = ciudad.valor;
            option.textContent = ciudad.texto;
            if (ciudad.capital) {
                option.selected = true;
            }
            ciudadSelect.appendChild(option);
        });
    } else {
        const option = document.createElement('option');
        option.value = '';
        option.textContent = 'No inicializado';
        option.selected = true;
        option.disabled = true;
        ciudadSelect.appendChild(option);
    }
});

// Función para verificar si dos palabras son anagramas
function sonAnagramas(palabra1, palabra2) {
    // Normalizar: quitar espacios, convertir a minúsculas y ordenar letras
    const normalizar = (str) => 
        str.replace(/\s/g, '').toLowerCase().split('').sort().join('');
    
    return normalizar(palabra1) === normalizar(palabra2);
}

// Función para validar email con dominios específicos
function validarEmailDominio(email) {
    if (!email) return true; // Email no es obligatorio
    
    const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!regexEmail.test(email)) return false;
    
    // Dominios permitidos
    const dominiosPermitidos = ['gmail.com', 'hotmail.com', 'calasanzsalamanca.com'];
    const dominio = email.split('@')[1].toLowerCase();
    
    return dominiosPermitidos.includes(dominio);
}

// Validar formulario al enviar
formularioAvanzado.addEventListener('submit', function(e) {
    e.preventDefault();
    
    // Limpiar mensajes de error anteriores
    document.querySelectorAll('.error').forEach(el => {
        el.textContent = '';
        el.style.display = 'none';
    });
    
    // Obtener valores
    const dni = document.getElementById('dni').value.toUpperCase();
    const email = document.getElementById('email').value;
    const palabra1 = document.getElementById('palabra1').value;
    const palabra2 = document.getElementById('palabra2').value;
    const pais = document.getElementById('pais').value;
    const ciudad = document.getElementById('ciudad').value;
    
    let errores = [];
    let esValido = true;
    
    // Validar DNI
    if (!dni) {
        mostrarError('dniError', 'El DNI es obligatorio');
        errores.push('DNI obligatorio');
        esValido = false;
    } else if (!/^\d{8}[A-Z]$/.test(dni)) {
        mostrarError('dniError', 'Formato de DNI inválido: 8 números + 1 letra');
        errores.push('Formato DNI inválido');
        esValido = false;
    } else {
        // Validar letra del DNI
        const numero = parseInt(dni.substring(0, 8));
        const letra = dni.charAt(8);
        const letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
        const letraCalculada = letras[numero % 23];
        
        if (letra !== letraCalculada) {
            mostrarError('dniError', `Letra incorrecta. Debería ser ${letraCalculada}`);
            errores.push('Letra DNI incorrecta');
            esValido = false;
        }
    }
    
    // Validar email
    if (email && !validarEmailDominio(email)) {
        mostrarError('emailError', 'Email inválido o dominio no permitido (solo gmail.com, hotmail.com, calasanzsalamanca.com)');
        errores.push('Email con dominio no permitido');
        esValido = false;
    }
    
    // Validar palabras
    if (!palabra1) {
        mostrarError('palabra1Error', 'La primera palabra es obligatoria');
        errores.push('Primera palabra obligatoria');
        esValido = false;
    }
    
    if (!palabra2) {
        mostrarError('palabra2Error', 'La segunda palabra es obligatoria');
        errores.push('Segunda palabra obligatoria');
        esValido = false;
    }
    
    if (palabra1 && palabra2 && !sonAnagramas(palabra1, palabra2)) {
        mostrarError('palabra2Error', 'La segunda palabra debe ser un anagrama de la primera');
        errores.push('Las palabras no son anagramas');
        esValido = false;
    }
    
    // Validar país
    if (!pais) {
        mostrarError('paisError', 'Debe seleccionar un país');
        errores.push('País no seleccionado');
        esValido = false;
    }
    
    // Validar ciudad
    if (!ciudad) {
        mostrarError('ciudadError', 'Debe seleccionar una ciudad');
        errores.push('Ciudad no seleccionada');
        esValido = false;
    }
    
    // Mostrar resultado
    if (esValido) {
        let resultadoHTML = '<h3>Formulario enviado correctamente</h3>';
        resultadoHTML += '<ul>';
        resultadoHTML += `<li><strong>DNI:</strong> ${dni}</li>`;
        resultadoHTML += `<li><strong>Email:</strong> ${email || 'No especificado'}</li>`;
        resultadoHTML += `<li><strong>Primera palabra:</strong> ${palabra1}</li>`;
        resultadoHTML += `<li><strong>Segunda palabra:</strong> ${palabra2} (anagrama)</li>`;
        resultadoHTML += `<li><strong>País:</strong> ${pais}</li>`;
        resultadoHTML += `<li><strong>Ciudad:</strong> ${document.getElementById('ciudad').options[document.getElementById('ciudad').selectedIndex].text}</li>`;
        resultadoHTML += '</ul>';
        
        formResult.innerHTML = resultadoHTML;
        formResult.style.backgroundColor = '#d4edda';
        formResult.style.color = '#155724';
    } else {
        formResult.innerHTML = `<p style="color: #721c24;"><strong>Errores encontrados:</strong></p><ul>${errores.map(error => `<li>${error}</li>`).join('')}</ul>`;
        formResult.style.backgroundColor = '#f8d7da';
        formResult.style.color = '#721c24';
    }
    
    formResult.style.display = 'block';
});

function mostrarError(elementId, mensaje) {
    const errorElement = document.getElementById(elementId);
    errorElement.textContent = mensaje;
    errorElement.style.display = 'block';
}

// =============================================
// EJERCICIO 6: Formulario con Validación HTML5
// =============================================

const formularioHTML5 = document.getElementById('formularioHTML5');

// Resaltar campos cuando el ratón pasa sobre la etiqueta
document.querySelectorAll('#formularioHTML5 label').forEach(label => {
    const inputId = label.getAttribute('for');
    if (inputId) {
        const input = document.getElementById(inputId);
        
        if (input) {
            label.addEventListener('mouseover', function() {
                input.style.borderColor = '#007bff';
                input.style.boxShadow = '0 0 0 0.2rem rgba(0, 123, 255, 0.25)';
            });
            
            label.addEventListener('mouseout', function() {
                // Restaurar borde según validez
                if (input.validity.valid) {
                    input.style.borderColor = '#28a745';
                } else if (input.value && !input.validity.valid) {
                    // Si tiene valor pero no es válido, usar color personalizado
                    const colorFavorito = document.getElementById('color').value;
                    input.style.borderColor = colorFavorito;
                } else {
                    input.style.borderColor = '#ced4da';
                }
                input.style.boxShadow = 'none';
            });
        }
    }
});

// Actualizar estilos de validación según el color favorito
document.getElementById('color').addEventListener('change', function() {
    const colorFavorito = this.value;
    
    // Aplicar color a los campos con valor pero inválidos
    document.querySelectorAll('#formularioHTML5 input:invalid').forEach(input => {
        if (input.value) {
            input.style.borderColor = colorFavorito;
            const label = document.querySelector(`label[for="${input.id}"]`);
            if (label) {
                label.style.color = colorFavorito;
            }
        }
    });
});

// Validar formulario
formularioHTML5.addEventListener('submit', function(e) {
    // Dejamos que HTML5 haga la validación automática
    // Solo agregamos estilos personalizados
    const colorFavorito = document.getElementById('color').value;
    let esValido = true;
    
    // Aplicar estilos a campos inválidos
    document.querySelectorAll('#formularioHTML5 input').forEach(input => {
        const label = document.querySelector(`label[for="${input.id}"]`);
        
        if (!input.validity.valid) {
            esValido = false;
            
            if (!input.value && input.required) {
                // Campo obligatorio vacío
                input.style.borderColor = '#dc3545';
                if (label) label.style.color = '#dc3545';
            } else if (input.value) {
                // Campo con valor pero inválido
                input.style.borderColor = colorFavorito;
                if (label) label.style.color = colorFavorito;
            }
        } else {
            // Campo válido
            input.style.borderColor = '#28a745';
            if (label) label.style.color = '#495057';
        }
    });
    
    if (!esValido) {
        e.preventDefault();
        alert('Por favor, corrige los errores en el formulario antes de enviarlo.');
    } else {
        alert('Formulario enviado correctamente.');
        // En un caso real, aquí se enviaría el formulario al servidor
    }
});

// =============================================
// EJERCICIO 7: Formulario de Búsqueda de Alojamiento
// =============================================

const formularioAlojamiento = document.getElementById('formularioAlojamiento');
const hotelInfo = document.getElementById('hotelInfo');
const compatibilidadError = document.getElementById('compatibilidadError');
const alojamientoResult = document.getElementById('alojamientoResult');

// Mostrar mensaje cuando el ratón está sobre "Hotel"
document.getElementById('tipoAlojamiento').addEventListener('mouseover', function(e) {
    if (e.target.value === 'hotel') {
        hotelInfo.textContent = 'Tenemos hoteles con spa';
        hotelInfo.style.display = 'block';
    }
});

document.getElementById('tipoAlojamiento').addEventListener('mouseout', function() {
    hotelInfo.style.display = 'none';
});

// Controlar compatibilidad de opciones
function verificarCompatibilidad() {
    const apartamento = document.getElementById('apartamento').checked;
    const montana = document.getElementById('montana').checked;
    const meseta = document.getElementById('meseta').checked;
    
    // Reiniciar estilos
    document.getElementById('montana').parentElement.style.fontSize = '1rem';
    document.getElementById('meseta').parentElement.style.fontSize = '1rem';
    compatibilidadError.textContent = '';
    compatibilidadError.style.display = 'none';
    
    // Verificar incompatibilidad: Apartamento, Montaña y Meseta a la vez
    if (apartamento && montana && meseta) {
        document.getElementById('montana').parentElement.style.fontSize = '1.2rem';
        document.getElementById('meseta').parentElement.style.fontSize = '1.2rem';
        compatibilidadError.textContent = 'Valores no compatibles para la búsqueda';
        compatibilidadError.style.display = 'block';
        compatibilidadError.style.color = '#dc3545';
    }
}

// Escuchar cambios en checkboxes
document.querySelectorAll('input[name="caracteristicas"]').forEach(checkbox => {
    checkbox.addEventListener('change', verificarCompatibilidad);
});

// Validar formulario al enviar
formularioAlojamiento.addEventListener('submit', function(e) {
    e.preventDefault();
    
    const tipoAlojamiento = document.getElementById('tipoAlojamiento').value;
    const montana = document.getElementById('montana').checked;
    const meseta = document.getElementById('meseta').checked;
    const nucleo = document.getElementById('nucleo').checked;
    const aislado = document.getElementById('aislado').checked;
    
    let errores = [];
    let estilosErrores = [];
    
    // Validación 1: No pueden estar seleccionados a la vez Montaña y Meseta
    if (montana && meseta) {
        errores.push('No pueden seleccionarse Montaña y Meseta a la vez');
        estilosErrores.push(`
            #montana, #meseta {
                border: 2px solid #dc3545 !important;
                background-color: #f8d7da;
            }
            label[for="montana"], label[for="meseta"] {
                color: #dc3545;
                font-weight: bold;
            }
        `);
    }
    
    // Validación 2: No puede seleccionarse a la vez Apartamento y Aislado
    if (tipoAlojamiento === 'apartamento' && aislado) {
        errores.push('No puede seleccionarse Apartamento y Aislado a la vez');
        estilosErrores.push(`
            #apartamento, #aislado {
                border: 2px solid #ffc107 !important;
                background-color: #fff3cd;
            }
            label[for="aislado"] {
                color: #ffc107;
                font-weight: bold;
            }
            #tipoAlojamiento {
                border-color: #ffc107 !important;
            }
        `);
    }
    
    // Validación 3: Si se selecciona Casa Rural u Hotel Rural, obligatorio núcleo poblacional
    if ((tipoAlojamiento === 'casa_rural' || tipoAlojamiento === 'hotel_rural') && !nucleo) {
        errores.push('Para Casa Rural u Hotel Rural debe seleccionarse "En núcleo poblacional"');
        estilosErrores.push(`
            #nucleo {
                border: 2px solid #17a2b8 !important;
                background-color: #d1ecf1;
            }
            label[for="nucleo"] {
                color: #17a2b8;
                font-weight: bold;
            }
        `);
    }
    
    // Aplicar estilos de error
    const styleElement = document.createElement('style');
    styleElement.textContent = estilosErrores.join('\n');
    document.head.appendChild(styleElement);
    
    // Mostrar resultado
    if (errores.length > 0) {
        let mensajeErrores = 'Errores encontrados:\n\n';
        errores.forEach((error, index) => {
            mensajeErrores += `${index + 1}. ${error}\n`;
        });
        
        alert(mensajeErrores);
        
        alojamientoResult.innerHTML = `
            <h3>Errores de validación:</h3>
            <ul style="color: #721c24;">
                ${errores.map(error => `<li>${error}</li>`).join('')}
            </ul>
        `;
        alojamientoResult.style.backgroundColor = '#f8d7da';
        alojamientoResult.style.color = '#721c24';
        
        // Remover estilos después de 5 segundos
        setTimeout(() => {
            document.head.removeChild(styleElement);
        }, 5000);
    } else {
        // Formulario válido
        const provincia = document.getElementById('provincia').value || 'No especificada';
        const tipo = document.getElementById('tipoAlojamiento').options[document.getElementById('tipoAlojamiento').selectedIndex].text;
        
        let caracteristicas = [];
        if (montana) caracteristicas.push('Montaña');
        if (meseta) caracteristicas.push('Meseta');
        if (nucleo) caracteristicas.push('En núcleo poblacional');
        if (aislado) caracteristicas.push('Aislado');
        
        alojamientoResult.innerHTML = `
            <h3>Búsqueda realizada correctamente:</h3>
            <ul>
                <li><strong>Provincia:</strong> ${provincia}</li>
                <li><strong>Tipo de alojamiento:</strong> ${tipo}</li>
                <li><strong>Características:</strong> ${caracteristicas.length > 0 ? caracteristicas.join(', ') : 'Ninguna'}</li>
            </ul>
            <p>Formulario enviado correctamente.</p>
        `;
        alojamientoResult.style.backgroundColor = '#d4edda';
        alojamientoResult.style.color = '#155724';
        
        // En un caso real, aquí se enviaría el formulario al servidor
        // formularioAlojamiento.submit();
    }
});

// Inicializar vista previa de color
window.addEventListener('load', function() {
    actualizarVistaPreviaColor('#FFFFFF');
});