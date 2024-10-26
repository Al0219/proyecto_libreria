/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;
import POJOs.Categorias;
import POJOs.Productos;
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

public class CRUDProductos {
    Categorias categorias = new Categorias();
    public static List<Productos>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<Productos> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Productos.class);
            criteria.createAlias("categorias","c");
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idProducto"))
            .add(Projections.property("c.idCategoria"))
            .add(Projections.property("nombreProducto"))
            .add(Projections.property("descripcionProducto"))
            .add(Projections.property("existencia"))
            .add(Projections.property("precioCosto"))
            .add(Projections.property("precioVenta"))
            );
            criteria.addOrder(Order.desc("idProducto"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(Integer idCategoria, String nombreProducto, String descripcionProducto, Float existencia, Float precioCosto, Float precioVenta){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Productos.class);
        criteria.add(Restrictions.eq("nombreProducto", nombreProducto));
        Productos insert = (Productos)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new Productos();
               Categorias Categorias= new Categorias();
               Categorias.setIdCategoria(idCategoria);
               insert.setCategorias(Categorias);
               insert.setNombreProducto(nombreProducto);
               insert.setDescripcionProducto(descripcionProducto);
               insert.setExistencia(existencia);
               insert.setPrecioCosto(precioCosto);
               insert.setPrecioVenta(precioVenta);
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
    
    public static boolean actualizar(Integer idProducto, Integer idCategoria, String nombreProducto, String descripcionProducto, Float existencia, Float precioCosto, Float precioVenta){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Productos.class);
        criteria.add(Restrictions.eq("idProducto", idProducto));
        Productos insert = (Productos)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               Categorias Categorias= new Categorias();
               Categorias.setIdCategoria(idCategoria);
               insert.setCategorias(Categorias);
               insert.setNombreProducto(nombreProducto);
               insert.setDescripcionProducto(descripcionProducto);
               insert.setExistencia(existencia);
               insert.setPrecioCosto(precioCosto);
               insert.setPrecioVenta(precioVenta);
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
