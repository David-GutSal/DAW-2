package com.adrian.colegio.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;  // Agregado para DELETE
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.servicio.interfaces.IAsignaturasService;

@RestController
@RequestMapping("/v2")
public class AsignaturasRestControllerV2 {
    @Autowired
    IAsignaturasService asignaturasService;

    // -----------------
    // INSERTAR ASIGNATURA
    // -----------------
    @PostMapping("/asignaturas")
    public ResponseEntity<String> insertarAsignatura(@RequestBody AsignaturaDTO asignatura) {
        asignaturasService.insertarAsignatura(asignatura.getId(), asignatura.getNombre(), asignatura.getCurso(), asignatura.getTasa(), asignatura.getActivo());
        return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);
    }

    // -----------------
    // LISTADO ASIGNATURAS
    // -----------------
    @GetMapping("/asignaturas")
    public List<AsignaturaDTO> listarTodosAsignaturas() {
        return asignaturasService.obtenerAsignaturasPorFiltros(null, null, null, null, null);
    }

    @GetMapping("/asignaturas/{id}")
    public ResponseEntity<Optional<AsignaturaEntity>> buscarAsignaturaPorId(@PathVariable("id") Integer id) {
    	Optional<AsignaturaEntity> asignatura = asignaturasService.obtenerAsignaturaPorId(id); 
        if (asignatura == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asignatura);
    }

    @GetMapping(value = "/asignaturas", params = { "id", "nombre", "curso", "tasa", "activo" })
    public List<AsignaturaDTO> obtenerAsignaturasPorFiltros(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "curso", required = false) Integer curso,
            @RequestParam(value = "tasa", required = false) Double tasa,
            @RequestParam(value = "activo", required = false) Integer activo) {
        return asignaturasService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
    }

    // -------------------------
    // MODIFICAR ASIGNATURA
    // -------------------------
    @PutMapping("/asignaturas/{id}")
    public ResponseEntity<?> modificarAsignaturas(@PathVariable Integer id, @RequestBody AsignaturaDTO asignatura) {
        if (!id.equals(asignatura.getId())) {
            return ResponseEntity.badRequest().body("El ID de la URL no coincide con el de la asignatura");
        }

        if (asignaturasService.obtenerAsignaturaPorId(asignatura.getId()) == null) {
            return ResponseEntity.notFound().build();
        }

        asignaturasService.actualizarAsignatura(asignatura.getId(), asignatura.getNombre(), asignatura.getCurso(), asignatura.getTasa(), asignatura.getActivo());
        
        Optional<AsignaturaEntity> actualizada = asignaturasService.obtenerAsignaturaPorId(asignatura.getId());
        return ResponseEntity.ok(actualizada);
    }

    // -------------------------
    // BORRAR ASIGNATURA
    // -------------------------
    @DeleteMapping("/asignaturas/{id}") 
    public ResponseEntity<?> borrarAsignatura(@PathVariable Integer id) {
        if (asignaturasService.obtenerAsignaturaPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        asignaturasService.borrarAsignatura(id);
        return new ResponseEntity<String>("Borrado correcto!", HttpStatus.OK);
    }
}