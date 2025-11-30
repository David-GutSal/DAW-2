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
import java.util.ArrayList;

import dto.NotasDTO;

/**
 * Servlet implementation class FormularioBorrarAlumnosController
 */
@WebServlet("/notas/formularioBorrarNotas")
public class FormularioBorrarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/borrarNotas.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
		
		String nombre = request.getParameter("alumnos");
		String asignatura = request.getParameter("asignaturas");
		String fecha = request.getParameter("fecha");
        
		if (fecha == null || fecha == "")
			fecha = "0001-01-01";
		
		if (nombre == null)
			nombre = "";
		
		if (asignatura == null)
			asignatura = "";

		INotasService n = new NotasServiceImp();
		
		ArrayList<NotasDTO> listaNotas = new ArrayList<>();
		
		listaNotas = n.obtenerNotasFiltradas(nombre, asignatura, fecha);
		
        request.setAttribute("lista", listaNotas);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/borrarNotas.jsp");
        d.forward(request, response);
	}

}
