package com.dgs.castronegro.controlador;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.castronegro.business.AsignarRol;
import com.dgs.castronegro.model.IConsultaDatos;
import com.dgs.castronegro.model.dto.RolDTO;
import com.dgs.castronegro.model.dto.UsuarioDTO;

@Controller
public class Controlador {

    @Autowired
    private AsignarRol asignarRol;

    @Autowired
    private IConsultaDatos datos;

    @GetMapping("/rol")
    public String mostrarPersonas(Model model) throws IOException {
        ArrayList<UsuarioDTO> jugadores = datos.consultaJugadores();
        model.addAttribute("nombresDesplegable", jugadores);
        return "rol";
    }

    @PostMapping("/asignarRol")
    public String asignarRol(@RequestParam("jugadorId") int idJugador, Model model) throws IOException {
        String nombreJugador = datos.getNombrePorId(idJugador);
        RolDTO rolAsignado = asignarRol.asignarRolAleatorio(nombreJugador);

        ArrayList<UsuarioDTO> jugadores = datos.consultaJugadores();
        model.addAttribute("nombresDesplegable", jugadores);
        model.addAttribute("rol", rolAsignado.getRol());
        model.addAttribute("nombre", nombreJugador);
        return "rol";
    }
}
