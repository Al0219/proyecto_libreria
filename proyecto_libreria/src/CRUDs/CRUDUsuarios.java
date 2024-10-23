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
            criteria.add(Restrictions.eq("estado",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idUsuarios"))
            .add(Projections.property("nombreUsuarios"))
            .add(Projections.property("cargousuarios"))
            .add(Projections.property("contraseniaUsuario"))
            );
            criteria.addOrder(Order.desc("idUsuarios"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }
    
    public static boolean crear(String nombreUsuarios, String cargoUsuarios, String contraseniaUsuarios){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("contraseniaIsuarios", contraseniaUsuarios));
        Usuarios insert = (Usuarios)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Usuarios();
               insert.setEstadoUsuario(true);
               insert.setNombreUsuario(nombreUsuarios);
               insert.setCargoUsuario(cargoUsuarios);
               insert.setContraseniaUsuario(contraseniaUsuarios);
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
    
    public static boolean actualizar(Integer idUsuarios, String nombreUsuarios, String cargoUsuarios, String contraseniaUsuarios){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("idUsuarios", idUsuarios));
        Usuarios insert = (Usuarios)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               insert.setNombreUsuario(nombreUsuarios);
               insert.setCargoUsuario(cargoUsuarios);
               insert.setContraseniaUsuario(contraseniaUsuarios);
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
    
    public static boolean anular(Integer idUsuarios){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("idUsuarios", idUsuarios));
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
