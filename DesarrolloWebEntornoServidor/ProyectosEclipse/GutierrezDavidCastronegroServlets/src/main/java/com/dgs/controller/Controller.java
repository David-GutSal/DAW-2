package com.dgs.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.dgs.business.AsignarRol;
import com.dgs.model.ConsultaDatos;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConsultaDatos consultaDatos = new ConsultaDatos();
		ArrayList<UsuarioDTO> desplegable = consultaDatos.consultaJugadores();
		request.setAttribute("opcionesDesplegable", desplegable);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/rol.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AsignarRol otorgarRol = new AsignarRol();
		String rol = otorgarRol.getRol();

		request.setAttribute("rol", rol);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/rol.jsp");
		dispatcher.forward(request, response);
	}

}
