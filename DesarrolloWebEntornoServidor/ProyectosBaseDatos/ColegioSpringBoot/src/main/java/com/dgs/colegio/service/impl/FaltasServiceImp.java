package com.dgs.colegio.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.dgs.colegio.dao.interfaces.IFaltasDAO;
import com.dgs.colegio.dtos.FaltaDTO;
import com.dgs.colegio.service.interfaces.IFaltasService;

public class FaltasServiceImp implements IFaltasService {
	@Autowired
	IFaltasDAO faltas;
	
    @Override
    public ArrayList<FaltaDTO> obtenerFaltas() throws SQLException {
        return faltas.obtenerTodasFaltas();
    }

    @Override
    public ArrayList<FaltaDTO> obtenerFaltasPorFiltros(String nombreAlumno, String asignatura, String fecha,
            int justificada) {
        return faltas.obtenerFaltasPorFiltros(nombreAlumno, asignatura, fecha, justificada);
    }

    @Override
    public ArrayList<FaltaDTO> obtenerFaltasPorFiltrosSinFecha(String nombreAlumno, String asignatura,
            int justificada) {
        return faltas.obtenerFaltasPorFiltrosSinFecha(nombreAlumno, asignatura, justificada);
    }

    @Override
    public int insertarFalta(String idAlumno, String idAsignatura, String fecha, int justificada) {
        return faltas.insertarFalta(idAlumno, idAsignatura, fecha, justificada);
    }

    @Override
    public int actualizarFalta(String idFalta, String idAlumno, String idAsignatura, String fecha, int justificada) {
        return faltas.actualizarFalta(idFalta, idAlumno, idAsignatura, fecha, justificada);
    }

    @Override
    public int borrarFalta(String idFalta) {
        return faltas.borrarFalta(idFalta);
    }

}
