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
		String idasignatura = request.getParameter("asignatura");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
		String activo = request.getParameter("activo");

		logger.info(activo);

		if (fecha == null)
			fecha = "0001-01-01";

		if (activo != null)
		    activo = "1";
		else
		    activo = "0";

		INotasService n = new NotasServiceImp();
		IAlumnosService al = new AlumnosServiceImp();
		IAsignaturasService as = new AsignaturasServiceImp();
		
		ArrayList<NotasDTO> listaNotas = new ArrayList<>();
		ArrayList<NotasDTO> listaBuscarNotas = new ArrayList<>();
		ArrayList<AlumnoDTO> listaAlumnos = new ArrayList<>();
		ArrayList<AsignaturaDTO> listaAsignaturas = new ArrayList<>();

		listaAlumnos = al.obtenerAlumnosPorIdNombreActivo(id, nombre, Integer.parseInt(activo));
		listaAsignaturas = as.obtenerAsignaturasPorId(idasignatura);
		listaBuscarNotas = n.obtenerNotasFiltradas(nota, fecha);
		
		for(AlumnoDTO alumno : listaAlumnos) {
			for(NotasDTO checkNota : listaBuscarNotas) {
				for(AsignaturaDTO checkAsignatura : listaAsignaturas) {
					if(alumno.getId() == Integer.getInteger(checkNota.getId_alumno()) && Integer.getInteger(checkNota.getId_asignatura()) == checkAsignatura.getId()) {
						NotasDTO notaMostrar = new NotasDTO(String.valueOf(alumno.getId()), alumno.getNombre(), checkAsignatura.getNombre(), checkNota.getNota(), checkNota.getFecha());
						listaNotas.add(notaMostrar);
					}
				}
			}
		}
		
		

		request.setAttribute("lista", listaNotas);
		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

}
