package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class Conexion
 */
@WebServlet("/Conexion")
public class Conexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(Conexion.class);

	public Conexion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		try {
			// Con esta linea formazamos que se cargue el driver de MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://ghw-server-proyectoatraco.f.aivencloud.com:13213/colegio";
			String username = "avnadmin";
			String password = "AVNS_VfSu0SV217PwgX5hlVR";
			connection = DriverManager.getConnection(dbURL, username, password);
			
			// Ya tenemos la conexio hecha a la BBDD
			logger.info("Conexion con la BBDD establecida");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
