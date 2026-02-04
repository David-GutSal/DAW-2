package com.daw.onepiece.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.entities.ReclutamientoEntity;

@Repository
public interface ReclutamientoRepository extends CrudRepository<ReclutamientoEntity, Integer> {
	@Query("SELECT new com.daw.onepiece.dtos.ReclutamientoDTO("
		    + "r.id, r.pirata, r.tripulacion, r.rol, r.esMiembroActual) "
		    + "FROM ReclutamientoEntity r "
		    + "WHERE (r.pirata LIKE CONCAT('%', :pirata_id, '%')) "
		    + "AND (r.tripulacion LIKE CONCAT('%', :tripulacion_id, '%')) ")
	
	ReclutamientoEntity buscarMiembro(
			@Param("pirata_id") String idPirata, 
			@Param("tripulacion_id") String idTripulacion);

}
