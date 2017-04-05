
package servicios.rest.co.ws.serviciosrest.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import servicios.rest.co.ws.serviciosrest.model.Partes;
import servicios.rest.co.ws.serviciosrest.util.HibernateUtil;


public class PartesDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public Partes getPartesPorCodigo(String codigo){
        Partes partes = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            partes = (Partes) session.createQuery("from partes p where p.codigo = :CODIGO").setParameter("CODIGO", codigo).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return partes;
    }
    public List<Partes> getListadoPartes(){
        List<Partes> partes = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            partes = session.createQuery("from partes p").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return partes;
    }
    public boolean savePartes(Partes partes){
        Session session = null;
        boolean hasErrors = false;
        try {
            session= sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(partes);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            hasErrors= true;
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return hasErrors;
    }
}
