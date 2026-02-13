#include <stdio.h>
#include "menu.h"

void mostrarMenu() {
    printf("\n===== SISTEMA DOCKER EN C =====\n");
    printf("1. Mostrar fecha\n");
    printf("2. Generar número aleatorio\n");
    printf("3. Mostrar configuración\n");
    printf("4. Salir\n");
    printf("Seleccione una opción: ");
}

int leerOpcion() {
    int opcion;
    scanf("%d", &opcion);
    return opcion;
}
