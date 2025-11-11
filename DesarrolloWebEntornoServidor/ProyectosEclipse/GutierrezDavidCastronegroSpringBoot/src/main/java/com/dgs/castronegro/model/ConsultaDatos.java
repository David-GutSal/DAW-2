package com.dgs.castronegro.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.dgs.castronegro.model.dto.UsuarioDTO;

@Repository
public class ConsultaDatos implements IConsultaDatos {

    @Override
    public ArrayList<UsuarioDTO> consultaJugadores() throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
        File f = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            ArrayList<UsuarioDTO> nombres = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split("-");
                nombres.add(new UsuarioDTO(Integer.parseInt(parts[0]), parts[1]));
            }
            return nombres;
        }
    }

    @Override
    public ArrayList<String> consultaRoles() throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("roles.txt").getPath();
        File f = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            ArrayList<String> roles = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                roles.add(linea);
            }
            return roles;
        }
    }

    @Override
    public String getNombrePorId(int id) throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
        File f = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split("-");
                if (Integer.parseInt(parts[0]) == id) {
                    return parts[1];
                }
            }
            return null;
        }
    }
}
