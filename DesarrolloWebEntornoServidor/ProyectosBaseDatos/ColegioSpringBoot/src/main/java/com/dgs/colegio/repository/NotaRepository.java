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
            + "n.nota, " 
            + "n.asignatura, "
            + "a.nombre, "
            + "n.alumno, "
            + "al.nombre, "
            + "n.fecha) "
            + "FROM notas n "
            + "JOIN asignatura a ON n.asignatura = a.id "
            + "JOIN alumno al ON n.alumno = al.id "
            + "WHERE (CASE WHEN :idAlumno IS NULL THEN TRUE ELSE CAST(n.id_alumnos AS VARCHAR) LIKE CONCAT('%', :idAlumno, '%') END) "
            + "AND (CASE WHEN :nombreAlumno IS NULL THEN TRUE ELSE al.nombre LIKE CONCAT('%', :nombreAlumno, '%') END) "
            + "AND (CASE WHEN :nombreAsignatura IS NULL THEN TRUE ELSE a.nombreAsignatura LIKE CONCAT('%', :nombreAsignatura, '%') END) "
            + "AND (CASE WHEN :nota IS NULL THEN TRUE ELSE CAST(n.nota AS VARCHAR) LIKE CONCAT('%', :nota, '%') END) "
            + "AND (CASE WHEN :fecha IS NULL THEN TRUE ELSE n.fecha >= :fecha END) " 
            + "AND al.activo = :activo", 
            nativeQuery = true)
    
    ArrayList<NotaDTO> obtenerNotasPorFiltros(
            @Param("idAlumno") Integer idAlumno,
            @Param("nombreAlumno") String nombreAlumno,
            @Param("asignatura") String nombreAsignatura,
            @Param("nota") String nota,
            @Param("fecha") String fecha,
            @Param("activo") int activo);

    @Query(value = "SELECT new com.dgs.colegio.dtos.NotaDTO("
            + "n.id, "
            + "n.nota, " 
            + "n.id_asignaturas, "
            + "a.nombre, "
            + "n.alumno, "
            + "al.nombre, "
            + "n.fecha) "
            + "FROM notas n "
            + "JOIN asignatura a ON n.asignatura = a.id "
            + "JOIN alumno al ON n.alumno = al.id "
            + "WHERE (CASE WHEN :idAlumno IS NULL THEN TRUE ELSE CAST(n.id_alumnos AS VARCHAR) LIKE CONCAT('%', :idAlumno, '%') END) "
            + "AND (CASE WHEN :nombreAlumno IS NULL THEN TRUE ELSE al.nombre LIKE CONCAT('%', :nombreAlumno, '%') END) "
            + "AND (CASE WHEN :nombreAsignatura IS NULL THEN TRUE ELSE a.nombreAsignatura LIKE CONCAT('%', :nombreAsignatura, '%') END) "
            + "AND (CASE WHEN :nota IS NULL THEN TRUE ELSE CAST(n.nota AS VARCHAR) LIKE CONCAT('%', :nota, '%') END) "
            + "AND al.activo = :activo", 
            nativeQuery = true)
    
    ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(
            @Param("idAlumno") Integer idAlumno,
            @Param("nombreAlumno") String nombreAlumno,
            @Param("asignatura") String nombreAsignatura,
            @Param("nota") String nota,
            @Param("activo") int activo);

}
