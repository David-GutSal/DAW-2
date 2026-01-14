package com.dgs.colegio.dao.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.NotaDTO;



public interface INotasDAO {

    ArrayList<NotaDTO> obtenerTodasNotas();

	ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno, String asignatura,
			Integer nota, int activo);

	ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura, Integer nota,
			String fecha, int activo);

	int insertarNota(Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

	int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

	int borrarNota(Integer id);

}
