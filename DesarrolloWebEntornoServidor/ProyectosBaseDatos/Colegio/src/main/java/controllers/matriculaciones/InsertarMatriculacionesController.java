package controllers.matriculaciones;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IMatriculacionesService;
import serviciosImp.MatriculacionesServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet implementation class InsertarAlumnosController
 */
@WebServlet("/matriculaciones/insertarMatriculacion")
public class InsertarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertarMatriculacionesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/insertarMatriculacion.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idAlumno = request.getParameter("alumno");
		String idAsignatura = request.getParameter("asignatura");
		String tasa = request.getParameter("tasa");
		String fecha = request.getParameter("fecha");
		
		if (fecha == null || fecha.trim().isEmpty()) {
			fecha = LocalDate.now().toString();
		}

		IMatriculacionesService service = new MatriculacionesServiceImp();
		Integer resultado = service.insertarMatriculacion(idAsignatura, idAlumno, fecha, tasa);
		request.setAttribute("resultado", resultado);
		
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/insertarMatriculacion.jsp");
		d.forward(request, response);
	}

}
