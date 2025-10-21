package com.dgs.appdto.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {
	public Integer consultaEdad(String nombre) throws IOException {
		/*
		 * Obtiene la ruta del archivo Personas.txt desde los recursos del proyecto
		 */
		String path = Thread.currentThread().getContextClassLoader().getResource("Personas.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		/*
		 * Leemos linea a linea el fichero, hasta que se acabe, que devolvera NULL
		 */
		while ((linea = br.readLine()) != null) {
			/*
			 * Comprobamos que la linea leida tiene el nombre que hemos recibimos como
			 * parametro
			 */
			if (linea.contains(nombre)) {
				br.close(); // Cierra el fichero
				/*
				 * Extraemos la edad para devolverla. Como el formato es Nombre-Edad, dividimos
				 * el string por "-"
				 */
				String[] arrayPersona = linea.split("-");
				/*
				 * arrayPersona[1] contendra la edad en formato String. Aaplicamos el parseo a
				 * num entero
				 */
				return Integer.parseInt(arrayPersona[1]);
			}
		}
		br.close();
		return null;
	}
}
