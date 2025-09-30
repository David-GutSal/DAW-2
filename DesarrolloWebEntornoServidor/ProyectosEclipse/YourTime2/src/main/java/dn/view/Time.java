package dn.view;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Time")
public class Time extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Time() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        LocalDateTime localDate =  LocalDateTime.now();
        int day = localDate.getDayOfMonth();
        int hours = localDate.getHour();
        int minutes = localDate.getMinute();
        int seconds = localDate.getSecond();
        
        out.println("<html><body>");
        out.println("<h1>Hora</h1>");
        out.println("<a href=\"/YourTime\">Regresar a la página principal</a>");
        out.println("<h3>La hora del día "+day+ " es : " + hours + ":" + minutes +":"+ seconds +"</h3>");
        out.println("</body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
