package com.dgs.appdto.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dgs.appdto.biz.Descuento;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * De esta forma recuperamos el nombre del formulario y lo añadimos a una
		 * variable de tipo String
		 */
		String nombre = request.getParameter("nombre");
		/* Instaciamos la clase de negocio Descuento */
		Descuento d = new Descuento();
		/* Llamamos al metodo que calculo el descuento */
		int descuento = d.calculaDescuento(nombre);
		/* Setamos el atributo que le llegara a la vista */
		request.setAttribute("descuento", descuento);
		request.setAttribute("nombre", nombre);
		/*
		 * Indicamos cual tiene que ser la vista a mostrar mediante el objeto
		 * RequestDispatcer
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/descuento.jsp");
		dispatcher.forward(request, response);
	}

}
