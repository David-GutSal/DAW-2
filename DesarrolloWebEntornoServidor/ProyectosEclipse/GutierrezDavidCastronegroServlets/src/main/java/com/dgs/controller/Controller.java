package com.dgs.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.dgs.business.AsignarRol;
import com.dgs.model.ConsultaDatos;
import com.dgs.model.dto.RolDTO;
import com.dgs.model.dto.UsuarioDTO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConsultaDatos datos = new ConsultaDatos();
		ArrayList<UsuarioDTO> jugadores = datos.consultaJugadores();
		req.setAttribute("opcionesDesplegable", jugadores);
		req.getRequestDispatcher("/WEB-INF/rol.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idJugador = req.getParameter("jugadorId");
		ConsultaDatos datos = new ConsultaDatos();
		String nombreJugador = datos.getNombrePorId(Integer.parseInt(idJugador));
		AsignarRol asignar = new AsignarRol();
		RolDTO rolAsignado = asignar.asignarRolAleatorio(nombreJugador);

		ArrayList<UsuarioDTO> jugadores = datos.consultaJugadores();
		req.setAttribute("opcionesDesplegable", jugadores);
		req.setAttribute("nombreJugador", nombreJugador);
		req.setAttribute("rol", rolAsignado.getRol());
		req.getRequestDispatcher("/WEB-INF/rol.jsp").forward(req, resp);
	}

}
