#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "utils.h"

void mostrarFecha() {
    time_t t = time(NULL);
    struct tm tm = *localtime(&t);
    printf("\nFecha actual: %02d/%02d/%04d %02d:%02d:%02d\n",
           tm.tm_mday, tm.tm_mon + 1, tm.tm_year + 1900,
           tm.tm_hour, tm.tm_min, tm.tm_sec);
}

void numeroAleatorio() {
    srand(time(NULL));
    printf("\nNúmero aleatorio: %d\n", rand() % 100);
}

void mostrarConfiguracion() {
    FILE *file = fopen("config/app.conf", "r");

    if (file == NULL) {
        printf("\nNo se pudo abrir el archivo de configuración.\n");
        return;
    }

    char linea[256];
    printf("\nContenido del archivo de configuración:\n");

    while (fgets(linea, sizeof(linea), file)) {
        printf("%s", linea);
    }

    fclose(file);
}
