package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.IAlumnosDAO;
import com.dgs.colegio.dtos.AlumnoDTO;
import com.dgs.colegio.entities.AlumnoEntity;
import com.dgs.colegio.entities.MunicipioEntity;
import com.dgs.colegio.repository.AlumnoRepository;
import com.dgs.colegio.repository.MunicipioRepository;
@Repository
public class AlumnosDAOImpl implements IAlumnosDAO {

	@Autowired
	MunicipioRepository municipioRepository;
	@Autowired
	AlumnoRepository alumnosRepository;

	@Override
	public ArrayList<AlumnoDTO> obtenerTodosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(Integer id, String nombre, String apellido,
			int familiaNumerosa, int activo) {
		return alumnosRepository.buscaAlumnoporIDyNombre(id, nombre, apellido, familiaNumerosa, activo);
	}

	@Override
	public int insertarAlumno(int id, String nombre, String apellido, int idMunicipio, int familiaNumerosa,
			int activo) {
		MunicipioEntity municipio = municipioRepository.findById(idMunicipio).get();
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, apellido, familiaNumerosa, activo, municipio);
		alumnosRepository.save(alumno);
		return alumno.getId();
	}

	@Override
	public int actualizarAlumno(int id, String nombre, String apellido, int idMunicipio, int familiaNumerosa,
			int activo) {
		
		MunicipioEntity municipio = municipioRepository.findById(idMunicipio).get();
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, apellido, familiaNumerosa, activo, municipio);
		alumnosRepository.save(alumno);
		return alumno.getId();
	}

	@Override
	public int borrarAlumno(int id)  {
		AlumnoEntity alumno = alumnosRepository.findById(id).get();
		alumno.setActivo(0);
		alumnosRepository.save(alumno);
		return alumno.getId();
		}


	@Override
	public boolean esFamiliaNumerosa(String idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int contarAsignaturasMatriculadas(String idAlumno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
