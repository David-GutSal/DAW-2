package controllers.asignaturas;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IAsignaturasDAO;
import daoImp.AsignaturasDAOImpl;
import dto.AsignaturaDTO;

/**
 * Servlet implementation class pruebaConexion
 */
@WebServlet("/asignaturas/obtenertodasasignaturas")
public class ControladorAsignaturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ControladorAsignaturas.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAsignaturas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAsignaturasDAO asignaturasDao = new AsignaturasDAOImpl();
		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturasDao.obtenerTodosAsignaturas();
		request.setAttribute("listaAsignaturas", listaAsignaturas);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/listadoAsignaturas.jsp");
		d.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
