package com.dgs.colegio.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.IMatriculacionesDAO;
import com.dgs.colegio.dtos.MatriculacionDTO;
import com.dgs.colegio.entities.AlumnoEntity;
import com.dgs.colegio.entities.AsignaturaEntity;
import com.dgs.colegio.entities.CajaEntity;
import com.dgs.colegio.entities.MatriculacionEntity;
import com.dgs.colegio.repository.AlumnoRepository;
import com.dgs.colegio.repository.AsignaturaRepository;
import com.dgs.colegio.repository.CajaRepository;
import com.dgs.colegio.repository.MatriculacionRepository;

import jakarta.transaction.Transactional;

@Controller
@Repository
public class MatriculacionesDAOImpl implements IMatriculacionesDAO {

	@Autowired
	MatriculacionRepository matriculacionRepository;
	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	AsignaturaRepository asignaturaRepository;
	@Autowired
	CajaRepository cajaRepository;
	
	@Override
	public double obtenerTasaAsignatura(Integer idAsignatura) {
		Double tasa = asignaturaRepository.findById(idAsignatura).get().getTasa();
		return tasa != null ? tasa : 0.0;
	}

	@Override
	@Transactional
	public int insertarMatriculacion(Integer idAlumno, Integer idAsignatura, double tasa, String fecha)
			throws SQLException {
		AlumnoEntity idAl = alumnoRepository.findById(idAlumno).get();
		AsignaturaEntity idAs = asignaturaRepository.findById(idAsignatura).get();
		
		int activo = idAl.getActivo();
		MatriculacionEntity matriculacion = new MatriculacionEntity(idAs, idAl, fecha, activo);
		matriculacionRepository.save(matriculacion);
		CajaEntity caja = new CajaEntity(matriculacion , tasa);
		cajaRepository.save(caja);
		return matriculacion.getId();
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo) {
		return matriculacionRepository.obtenerMatriculacionesPorFiltros(nombreAsignatura, nombreAlumno, fecha, activo);
	}

	@Override
	@Transactional
	public int actualizarMatriculacion(Integer id, Integer idAlumno, Integer idAsignatura, String fecha, Double tasa)
			throws SQLException {
		AlumnoEntity idAl = alumnoRepository.findById(idAlumno).get();
		AsignaturaEntity idAs = asignaturaRepository.findById(idAsignatura).get();
	
		MatriculacionEntity matriculacion = new MatriculacionEntity(id, idAs, idAl, fecha, 1);
		matriculacionRepository.save(matriculacion);
		
		CajaEntity caja = new CajaEntity(matriculacion , tasa);
		cajaRepository.save(caja);
		return matriculacion.getId();
	}

	@Override
	public int borrarMatriculacion(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesParaId(String asignatura, String alumno, String fecha,
			int i) {
		return matriculacionRepository.obtenerMatriculacionesParaId(asignatura, alumno, fecha, i);
	}

}
