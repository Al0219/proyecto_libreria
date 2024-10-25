/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.DetalleCompra;
import POJOs.Compras;
import POJOs.Productos;
import CRUDs.CRUDCompras;
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
public class CRUDDetalleCompra {
    public static List<DetalleCompra>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<DetalleCompra> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(DetalleCompra.class);
            criteria.createAlias("Compras", "c");
            criteria.createAlias("Productos","p");
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("numeroDocumento"))
            .add(Projections.property("p.numeroCompra"))
            .add(Projections.property("p.idProducto"))
            .add(Projections.property("cantidad"))
            .add(Projections.property("precioUnitario"))
            .add(Projections.property("totalCompra"))
            );
            criteria.addOrder(Order.desc("numeroDocumento"));
            lista = criteria.list();
        }catch(Exception e){
            System.out.println("error: "+e);
        }finally{
            session.getTransaction().commit();
        }
        return lista;
    }

    public static boolean crear(Integer numeroDocumento, Integer numeroCompra, Integer idProducto, Float cantidad, Float precioUnitario){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(DetalleCompra.class);
        criteria.add(Restrictions.eq("numeroDocumento", numeroDocumento));
        DetalleCompra insert = (DetalleCompra)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new DetalleCompra();
               CRUDCompras compras = new CRUDCompras();
               compras.getClass();
               insert.setNumeroDocumento(numeroDocumento);
               Compras compra = new Compras();
               compra.setNumeroCompra(numeroCompra);
               insert.setCompras(compra);
               Productos producto = new Productos();
               producto.setIdProducto(idProducto);
               insert.setProductos(producto);
               insert.setCantidad(cantidad);
               producto.setExistencia(producto.getExistencia()+cantidad);
               insert.setPrecioUnitario(precioUnitario);
               Float totalCompra = cantidad*precioUnitario;
               insert.setTotalCompra(totalCompra);
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
    
    public static boolean actualizar(Integer numeroDocumento, Integer numeroCompra, Integer idProducto, Float cantidad, Float precioUnitario){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(DetalleCompra.class);
        criteria.add(Restrictions.eq("numeroDocumento", numeroDocumento));
        DetalleCompra insert = (DetalleCompra)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               Compras compra = new Compras();
               compra.setNumeroCompra(numeroCompra);
               insert.setCompras(compra);
               Productos producto = new Productos();
               producto.setIdProducto(idProducto);
               insert.setProductos(producto);
               insert.setCantidad(cantidad);
               producto.setExistencia(producto.getExistencia()-cantidad);
               insert.setPrecioUnitario(precioUnitario);
               Float totalCompra = cantidad*precioUnitario;
               insert.setTotalCompra(totalCompra);
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
