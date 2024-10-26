/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Ventas;
import POJOs.Clientes;
import POJOs.Clientes;
import POJOs.Usuarios;
import java.util.Date;
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
public class CRUDVentas {
    public static List<Ventas>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<Ventas> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Ventas.class);
            criteria.createAlias("Clientes","c");
            criteria.createAlias("Usuarios","u");
            criteria.add(Restrictions.eq("estadoVenta",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("numeroVenta"))
            .add(Projections.property("c.nitCliente"))
            .add(Projections.property("u.idUsuario"))
            .add(Projections.property("fechaVenta"))
            );
            criteria.addOrder(Order.desc("numeroVenta"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(Integer nitCliente, Integer idUsuario, Date fechaVenta){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Ventas.class);
        Ventas insert = (Ventas)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Ventas();
               Clientes Clientes = new Clientes();
               Clientes.setNitCliente(nitCliente);
               insert.setClientes(Clientes);
               Usuarios usuarios  = new Usuarios();
               insert.setEstadoVenta(true);
               usuarios.setIdUsuario(idUsuario);
               insert.setUsuarios(usuarios);
               insert.setFechaVenta(fechaVenta);
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
    
    
    public static boolean actualizar(Integer numeroVenta, Date fecha, Clientes clientes, Usuarios usuarios){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Ventas.class);
        criteria.add(Restrictions.eq("numeroVenta", numeroVenta));
        Ventas insert = (Ventas)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               insert.setFechaVenta(fecha);
               insert.setClientes(clientes);
               insert.setUsuarios(usuarios);
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
    
    
    public static boolean anular(Integer numeroVenta){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Ventas.class);
        criteria.add(Restrictions.eq("numeroVenta", numeroVenta));
        Ventas anular = (Ventas)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(anular != null){
               anular.setEstadoVenta(false);
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
