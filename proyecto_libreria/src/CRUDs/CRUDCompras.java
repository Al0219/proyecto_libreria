/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Compras;
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
public class CRUDCompras {
    public static List<Compras>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<Compras> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Compras.class);
            criteria.add(Restrictions.eq("estadoCompra",true));
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("numeroCompra"))
            .add(Projections.property("proveedores"))
            .add(Projections.property("usuarios"))
            .add(Projections.property("fechaCompra"))
            );
            criteria.addOrder(Order.desc("numeroCompra"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(String nombreCompra, String cargoCompra, String contraseniaCompra){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compras.class);
        criteria.add(Restrictions.eq("contraseniaCompra", contraseniaCompra));
        Compras insert = (Compras)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Compras();
               insert.setEstadoCompra(true);
               insert.setNombreCompra(nombreCompra);
               insert.setCargoCompra(cargoCompra);
               insert.setContraseniaCompra(contraseniaCompra);
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
    
    public static boolean actualizar(Integer idCompra, String nombreCompra, String cargoCompra, String contraseniaCompra){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compras.class);
        criteria.add(Restrictions.eq("idCompra", idCompra));
        Compras insert = (Compras)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               insert.setNombreCompra(nombreCompra);
               insert.setCargoCompra(cargoCompra);
               insert.setContraseniaCompra(contraseniaCompra);
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
    
    public static boolean anular(Integer idCompra){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compras.class);
        criteria.add(Restrictions.eq("idCompra", idCompra));
        Compras anular = (Compras)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(anular != null){
               anular.setEstadoCompra(false);
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
