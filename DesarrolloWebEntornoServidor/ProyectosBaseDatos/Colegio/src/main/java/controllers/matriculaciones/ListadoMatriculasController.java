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
import java.util.ArrayList;

import dto.MatriculaDTO;

/**
 * Servlet implementation class ListadoAlumnosController
 */
@WebServlet("/matriculaciones/listadoMatriculaciones")
public class ListadoMatriculasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoMatriculasController() {
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
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculaciones/listadoMatriculaciones.jsp");
		d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String asignatura = request.getParameter("asignaturas");
        String alumno = request.getParameter("alumnos");
        String fecha = request.getParameter("date");
        String activo =  request.getParameter("activo");
        String tasa =  request.getParameter("tasa");
        
        if(asignatura == null)
        	asignatura = "";
        
        if(alumno == null)
        	alumno = "";
        
        if(fecha == "")
        	fecha = "0001-01-01";
         
        if(tasa == null)
        	tasa = "";
        
        if(activo != null)
        	activo = "1";
        else
        	activo = "0";
        
        IMatriculacionesService  m = new MatriculacionesServiceImp();
        ArrayList<MatriculaDTO> listaMatriculas = new ArrayList<>();
        
        listaMatriculas = m.obtenerMatriculasFiltradas(asignatura, alumno, fecha, Integer.parseInt(activo), tasa);
        
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
        request.setAttribute("lista", listaMatriculas);
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculaciones/listadoMatriculaciones.jsp");
        d.forward(request, response);
	}

}
