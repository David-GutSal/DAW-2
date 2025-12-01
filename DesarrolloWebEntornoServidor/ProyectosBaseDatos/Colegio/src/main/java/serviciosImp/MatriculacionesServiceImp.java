package serviciosImp;

import dao.IAlumnosDAO;
import dao.IAsignaturasDAO;
import daoImp.AlumnosDAOImpl;
import daoImp.AsignaturasDAOImpl;
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
}
