package com.adrian.colegio.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.servicio.interfaces.IMatriculacionesService;

@RestController
@RequestMapping("/v2")
public class MatriculacionesRestControllerV2 {

	@Autowired
	private IMatriculacionesService matriculacionService;

	@PostMapping("/matriculaciones")
	public ResponseEntity<String> insertarMatriculacion(
			@RequestBody MatriculacionDTO matriculacion) {
		matriculacionService.insertarMatriculacion(matriculacion.getIdAlumno(), matriculacion.getIdAsignatura(), matriculacion.getFecha(), matriculacion.getTasa());
		return new ResponseEntity<>("Inserción correcta! ", HttpStatus.OK);
	}
	
	@GetMapping("/matriculaciones")
	public Iterable<MatriculacionDTO> listarTodosMatriculacions() {
	    return matriculacionService.obtenerMatriculacionesPorFiltros(null,null,null,null);
	}
	
	@GetMapping("/matriculaciones/{id}")
	public MatriculacionDTO buscarMatriculacionPorId(
			@PathVariable("id") Integer id){
	    return matriculacionService.obtenerMatriculacionPorId(id);
	}
	
	@GetMapping(value = "/matriculaciones", params = { "nombreAsignatura", "nombreAlumno", "fecha", "activo" })
	public List<MatriculacionDTO> listarMatriculacionsPorIdNombre(
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo) {
		
			if(fecha == "")
				fecha = "01-01-0001";
			
		return matriculacionService.obtenerMatriculacionesPorFiltros(nombreAlumno, nombreAsignatura, fecha, activo);
	}
	
	@PutMapping("/matriculaciones/{id}")
	public ResponseEntity<?> actualizarMatriculacion(
			@PathVariable Integer id, 
			@RequestBody MatriculacionDTO matriculacion) {

		if (!id.equals(matriculacion.getId())) {
			return ResponseEntity.badRequest().body("El ID de la URL no coincide con el del matriculacion");
		}

		if (matriculacionService.obtenerMatriculacionPorId(matriculacion.getId()) == null) {
			return ResponseEntity.notFound().build(); 
		}

		matriculacionService.actualizarMatriculacion(matriculacion.getId(), matriculacion.getIdAlumno(), matriculacion.getIdAsignatura(), matriculacion.getFecha(), matriculacion.getTasa());
		MatriculacionDTO actualizada = matriculacionService.obtenerMatriculacionPorId(matriculacion.getId());
		return ResponseEntity.ok(actualizada);
	}
	

	// Borrar matriculaciones
	@DeleteMapping("/matriculaciones/{id}")
	public ResponseEntity<?> borrarMatriculacion(
			@PathVariable Integer id) {

		if (buscarMatriculacionPorId(id) == null) {
			return ResponseEntity.notFound().build();
		}
		matriculacionService.borrarMatriculacion(id);
		return new ResponseEntity<String>("Borrado correcto!", HttpStatus.OK);
	}

}
