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
	        + "CAST(n.nota AS string), " 
	        + "n.asignatura.id, "        
	        + "a.nombre, "             
	        + "n.alumno.id, "            
	        + "al.nombre, "              
	        + "n.fecha) "
	        + "FROM NotaEntity n "       
	        + "JOIN n.asignatura a "     
	        + "JOIN n.alumno al "     
	        + "WHERE (CASE WHEN :idAlumno IS NULL THEN TRUE ELSE CAST(n.alumno.id AS string) LIKE CONCAT('%', :idAlumno, '%') END) "
	        + "AND (CASE WHEN :nombreAlumno IS NULL THEN TRUE ELSE al.nombre LIKE CONCAT('%', :nombreAlumno, '%') END) "
	        + "AND (CASE WHEN :nombreAsignatura IS NULL THEN TRUE ELSE a.nombre LIKE CONCAT('%', :nombreAsignatura, '%') END) "
	        + "AND (CASE WHEN :nota IS NULL THEN TRUE ELSE CAST(n.nota AS string) LIKE CONCAT('%', :nota, '%') END) "
	        + "AND (CASE WHEN :fecha IS NULL OR :fecha = '' THEN TRUE ELSE n.fecha >= :fecha END) " 
	        + "AND al.activo = :activo", 
	        nativeQuery = false)

	ArrayList<NotaDTO> obtenerNotasPorFiltros(
	        @Param("idAlumno") Integer idAlumno,
	        @Param("nombreAlumno") String nombreAlumno,
	        @Param("nombreAsignatura") String nombreAsignatura,
	        @Param("nota") String nota,
	        @Param("fecha") String fecha,
	        @Param("activo") int activo);

	@Query(value = "SELECT new com.dgs.colegio.dtos.NotaDTO("
	        + "n.id, "
	        + "CAST(n.nota AS string), " 
	        + "n.asignatura.id, "        
	        + "a.nombre, "             
	        + "n.alumno.id, "            
	        + "al.nombre, "              
	        + "n.fecha) "
	        + "FROM NotaEntity n "       
	        + "JOIN n.asignatura a "     
	        + "JOIN n.alumno al "     
	        + "WHERE (CASE WHEN :idAlumno IS NULL THEN TRUE ELSE CAST(n.alumno.id AS string) LIKE CONCAT('%', :idAlumno, '%') END) "
	        + "AND (CASE WHEN :nombreAlumno IS NULL THEN TRUE ELSE al.nombre LIKE CONCAT('%', :nombreAlumno, '%') END) "
	        + "AND (CASE WHEN :nombreAsignatura IS NULL THEN TRUE ELSE a.nombre LIKE CONCAT('%', :nombreAsignatura, '%') END) "
	        + "AND (CASE WHEN :nota IS NULL THEN TRUE ELSE CAST(n.nota AS string) LIKE CONCAT('%', :nota, '%') END) "
	        + "AND al.activo = :activo", 
	        nativeQuery = false)
    
    ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(
	        @Param("idAlumno") Integer idAlumno,
	        @Param("nombreAlumno") String nombreAlumno,
	        @Param("nombreAsignatura") String nombreAsignatura,
	        @Param("nota") String nota,
	        @Param("activo") int activo);

}
