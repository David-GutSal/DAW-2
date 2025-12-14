package daoImp.Hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.IMatriculacionesDAO;
import dto.MatriculacionDTO;
import entities.AlumnoEntity;
import entities.AsignaturaEntity;
import entities.CajaEntity;
import entities.MatriculacionEntity;
import utils.DBUtils;

public class MatriculacionDAOImplHib implements IMatriculacionesDAO {

    @Override
    public double obtenerTasaAsignatura(String idAsignatura) {
        String hql = "SELECT a.tasa FROM AsignaturaEntity a "
                   + "WHERE a.id = :id AND a.activo = 1";

        SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        Query<Double> query = s.createQuery(hql, Double.class)
                .setParameter("id", Integer.parseInt(idAsignatura));

        Double tasa = query.uniqueResult();
        s.close();

        return tasa != null ? tasa : 0.0;
    }

    @Override
    public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) {
        SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        AsignaturaEntity asignatura = s.get(AsignaturaEntity.class, Integer.parseInt(idAsignatura));
        AlumnoEntity alumno = s.get(AlumnoEntity.class, Integer.parseInt(idAlumno));
        
        MatriculacionEntity m = new MatriculacionEntity();
        m.setAsignatura(asignatura);
        m.setAlumnos(alumno);
        m.setFecha(fecha);
        m.setActivo(1);

        Integer idMatricula = (Integer) s.save(m);

        CajaEntity c = new CajaEntity();
        c.setMatricula(m);
        c.setImporte(Double.parseDouble(tasa));

        s.save(c);

        s.getTransaction().commit();
        s.close();

        return idMatricula;
    }

    @Override
    public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(
            String nombreAsignatura, String nombreAlumno, String fecha, int activo) {

        String hql = "SELECT new dto.MatriculacionDTO( "
                   + "m.id, a.id, a.nombre, al.id, al.nombre, m.fecha, m.activo, COALESCE(c.importe, 0)) "
                   + "FROM MatriculacionEntity m "
                   + "JOIN m.asignatura a "
                   + "JOIN m.alumnos al "
                   + "LEFT JOIN m.caja c "
                   + "WHERE a.nombre LIKE :asignatura "
                   + "AND al.nombre LIKE :alumno "
                   + "AND m.fecha >= :fecha "
                   + "AND m.activo = :activo";

        SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        Query<MatriculacionDTO> query = s.createQuery(hql, MatriculacionDTO.class)
                .setParameter("asignatura", "%" + nombreAsignatura + "%")
                .setParameter("alumno", "%" + nombreAlumno + "%")
                .setParameter("fecha", fecha)
                .setParameter("activo", activo);

        List<MatriculacionDTO> lista = query.getResultList();
        s.close();

        return new ArrayList<>(lista);
    }

    @Override
    public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(
            String nombreAsignatura, String nombreAlumno, int activo) {

    	String hql = "SELECT new dto.MatriculacionDTO( "
    	           + "m.id, a.id, a.nombre, al.id, al.nombre, m.fecha, m.activo, COALESCE(c.importe, 0)) "
    	           + "FROM MatriculacionEntity m "
    	           + "JOIN m.asignatura a "
    	           + "JOIN m.alumnos al "
    	           + "LEFT JOIN m.caja c "
    	           + "WHERE a.nombre LIKE :asignatura "
    	           + "AND al.nombre LIKE :alumno "
    	           + "AND m.activo = :activo";


        SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        Query<MatriculacionDTO> query = s.createQuery(hql, MatriculacionDTO.class)
                .setParameter("asignatura", "%" + nombreAsignatura + "%")
                .setParameter("alumno", "%" + nombreAlumno + "%")
                .setParameter("activo", activo);

        List<MatriculacionDTO> lista = query.getResultList();
        s.close();

        return new ArrayList<>(lista);
    }

    @Override
    public int actualizarMatriculacion(String id, String idAsignatura, String idAlumno, String fecha, String tasa) {
        SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        MatriculacionEntity m = s.get(MatriculacionEntity.class, Integer.parseInt(id));

        AsignaturaEntity asignatura = s.get(AsignaturaEntity.class, Integer.parseInt(idAsignatura));
        AlumnoEntity alumno = s.get(AlumnoEntity.class, Integer.parseInt(idAlumno));

        m.setAsignatura(asignatura);
        m.setAlumnos(alumno);
        m.setFecha(fecha);

        CajaEntity c = m.getCaja();
        c.setImporte(Double.parseDouble(tasa));

        s.getTransaction().commit();
        s.close();

        return m.getId();
    }

    @Override
    public int borrarMatriculacion(String id) {
        SessionFactory factory = DBUtils.creadorSessionFactory();
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        MatriculacionEntity m = s.get(MatriculacionEntity.class, Integer.parseInt(id));

        s.delete(m);

        s.getTransaction().commit();
        s.close();

        return m.getId();
    }
}
