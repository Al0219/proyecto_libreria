/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Proveedores;
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
public class CRUDProveedores {
    public static List<Proveedores>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<Proveedores> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Proveedores.class);
            criteria.add(Restrictions.eq("estadoProveedor",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("nitProveedor"))
            .add(Projections.property("nombreProveedor"))
            .add(Projections.property("direccionProveedor"))
            .add(Projections.property("telefonoProveedor"))
            );
            criteria.addOrder(Order.desc("nitProveedor"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(String nombreProveedor, String direccionProveedor, String telefonoProveedor){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Proveedores.class);
        criteria.add(Restrictions.eq("telefonoProveedor", telefonoProveedor));
        Proveedores insert = (Proveedores)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Proveedores();
               insert.setEstadoProveedor(true);
               insert.setNombreProveedor(nombreProveedor);
               insert.setDireccionProveedor(direccionProveedor);
               insert.setTelefonoProveedor(telefonoProveedor);
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
    
    public static boolean actualizar(Integer nitProveedor, String nombreProveedor, String direccionProveedor, String telefonoProveedor){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Proveedores.class);
        criteria.add(Restrictions.eq("nitProveedor", nitProveedor));
        Proveedores insert = (Proveedores)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               insert.setNombreProveedor(nombreProveedor);
               insert.setDireccionProveedor(direccionProveedor);
               insert.setTelefonoProveedor(telefonoProveedor);
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
    
    public static boolean anular(Integer nitProveedor){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Proveedores.class);
        criteria.add(Restrictions.eq("nitProveedor", nitProveedor));
        Proveedores anular = (Proveedores)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(anular != null){
               anular.setEstadoProveedor(false);
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
