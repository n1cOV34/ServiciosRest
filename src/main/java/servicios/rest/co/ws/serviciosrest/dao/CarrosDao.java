
package servicios.rest.co.ws.serviciosrest.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import servicios.rest.co.ws.serviciosrest.model.Carros;
import servicios.rest.co.ws.serviciosrest.util.HibernateUtil;

public class CarrosDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public Carros getCarrosPorPlaca(String placa){
        Carros carros = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            carros = (Carros) session.createQuery("from Carros c where c.placa = :PLACA").setParameter("PLACA", placa).uniqueResult();
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
        return carros;
    }
    public List<Carros> getListadoCarros(){
        List<Carros> carros = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            carros = session.createQuery("from Carros c").list();
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
        return carros;
    }
    
    public boolean saveCarros(Carros carros){
        Session session = null;
        boolean hasErrors = false;
        try {
            session= sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(carros);
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
