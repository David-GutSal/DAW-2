package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.IDesplegablesDAO;
import com.dgs.colegio.dtos.DesplegableDTO;
import com.dgs.colegio.entities.MunicipioEntity;
import com.dgs.colegio.repository.MunicipioRepository;
@Repository
public class DesplegablesDAOImpl implements IDesplegablesDAO {
	@Autowired
	private MunicipioRepository municipioRepository;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

}
