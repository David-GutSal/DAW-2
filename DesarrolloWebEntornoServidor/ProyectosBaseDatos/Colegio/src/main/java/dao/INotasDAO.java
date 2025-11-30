package dao;

import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasDAO {

	ArrayList<NotasDTO> obtenerTodasNotas();

	int insertarNota(String id, String id_alumno, String id_asignatura, String nota);

	ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String nombre, String idasignatura, String nota, String fecha, String activo);

	int borrarNota(String id, String asignatura, String nota, String fecha);

	ArrayList<NotasDTO> obtenerNotasFiltradas(String nombre, String asignatura, String fecha);

	int actualizarNota(String id, String id_alumno, String id_asignatura, String nota, String fecha);

}
