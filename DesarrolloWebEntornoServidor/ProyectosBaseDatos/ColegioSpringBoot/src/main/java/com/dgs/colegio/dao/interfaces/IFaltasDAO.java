package com.dgs.colegio.dao.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.FaltaDTO;


public interface IFaltasDAO {

    ArrayList<FaltaDTO> obtenerTodasFaltas();

    ArrayList<FaltaDTO> obtenerFaltasPorFiltros(String nombreAlumno, String asignatura, String fecha, int justificada);

    ArrayList<FaltaDTO> obtenerFaltasPorFiltrosSinFecha(String nombreAlumno, String asignatura, int justificada);

    int insertarFalta(String idAlumno, String idAsignatura, String fecha, int justificada);

    int actualizarFalta(String idFalta, String idAlumno, String idAsignatura, String fecha, int justificada);

    int borrarFalta(String idFalta);

}
