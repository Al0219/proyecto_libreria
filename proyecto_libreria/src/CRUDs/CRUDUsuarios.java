/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Usuarios;
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
public class CRUDUsuarios{
    public static List<Usuarios>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<Usuarios> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Usuarios.class);
            criteria.add(Restrictions.eq("estadoUsuario",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idUsuario"))
            .add(Projections.property("nombreUsuario"))
            .add(Projections.property("cargoUsuario"))
            .add(Projections.property("contraseniaUsuario"))
            );
            criteria.addOrder(Order.desc("idUsuario"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(String nombreUsuario, String cargoUsuario, String contraseniaUsuario){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("contraseniaUsuario", contraseniaUsuario));
        Usuarios insert = (Usuarios)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Usuarios();
               insert.setEstadoUsuario(true);
               insert.setNombreUsuario(nombreUsuario);
               insert.setCargoUsuario(cargoUsuario);
               insert.setContraseniaUsuario(contraseniaUsuario);
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
    
    public static boolean actualizar(Integer idUsuario, String nombreUsuario, String cargoUsuario, String contraseniaUsuario){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("idUsuario", idUsuario));
        Usuarios insert = (Usuarios)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               insert.setNombreUsuario(nombreUsuario);
               insert.setCargoUsuario(cargoUsuario);
               insert.setContraseniaUsuario(contraseniaUsuario);
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
    
    public static boolean anular(Integer idUsuario){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("idUsuario", idUsuario));
        Usuarios anular = (Usuarios)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(anular != null){
               anular.setEstadoUsuario(false);
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
