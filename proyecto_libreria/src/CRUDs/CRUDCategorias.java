/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Categorias;
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
public class CRUDCategorias {
    public static List<Categorias>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<Categorias> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Categorias.class);
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idCategoria"))
            .add(Projections.property("nombreCategoria"))
            .add(Projections.property("descripçionCategoria"))
            );
            criteria.addOrder(Order.desc("idCategoria"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(String nombreCategoria, String descripcionCategoria){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Categorias.class);
        criteria.add(Restrictions.eq("nombreCategoria", nombreCategoria));
        Categorias insert = (Categorias)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Categorias();
               insert.setNombreCategoria(nombreCategoria);
               insert.setDescripcionCategoria(descripcionCategoria);
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
    
    public static boolean actualizar(Integer idCategoria, String nombreCategoria, String descripcionCategoria){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Categorias.class);
        criteria.add(Restrictions.eq("idCategoria", idCategoria));
        Categorias insert = (Categorias)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               insert.setNombreCategoria(nombreCategoria);
               insert.setDescripcionCategoria(descripcionCategoria);
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
}
