package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.entities.IslaEntity;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.entities.TripulacionEntity;
import com.daw.onepiece.repositorios.IslaRepository;
import com.daw.onepiece.repositorios.PirataRepository;
import com.daw.onepiece.repositorios.TripulacionRepository;

@Repository
public class DesplegablesDAOImpl implements IDesplegablesDAO {
	
	@Autowired
	private IslaRepository islaRepository;
	@Autowired
	private PirataRepository pirataRepository;
	@Autowired
	private TripulacionRepository tripulacionRepository;

	@Override
	public ArrayList<DesplegableDTO> desplegableIslas() {
		Iterable<IslaEntity> listaEntidadesIslas = islaRepository.findAll();
		ArrayList<DesplegableDTO> listaIslas = mapeoEntidadIslaComboDTO(listaEntidadesIslas);
		return listaIslas;
	}

	private ArrayList<DesplegableDTO> mapeoEntidadIslaComboDTO(Iterable<IslaEntity> listaEntidadesIslas) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (IslaEntity islaEntity : listaEntidadesIslas) {
			listaCombos.add(new DesplegableDTO(islaEntity.getId(), islaEntity.getNombre()));
		}
		return listaCombos;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegablePiratas() {
		Iterable<PirataEntity> listaEntidadesAsignaturas = pirataRepository.findAll();
		ArrayList<DesplegableDTO> listaPiratas = mapeoEntidadPirataDTO(listaEntidadesAsignaturas);
		return listaPiratas;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadPirataDTO(Iterable<PirataEntity> listaEntidadesPiratas) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (PirataEntity pirataEntity : listaEntidadesPiratas) {
			listaCombos.add(new DesplegableDTO(pirataEntity.getId(), pirataEntity.getNombre()));
		}
		return listaCombos;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableTripulaciones() {
		Iterable<TripulacionEntity> listaEntidadesTripulaciones = tripulacionRepository.findAll();
		ArrayList<DesplegableDTO> listaTripulaciones = mapeoEntidadTripulacionComboDTO(listaEntidadesTripulaciones);
		return listaTripulaciones;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadTripulacionComboDTO(Iterable<TripulacionEntity> listaEntidadesTripulaciones) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (TripulacionEntity tripulacionEntity : listaEntidadesTripulaciones) {
			listaCombos.add(new DesplegableDTO(tripulacionEntity.getId(), tripulacionEntity.getNombre()));
		}
		return listaCombos;
	}

}
