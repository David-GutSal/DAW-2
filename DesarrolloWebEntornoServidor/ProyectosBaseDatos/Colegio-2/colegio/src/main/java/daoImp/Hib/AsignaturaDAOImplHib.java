package daoImp.Hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.IAsignaturasDAO;
import dto.AsignaturaDTO;
import entities.AsignaturaEntity;
import utils.DBUtils;

public class AsignaturaDAOImplHib implements IAsignaturasDAO{

	@Override
	public ArrayList<AsignaturaDTO> obtenerTodasAsignaturas() {
		String hql = "FROM AsignaturaEntity";
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		Query<AsignaturaDTO> query = s.createQuery(hql, AsignaturaDTO.class);
		ArrayList<AsignaturaDTO> lista = (ArrayList<AsignaturaDTO>) query.getResultList();

		s.close();
		return lista;
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(String id, String nombre, String curso, String tasa,
			int activo) {
		if(tasa == null) {
			tasa = "0.0";
		}
		String jpq = "SELECT new dto.AsignaturaDTO (a.id, a.nombre, a.curso, a.tasa, a.activo)"
				+ " FROM AsignaturaEntity a "
				+ " WHERE a.id LIKE :id "
				+ " AND a.nombre LIKE :nombre "
				+ " AND a.curso LIKE :curso "
				+ " AND a.tasa >= :tasa "
				+ " AND a.activo = :activo ";
				SessionFactory factory = DBUtils.creadorSessionFactory();
				Session s = factory.getCurrentSession();
				s.beginTransaction();

		Query<AsignaturaDTO> query = s.createQuery(jpq, AsignaturaDTO.class)
				.setParameter("id", "%" + id + "%")
				.setParameter("nombre", "%" + nombre + "%")
				.setParameter("curso", "%" + curso + "%")
				.setParameter("tasa", Double.parseDouble(tasa))
				.setParameter("activo", Integer.valueOf(activo));
		List<AsignaturaDTO> lista = query.getResultList();
		s.close();
		return new ArrayList<>(lista);
	}

	@Override
	public int insertarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		AsignaturaEntity a = new AsignaturaEntity(Integer.parseInt(id), nombre, curso, Double.valueOf(tasa), activo);
		Integer idPk = (Integer) s.save(a);
		s.getTransaction().commit();
		s.close();
		return idPk;
	}

	@Override
	public int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		AsignaturaEntity a = new AsignaturaEntity(Integer.parseInt(id), nombre, curso, Double.valueOf(tasa), activo);
		s.update(a);
		s.getTransaction().commit();
		s.close();
		return a.getId();
	}

	@Override
	public int borrarAsignatura(String id) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		AsignaturaEntity a = s.get(AsignaturaEntity.class, Integer.parseInt(id));
		a.setActivo(0);
		s.update(a);
		s.getTransaction().commit();
		s.close();
		return a.getId();
	}

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		// TODO Auto-generated method stub
		return 0;
	}



}
