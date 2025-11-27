package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import serviciosImp.NotasServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;
import java.util.ArrayList;

import dto.NotasDTO;
import servicios.INotasService;

/**
 * Servlet implementation class ListadoAlumnosController
 */
@WebServlet("/notas/listadoNotas")
public class ListadoNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoNotasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("alumnos");
		String asignatura = request.getParameter("asignaturas");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
		String activo = request.getParameter("activo");

		if (fecha == null || fecha == "")
			fecha = "0001-01-01";
		
		if (nota == null)
			nota = "";
		
		if (nombre == null)
			nombre = "";
		
		if (asignatura == null)
			asignatura = "";

		if (activo != null)
		    activo = "1";
		else
		    activo = "0";

		INotasService n = new NotasServiceImp();
		
		ArrayList<NotasDTO> listaNotas = new ArrayList<>();
		
		listaNotas = n.obtenerNotasFiltradas(id, nombre, asignatura, nota, fecha, activo);
		
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		
		request.setAttribute("lista", listaNotas);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

}
