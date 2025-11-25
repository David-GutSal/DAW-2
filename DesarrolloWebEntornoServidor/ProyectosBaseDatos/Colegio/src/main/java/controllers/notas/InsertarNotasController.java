package controllers.notas;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAsignaturasService;
import serviciosImp.AsignaturasServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;

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
		DesplegableUtils.recuperarDesplegableMunicipios(request);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNotas.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String id = request.getParameter("id");
	    String nombre = request.getParameter("nombre");
	    String curso = request.getParameter("curso");
	    String tasa = request.getParameter("tasa");
	    String activo = request.getParameter("activo");
	    
		if (activo != null)
		    activo = "1";
		else
		    activo = "0";
	    
	    IAsignaturasService a = new AsignaturasServiceImp();
	    Integer resultado = a.insertarAsignatura(id, nombre, curso, Double.parseDouble(tasa), Integer.parseInt(activo));
	    
	    request.setAttribute("resultado", resultado);
	    
	    DesplegableUtils.recuperarDesplegableMunicipios(request);
        
	    
	    RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNotas.jsp");
	    d.forward(request, response);
	}
	


}
