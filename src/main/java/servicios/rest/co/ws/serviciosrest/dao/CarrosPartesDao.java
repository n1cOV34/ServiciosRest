
package servicios.rest.co.ws.serviciosrest.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import servicios.rest.co.ws.serviciosrest.model.CarrosPartes;
import servicios.rest.co.ws.serviciosrest.util.HibernateUtil;


public class CarrosPartesDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public CarrosPartes getCarrosPartesPorCodigo(String carrospartesPK){
        CarrosPartes carrospartes = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            carrospartes = (CarrosPartes) session.createQuery("from carrospartes cp where cp.carrospartes = :CARROSPARTES").setParameter("CARROSPARTES", carrospartesPK).uniqueResult();
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
        return carrospartes;
    }
    public List<CarrosPartes> getListadoCarrosPartes(){
        List<CarrosPartes> carrospartes = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            carrospartes = session.createQuery("from carrospartes cp").list();
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
        return carrospartes;
    }
}
