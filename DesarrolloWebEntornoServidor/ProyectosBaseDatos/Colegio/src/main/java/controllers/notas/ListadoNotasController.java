package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import serviciosImp.AlumnosServiceImp;
import serviciosImp.AsignaturasServiceImp;
import serviciosImp.NotasServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.AlumnoDTO;
import dto.AsignaturaDTO;
import dto.NotasDTO;
import servicios.IAlumnosService;
import servicios.IAsignaturasService;
import servicios.INotasService;

/**
 * Servlet implementation class ListadoAlumnosController
 */
@WebServlet("/notas/listadoNotas")
public class ListadoNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ListadoNotasController.class);

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		
		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String asignatura = request.getParameter("asignatura");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
		String activo = request.getParameter("activo");

		logger.info(activo);

		if (fecha == null)
			fecha = "0001-01-01";
		
		if (nota == null)
			nota = "";
		
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
		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

}
