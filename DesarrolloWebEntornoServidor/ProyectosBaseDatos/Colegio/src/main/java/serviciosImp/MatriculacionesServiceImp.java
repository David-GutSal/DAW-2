package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IAlumnosDAO;
import dao.IAsignaturasDAO;
import dao.IMatriculacionesDAO;
import daoImp.AlumnosDAOImpl;
import daoImp.AsignaturasDAOImpl;
import daoImp.MatriculacionesDAOImpl;
import dto.MatriculaDTO;
import servicios.IMatriculacionesService;

public class MatriculacionesServiceImp implements IMatriculacionesService {

	@Override
	public double calcularTasa(String idAlumno, String idAsignatura) {
		IAsignaturasDAO asignaturasDAO = new AsignaturasDAOImpl();
		IAlumnosDAO alumnosDAO = new AlumnosDAOImpl();
		double tasaBase = asignaturasDAO.obtenerTasaAsignatura(idAsignatura);
		int numAsignaturasMatriculadas = alumnosDAO.contarAsignaturasMatriculadas(idAlumno);
		boolean esFamiliaNumerosa = alumnosDAO.esFamiliaNumerosa(idAlumno);
		double tasaFinal = tasaBase;
		if (numAsignaturasMatriculadas >= 3 && numAsignaturasMatriculadas <= 5) {
			tasaFinal = tasaFinal * 0.70;

		} else if (numAsignaturasMatriculadas >= 6) {
			tasaFinal = tasaFinal * 0.50;

		}
		if (esFamiliaNumerosa) {
			tasaFinal = tasaFinal * 0.50;
		}

		return tasaFinal;
	}

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha,
			int activo, String tasa) {
		IMatriculacionesDAO matricula = new MatriculacionesDAOImpl();
		return matricula.obtenerMatriculasFiltradas(asignatura, alumno, fecha, activo, tasa);
	}

	@Override
	public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) {
		IMatriculacionesDAO matriculaciones = new MatriculacionesDAOImpl();
		try {
			return matriculaciones.insertarMatriculacion(idAsignatura, idAlumno, fecha, tasa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String alumno, String asignatura, String fecha) {
		IMatriculacionesDAO matricula = new MatriculacionesDAOImpl();
		return matricula.obtenerMatriculasFiltradas(asignatura, alumno, fecha);
	}

	@Override
	public int actualizarMatriculaciones(String id, String nombre, String asignatura, String fecha, String tasa) {
		IMatriculacionesDAO matricula = new MatriculacionesDAOImpl();
		return matricula.actualizarMatriculaciones(id, nombre, asignatura, fecha, tasa);
	}
}
