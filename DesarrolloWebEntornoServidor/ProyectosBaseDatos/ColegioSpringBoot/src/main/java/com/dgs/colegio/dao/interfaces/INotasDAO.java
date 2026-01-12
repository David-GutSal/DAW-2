package com.dgs.colegio.dao.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.NotaDTO;



public interface INotasDAO {

    ArrayList<NotaDTO> obtenerTodasNotas();

    ArrayList<NotaDTO> obtenerNotasPorFiltros(String idAlumno, String nombreAlumno, String asignatura, String nota,
            String fecha, int activo);

    ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno, String asignatura,
            String nota, int activo);

    int insertarNota(String idAlumno, String idAsignatura, String nota, String fecha);

    int actualizarNota(String id, String idAlumno, String idAsignatura, String nota, String fecha);

    int borrarNota(String id);

}
