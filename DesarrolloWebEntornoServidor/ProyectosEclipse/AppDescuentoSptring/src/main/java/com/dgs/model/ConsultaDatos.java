package com.dgs.model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class ConsultaDatos implements IConsultaDatos {
	@Override
	public Integer consultaEdad(String nombre) throws IOException {
		/*
		 * La clase ResourceUtils es una clase de Spring que tendréis que importar y
		 * sirve para recuperar archivos situados en local.
		 */
		File f = ResourceUtils.getFile("classpath:Personas.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		while ((linea = br.readLine()) != null) {
			if (linea.contains(nombre)) {
				br.close(); // Cierra el fichero
				String[] arrayPersona = linea.split("-");
				return Integer.parseInt(arrayPersona[1]);
			}
		}
		br.close();
		return null;
	}
}
