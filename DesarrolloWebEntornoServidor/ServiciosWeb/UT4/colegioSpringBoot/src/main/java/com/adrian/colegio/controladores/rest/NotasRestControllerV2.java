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

import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.servicio.interfaces.INotasService;

@RestController
@RequestMapping("/v2")
public class NotasRestControllerV2 {

	@Autowired
	private INotasService notaService;

	@PostMapping("/notas")
	public ResponseEntity<String> insertarNota(
			@RequestBody NotaDTO nota) {
		notaService.insertarNota(nota.getIdAlumno(), nota.getIdAsignatura(), Double.parseDouble(nota.getNota()),nota.getFecha());
		return new ResponseEntity<>("Inserción correcta! ", HttpStatus.OK);
	}
	
	@GetMapping("/notas")
	public Iterable<NotaDTO> listarTodosNotas() {
	    return notaService.obtenerNotasPorFiltros(null,null,null,null,null,null);
	}
	
	@GetMapping("/notas/{id}")
	public NotaDTO buscarNotaPorId(
			@PathVariable("id") Integer id){
	    return notaService.obtenerNotaPorId(id);
	}
	
	@GetMapping(value = "/notas", params = { "idAlumno", "nombreAlumno", "nombreAsignatura", "nota", "fecha", "activo" })
	public List<NotaDTO> listarNotasPorIdNombre(
			@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo) {
			if(fecha == "")
				fecha = "01-01-0001";
			
		return notaService.obtenerNotasPorFiltros(idAlumno, nombreAlumno, nombreAsignatura, nota, fecha, activo);
	}
	
	@PutMapping("/notas/{id}")
	public ResponseEntity<?> actualizarNota(
			@PathVariable Integer id, 
			@RequestBody NotaDTO nota) {

		if (!id.equals(nota.getId())) {
			return ResponseEntity.badRequest().body("El ID de la URL no coincide con el del nota");
		}

		if (notaService.obtenerNotaPorId(nota.getId()) == null) {
			return ResponseEntity.notFound().build(); 
		}

		notaService.actualizarNota(nota.getId(), nota.getIdAlumno(), nota.getIdAsignatura(), Double.parseDouble(nota.getNota()), nota.getFecha());
		NotaDTO actualizada = notaService.obtenerNotaPorId(nota.getId());
		return ResponseEntity.ok(actualizada);
	}
	

	// Borrar notas
	@DeleteMapping("/notas/{id}")
	public ResponseEntity<?> borrarNota(
			@PathVariable Integer id) {

		if (buscarNotaPorId(id) == null) {
			return ResponseEntity.notFound().build();
		}
		notaService.borrarNota(id);
		return new ResponseEntity<String>("Borrado correcto!", HttpStatus.OK);
	}

}
