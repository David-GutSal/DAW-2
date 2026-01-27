package com.daw.onepiece.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.entities.PirataEntity;

@Repository
public interface PirataRepository extends CrudRepository<PirataEntity, Integer>{
	
	@Query("SELECT new com.daw.onepiece.dtos.PirataDTO("
		    + "p.id, "
		    + "p.nombre, "
		    + "p.frutaDelDiablo, "
		    + "t.nombre, "
		    + "p.fechaNacimiento, "
		    + "i.nombre, "
		    + "p.estaActivo) "
		    + "FROM PirataEntity p "
		    + "JOIN p.isla i "
		    + "LEFT JOIN ReclutamientoEntity r ON r.pirata = p AND r.esMiembroActual = true "
		    + "LEFT JOIN r.tripulacion t "
		    + "WHERE (:id IS NULL OR p.id = :id) "
		    + "AND (:nombre IS NULL OR p.nombre LIKE CONCAT('%', :nombre, '%')) "
		    + "AND (:fruta IS NULL OR p.frutaDelDiablo LIKE CONCAT('%', :fruta, '%')) "
		    + "AND (:activo IS NULL OR p.estaActivo = :activo)")
	
	ArrayList<PirataDTO> obtenerPiratasPorFiltro(
			@Param("id") Integer id,
			@Param("nombre") String nombre, 
			@Param("fruta") String fruta, 
			@Param("activo") Boolean act
			);

}
