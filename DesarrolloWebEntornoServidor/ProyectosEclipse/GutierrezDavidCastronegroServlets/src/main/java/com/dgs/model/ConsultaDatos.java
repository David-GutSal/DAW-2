package com.dgs.model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConsultaDatos {
	public String consultaJugadores(String id) throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String linea;

		while ((linea = br.readLine()) != null) {
			if (linea.contains(id)) {
				String[] parts = linea.split("-");
				String nombre = parts[1];
				br.close();
				return nombre;
			}
		}
		br.close();
		return null;
	}

	public ArrayList<String> consultaRoles() throws IOException {
		String path = Thread.currentThread().getContextClassLoader().getResource("roles.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		try (BufferedReader br = new BufferedReader(fr)) {
			String linea;
			ArrayList<String> roles = new ArrayList<String>();
			while ((linea = br.readLine()) != null) {
				roles.add(linea);
			}
			return roles;
		}
	}
}
