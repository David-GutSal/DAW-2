package com.fcartas.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fcartas.model.entities.CartaDto;


public class ConsultaDatos {
	public CartaDto consultaCartas(String nombre) throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("cartas.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		
		while ((linea = br.readLine()) != null) {
			if(linea.contains(nombre)) {
				String[] parts = linea.split("-");
				CartaDto carta = new CartaDto(Integer.parseInt( parts[1]), Integer.parseInt( parts[2]), Integer.parseInt( parts[3]));
				br.close();
				return carta;
			}
		}
		br.close();
		return null;
	}
}
