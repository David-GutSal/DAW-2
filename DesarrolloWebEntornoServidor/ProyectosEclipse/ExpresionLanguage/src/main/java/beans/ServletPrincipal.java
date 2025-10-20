package beans;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/obtenerpersona")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPrincipal() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Persona p = new Persona(44, "Fernando Alonso");
		
		request.setAttribute("persona", p);
		
		ArrayList<String> listaDeEquipos = new ArrayList();
		listaDeEquipos.add("Ferrari");
		listaDeEquipos.add("Aston Martin");
		listaDeEquipos.add("McLaren");
		request.setAttribute("listaEquipos", listaDeEquipos);
		
		ArrayList<Persona> listaDePersonas = new ArrayList();
		listaDePersonas.add(new Persona(24, "Piastri"));
		listaDePersonas.add(new Persona(40, "Hamilton"));
		listaDePersonas.add(new Persona(28, "Verstappen"));
		request.setAttribute("listaPersonas", listaDePersonas);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Hola.jsp");
		dispatcher.forward(request, response);
	}
}
