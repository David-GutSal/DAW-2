package utils;

import java.util.ArrayList;

import dao.IDesplegableDAO;
import daoImp.DesplegableDAOImp;
import dto.AsignaturaDTO;
import dto.DesplegableDTO;
import jakarta.servlet.http.HttpServletRequest;
import servicios.IAsignaturasService;
import serviciosImp.AsignaturasServiceImp;

public class DesplegableUtils {
	
	public static void recuperarDesplegableMunicipios(HttpServletRequest request) {
		IDesplegableDAO desplegableMunicipios = new DesplegableDAOImp();
		ArrayList<DesplegableDTO> listaMunicipios = desplegableMunicipios.desplegableMunicipios();
		request.setAttribute("desplegableMunicipios", listaMunicipios);
	}
	
	public static void recuperarDesplegableAsignaturas(HttpServletRequest request) {
		IDesplegableDAO desplegableAsignaturas = new DesplegableDAOImp();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegableAsignaturas.desplegableAsignaturas();
		request.setAttribute("desplegableAsignaturas", listaAsignaturas);
	}
	
	public static void recuperarDesplegableAlumnos(HttpServletRequest request) {
		IDesplegableDAO desplegableAlumnos = new DesplegableDAOImp();
		ArrayList<DesplegableDTO> listaAlumnos = desplegableAlumnos.desplegableAsignaturas();
		request.setAttribute("desplegableAlumnos", listaAlumnos);
	}

}
