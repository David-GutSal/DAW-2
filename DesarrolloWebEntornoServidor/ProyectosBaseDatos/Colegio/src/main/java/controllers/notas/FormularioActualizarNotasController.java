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
import java.util.ArrayList;

import dto.AsignaturaDTO;                                         
                                                                    
/**                                                                 
 * * Servlet implementation class FomularioActualizarAlumnosController */
@WebServlet("/asignaturas/formularioActualizarAsignaturas")
public class FormularioActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/actualizarAsignaturas.jsp");
        d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
		String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String curso = request.getParameter("curso");
        String tasa = request.getParameter("tasa");
        String activo =  request.getParameter("activo");
        
		if (tasa == null || tasa.trim().isEmpty())
		    tasa = "0";

		if (activo != null)
		    activo = "1";
		else
		    activo = "0";

		ArrayList<AsignaturaDTO> listaAsignaturas = new ArrayList<>();
        
		IAsignaturasService a = new AsignaturasServiceImp();
        listaAsignaturas = a.obtenerAsignaturasPorIdNombreCursoTasa(id, nombre, curso, Double.parseDouble(tasa), Integer.parseInt(activo));
        request.setAttribute("lista", listaAsignaturas);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/actualizarAsignaturas.jsp");
        d.forward(request, response);
        
        
	}

}
