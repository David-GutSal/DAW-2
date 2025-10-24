package com.dgs.model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ConsultaDatos implements IConsultaDatos {
	@Override
	public ArrayList<String> consultaCartas(String nombre) throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("usuarios.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		ArrayList<String> cartas = new ArrayList<String>();
		while ((linea = br.readLine()) != null) {
			if(linea.contains(nombre)) {
				cartas.add(linea);
			}
		}
		br.close();
		return cartas;
	}
}
