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
import java.time.LocalDate;

/**
 * Servlet implementation class InsertarAlumnosController
 */
@WebServlet("/notas/insertarNotas")
public class InsertarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNotas.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("alumnos");
		String asignatura = request.getParameter("asignaturas");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
	    
		if (fecha == null || fecha == "") {
			LocalDate fechaActual = LocalDate.now();
			fecha = String.valueOf(fechaActual);
		}
		
	    INotasService a = new NotasServiceImp();
	    Integer resultado = a.insertarNota(nombre, asignatura, nota, fecha);
	    
	    request.setAttribute("resultado", resultado);
        
	    DesplegableUtils.recuperarDesplegableAlumnos(request);
		DesplegableUtils.recuperarDesplegableAsignaturas(request);
	    RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNotas.jsp");
	    d.forward(request, response);
	}
	


}
