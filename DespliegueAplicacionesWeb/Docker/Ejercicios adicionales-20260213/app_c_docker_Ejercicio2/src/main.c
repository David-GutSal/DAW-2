#include <stdio.h>
#include "menu.h"
#include "utils.h"

int main() {
    int opcion;

    do {
        mostrarMenu();
        opcion = leerOpcion();

        switch(opcion) {
            case 1: mostrarFecha(); break;
            case 2: numeroAleatorio(); break;
            case 3: mostrarConfiguracion(); break;
            case 4: printf("\nSaliendo...\n"); break;
            default: printf("\nOpción no válida\n");
        }

    } while(opcion != 4);

    return 0;
}
