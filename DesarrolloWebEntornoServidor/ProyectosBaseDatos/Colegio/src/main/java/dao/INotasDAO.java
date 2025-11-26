package dao;

import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasDAO {

	ArrayList<NotasDTO> obtenerTodasNotas();

	int insertarNota(String id, String id_alumno, String id_asignatura, String nota, String fecha);

	ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String nombre, String idasignatura, String nota, String fecha, String activo);

	int actualizarNota(String id, String id_alumno, String id_asignatura, String nota, String fecha);

	int borrarNota(String id);

}
