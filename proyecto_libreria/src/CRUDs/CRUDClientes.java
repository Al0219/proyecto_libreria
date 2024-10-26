/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Clientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 20041
 */
public class CRUDClientes {
    public static List<Clientes>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<Clientes> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Clientes.class);
            criteria.add(Restrictions.eq("estadoCliente",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("nitCliente"))
            .add(Projections.property("nombreCliente"))
            .add(Projections.property("direccionCliente"))
            .add(Projections.property("telefonoCliente"))
            );
            criteria.addOrder(Order.desc("nitCliente"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(String nombreCliente, String direccionCliente, String telefonoCliente){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clientes.class);
        criteria.add(Restrictions.eq("telefonoCliente", telefonoCliente));
        Clientes insert = (Clientes)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Clientes();
               insert.setEstadoCliente(true);
               insert.setNombreCliente(nombreCliente);
               insert.setDireccionCliente(direccionCliente);
               insert.setTelefonoCliente(telefonoCliente);
               session.save(insert);
               flag=true;
           }
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally{
            session.close();
        }
        return flag;
    }
    
    public static boolean actualizar(Integer nitCliente, String nombreCliente, String direccionCliente, String telefonoCliente){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clientes.class);
        criteria.add(Restrictions.eq("nitCliente", nitCliente));
        Clientes insert = (Clientes)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               insert.setNombreCliente(nombreCliente);
               insert.setDireccionCliente(direccionCliente);
               insert.setTelefonoCliente(telefonoCliente);
               session.update(insert);
               flag=true;
           }
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally{
            session.close();
        }
        return flag;
    }
    
    public static boolean anular(Integer nitCliente){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clientes.class);
        criteria.add(Restrictions.eq("nitCliente", nitCliente));
        Clientes anular = (Clientes)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(anular != null){
               anular.setEstadoCliente(false);
               session.update(anular);
               flag=true;
           }
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally{
            session.close();
        }
        return flag;
    }
}
