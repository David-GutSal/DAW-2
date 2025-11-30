package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.INotasService;
import serviciosImp.NotasServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;

/**
 * Servlet implementation class ActualizarAlumnosController
 */
@WebServlet("/notas/actualizarNotas")
public class ActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("alumnos");
		String asignatura = request.getParameter("asignaturas");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");

		if (nota == null)
			nota = "";
		
		if (nombre == null)
			nombre = "";
		
		if (asignatura == null)
			asignatura = "";

			INotasService a = new NotasServiceImp();
		    a.actualizarNotas(id, nombre, asignatura, nota, fecha);
		    
			DesplegableUtils.recuperarDesplegableAlumnos(request);
			DesplegableUtils.recuperarDesplegableAsignaturas(request);
	        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/actualizarNotas.jsp");
	        d.forward(request, response);
	}

}
