package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.IDesplegablesDAO;
import com.dgs.colegio.dtos.DesplegableDTO;
import com.dgs.colegio.entities.AlumnoEntity;
import com.dgs.colegio.entities.AsignaturaEntity;
import com.dgs.colegio.entities.MunicipioEntity;
import com.dgs.colegio.repository.AlumnoRepository;
import com.dgs.colegio.repository.AsignaturaRepository;
import com.dgs.colegio.repository.MunicipioRepository;
@Repository
public class DesplegablesDAOImpl implements IDesplegablesDAO {
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public ArrayList<DesplegableDTO> desplegableMunicipios() {
		Iterable<MunicipioEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		ArrayList<DesplegableDTO> listaMunicipios = mapeoEntidadMunicioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	private ArrayList<DesplegableDTO> mapeoEntidadMunicioComboDTO(Iterable<MunicipioEntity> listaEntidadesMunicipios) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (MunicipioEntity municipiosEntity : listaEntidadesMunicipios) {
			listaCombos.add(new DesplegableDTO(municipiosEntity.getIdMunicipio(), municipiosEntity.getNombre()));
		}
		return listaCombos;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAsignaturas() {
		Iterable<AsignaturaEntity> listaEntidadesAsignaturas = asignaturaRepository.findAll();
		ArrayList<DesplegableDTO> listaAsignaturas = mapeoEntidadAsignaturaDTO(listaEntidadesAsignaturas);
		return listaAsignaturas;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadAsignaturaDTO(Iterable<AsignaturaEntity> listaEntidadesAsignaturas) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (AsignaturaEntity asignaturaEntity : listaEntidadesAsignaturas) {
			listaCombos.add(new DesplegableDTO(asignaturaEntity.getId(), asignaturaEntity.getNombre()));
		}
		return listaCombos;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAlumnos() {
		Iterable<AlumnoEntity> listaEntidadesAlumnos = alumnoRepository.findAll();
		ArrayList<DesplegableDTO> listaAlumnos = mapeoEntidadAlumnoComboDTO(listaEntidadesAlumnos);
		return listaAlumnos;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadAlumnoComboDTO(Iterable<AlumnoEntity> listaEntidadesAlumnos) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (AlumnoEntity alumnoEntity : listaEntidadesAlumnos) {
			listaCombos.add(new DesplegableDTO(alumnoEntity.getId(), alumnoEntity.getNombre()));
		}
		return listaCombos;
	}

}
