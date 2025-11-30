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
 * Servlet implementation class BorrarAlumnosController
 */
@WebServlet("/notas/borrarNotas")
public class BorrarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarNotasController() {
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
		String asignatura = request.getParameter("asignaturas");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
	    
		INotasService a = new NotasServiceImp();
	    a.borrarNota(id, asignatura, nota, fecha);
	    
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/borrarNotas.jsp");
        d.forward(request, response);
	}

}
