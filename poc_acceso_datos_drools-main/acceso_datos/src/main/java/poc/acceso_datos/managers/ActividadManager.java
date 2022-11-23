package poc.acceso_datos.managers;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import poc.acceso_datos.utils.HikariCP;
import poc.acceso_datos.entities.Actividad;

public class ActividadManager {
   public List listaActividades(long nroEmpresa) {
      Session session = HikariCP.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Query query = session.createQuery("from Actividad where nroEmpresa=:nroEmpresa");
      query.setParameter("nroEmpresa", nroEmpresa);
      List<Actividad> list = query.getResultList();

      session.getTransaction().commit();

      return list;
   }
}