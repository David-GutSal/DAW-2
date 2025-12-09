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

@WebServlet("/matriculaciones/formularioBorrarMatriculas")
public class FormularioBorrarMatriculasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarMatriculasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculacion.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		
		String alumno = request.getParameter("alumnos");
		String asignatura = request.getParameter("asignaturas");
		String fecha = request.getParameter("date");
        
		if (fecha == null || fecha == "")
			fecha = "0001-01-01";
		
		if (alumno == null)
			alumno = "";
		
		if (asignatura == null)
			asignatura = "";

		ArrayList<MatriculaDTO> listaMatriculas = new ArrayList<>();
		IMatriculacionesService m = new MatriculacionesServiceImp();
		listaMatriculas = m.obtenerMatriculasFiltradas(alumno, asignatura, fecha);
		
        request.setAttribute("lista", listaMatriculas);
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculacion.jsp");
        d.forward(request, response);
	}

}
