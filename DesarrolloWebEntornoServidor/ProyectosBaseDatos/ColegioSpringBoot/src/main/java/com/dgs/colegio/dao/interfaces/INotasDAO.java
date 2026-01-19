package com.dgs.colegio.dao.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.NotaDTO;



public interface INotasDAO {

    ArrayList<NotaDTO> obtenerTodasNotas();

	int borrarNota(Integer id);

	ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String nombreAsignatura,
			String nota, String fecha, Integer activo);

	ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno, String asignatura,
			String nota, Integer act);

	int insertarNota(Integer idAlumno, Integer idAsignatura, String nota, String fecha);

	int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

}
