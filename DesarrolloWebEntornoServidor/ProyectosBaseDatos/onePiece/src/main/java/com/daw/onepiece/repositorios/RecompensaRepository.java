package com.daw.onepiece.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.entities.RecompensaEntity;

public interface RecompensaRepository extends JpaRepository<RecompensaEntity, Integer> {

    @Query("""
    	    SELECT new com.daw.onepiece.dtos.RecompensaDTO(
            r.id,
            p.id,
            p.nombre,
            t.nombre,
            r.cantidad,
            CASE WHEN r.vigente = true THEN 1 ELSE 0 END
        )
        FROM RecompensaEntity r
        JOIN r.pirata p
        LEFT JOIN ReclutamientoEntity rec 
            ON rec.pirata.id = p.id AND rec.esMiembroActual = true
        LEFT JOIN rec.tripulacion t
        WHERE (:id IS NULL OR r.id = :id)
          AND (:nombrePirata IS NULL OR p.nombre LIKE %:nombrePirata%)
          AND (:idTripulacion IS NULL OR t.id = :idTripulacion)
          AND (:cantidad IS NULL OR r.cantidad >= :cantidad)
          AND (:estaVigente IS NULL OR (CASE WHEN r.vigente = true THEN 1 ELSE 0 END) = :estaVigente)
        """)
    
    List<RecompensaDTO> listarRecompensas(
    	@Param("id") Integer id,
        @Param("nombrePirata") String nombrePirata,
        @Param("idTripulacion") Integer idTripulacion,
        @Param("cantidad") Double cantidad,
        @Param("estaVigente") Integer estaVigente
    );

    @Modifying
    @Query("UPDATE RecompensaEntity r SET r.vigente = false WHERE r.pirata.id = :idPirata")
    void desactivarRecompensasDelPirata(
    		@Param("idPirata") Integer idPirata);

}
