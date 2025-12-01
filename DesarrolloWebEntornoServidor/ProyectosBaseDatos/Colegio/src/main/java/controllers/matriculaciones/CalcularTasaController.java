package controllers.matriculaciones;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IMatriculacionesService;
import serviciosImp.MatriculacionesServiceImp;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcularTasaController
 */
@WebServlet("/tasa")
public class CalcularTasaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalcularTasaController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAlumno = request.getParameter("alumnos");
		String idAsignatura = request.getParameter("asignaturas");


		IMatriculacionesService service = new MatriculacionesServiceImp();
		double tasaFinal = service.calcularTasa(idAlumno, idAsignatura);

		PrintWriter out = response.getWriter();
		out.print(tasaFinal);
	}


}
