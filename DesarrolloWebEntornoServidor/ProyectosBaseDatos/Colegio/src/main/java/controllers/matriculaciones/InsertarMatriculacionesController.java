package controllers.matriculaciones;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DesplegableUtils;

import java.io.IOException;

/**
 * Servlet implementation class InsertarAlumnosController
 */
@WebServlet("/matriculaciones/insertarMatriculacion")
public class InsertarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertarMatriculacionesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	DesplegableUtils.recuperarDesplegableAlumnos(request);
	DesplegableUtils.recuperarDesplegableAsignaturas(request);
	RequestDispatcher d = getServletContext()
	.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/insertarMatriculacion.jsp");
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
