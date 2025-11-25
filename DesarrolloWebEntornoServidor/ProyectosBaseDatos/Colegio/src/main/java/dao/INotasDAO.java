package dao;

import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasDAO {

	ArrayList<NotasDTO> obtenerTodasNotas();

	int insertarNota(String id, String id_alumno, String id_asignatura, int nota, String fecha);

	ArrayList<NotasDTO> obtenerNotasFiltradas(String nota, String fecha);

	int actualizarNota(String id, String id_alumno, String id_asignatura, int nota, String fecha);

	int borrarNota(String id);

}
