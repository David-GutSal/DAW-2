package com.dgs.model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.dgs.model.dto.UsuarioDTO;

public class ConsultaDatos {
	public ArrayList<UsuarioDTO> consultaJugadores() throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		try (BufferedReader br = new BufferedReader(fr)) {
			String linea;
			
			ArrayList<UsuarioDTO> nombres = new ArrayList<UsuarioDTO>();
			while ((linea = br.readLine()) != null) {
				String[] parts = linea.split("-");
				UsuarioDTO usuario = new UsuarioDTO(Integer.parseInt(parts[0]), parts[1]);
				nombres.add(usuario);
			}
			return nombres;
		}
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
