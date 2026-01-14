package com.dgs.colegio.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.dgs.colegio.dtos.NotaDTO;
import com.dgs.colegio.entities.NotaEntity;

public interface NotaRepository extends CrudRepository<NotaEntity, Integer>{

	ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura, Integer nota,
			String fecha, int activo);

	ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura, Integer nota,
			int activo);

}
