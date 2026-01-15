package com.dgs.colegio.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dgs.colegio.dtos.NotaDTO;
import com.dgs.colegio.entities.NotaEntity;

public interface NotaRepository extends CrudRepository<NotaEntity, Integer>{

    @Query(value = "SELECT new com.dgs.colegio.dtos.NotaDTO("
            + "n.id, "
            + "CAST(n.nota AS VARCHAR), " 
            + "n.id_asignaturas, "
            + "a.nombre, "
            + "n.id_alumnos, "
            + "al.nombre, "
            + "n.fecha) "
            + "FROM notas n "
            + "JOIN asignaturas a ON n.id_asignaturas = a.id "
            + "JOIN alumnos al ON n.id_alumnos = al.id "
            + "WHERE (CASE WHEN :idAlumno IS NULL THEN TRUE ELSE CAST(n.id_alumnos AS VARCHAR) LIKE CONCAT('%', :idAlumno, '%') END) "
            + "AND (CASE WHEN :nombreAlumno IS NULL THEN TRUE ELSE al.nombre LIKE CONCAT('%', :nombreAlumno, '%') END) "
            + "AND (CASE WHEN :asignatura IS NULL THEN TRUE ELSE a.nombre LIKE CONCAT('%', :asignatura, '%') END) "
            + "AND (CASE WHEN :nota IS NULL THEN TRUE ELSE CAST(n.nota AS VARCHAR) LIKE CONCAT('%', :nota, '%') END) "
            + "AND (CASE WHEN :fecha IS NULL THEN TRUE ELSE n.fecha >= :fecha END) " 
            + "AND al.activo = :activo", 
            nativeQuery = true)
    
    ArrayList<NotaDTO> obtenerNotasPorFiltros(
            @Param("idAlumno") Integer idAlumno,
            @Param("nombreAlumno") String nombreAlumno,
            @Param("asignatura") String asignatura,
            @Param("nota") Integer nota,
            @Param("fecha") String fecha,
            @Param("activo") int activo);

    @Query(value = "SELECT new com.dgs.colegio.dtos.NotaDTO("
            + "n.id, "
            + "CAST(n.nota AS VARCHAR), " 
            + "n.id_asignaturas, "
            + "a.nombre, "
            + "n.id_alumnos, "
            + "al.nombre, "
            + "n.fecha) "
            + "FROM notas n "
            + "JOIN asignaturas a ON n.id_asignaturas = a.id "
            + "JOIN alumnos al ON n.id_alumnos = al.id "
            + "WHERE (CASE WHEN :idAlumno IS NULL THEN TRUE ELSE CAST(n.id_alumnos AS VARCHAR) LIKE CONCAT('%', :idAlumno, '%') END) "
            + "AND (CASE WHEN :nombreAlumno IS NULL THEN TRUE ELSE al.nombre LIKE CONCAT('%', :nombreAlumno, '%') END) "
            + "AND (CASE WHEN :asignatura IS NULL THEN TRUE ELSE a.nombre LIKE CONCAT('%', :asignatura, '%') END) "
            + "AND (CASE WHEN :nota IS NULL THEN TRUE ELSE CAST(n.nota AS VARCHAR) LIKE CONCAT('%', :nota, '%') END) "
            + "AND al.activo = :activo", 
            nativeQuery = true)
    
    ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(
            @Param("idAlumno") Integer idAlumno,
            @Param("nombreAlumno") String nombreAlumno,
            @Param("asignatura") String asignatura,
            @Param("nota") Integer nota,
            @Param("activo") int activo);

}
