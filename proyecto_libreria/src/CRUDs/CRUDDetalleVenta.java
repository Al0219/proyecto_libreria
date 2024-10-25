/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Ventas;
import POJOs.DetalleVenta;
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
public class CRUDDetalleVenta {
    public static List<DetalleVenta>universo(){
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        List<DetalleVenta> lista=null;
        try{
            session.beginTransaction();
            Criteria criteria = session.createCriteria(DetalleVenta.class);
            criteria.createAlias("Ventas", "c");
            criteria.createAlias("Productos","p");
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("numeroDocumento"))
            .add(Projections.property("p.numeroVenta"))
            .add(Projections.property("p.idProducto"))
            .add(Projections.property("cantidad"))
            .add(Projections.property("precioUnitario"))
            .add(Projections.property("totalVenta"))
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

    public static boolean crear(Integer numeroDocumento, Integer numeroVenta, Integer idProducto, Float cantidad){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(DetalleVenta.class);
        criteria.add(Restrictions.eq("numeroDocumento", numeroDocumento));
        DetalleVenta insert = (DetalleVenta)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert ==null){
               insert=new DetalleVenta();
               insert.setNumeroDocumento(numeroDocumento);
               Ventas Venta = new Ventas();
               CRUDVentas Ventas = new CRUDVentas();
               Ventas.getClass();
               Venta.setNumeroVenta(numeroVenta);
               insert.setVentas(Venta);
               Productos producto = new Productos();
               producto.setIdProducto(idProducto);
               insert.setProductos(producto);
               insert.setCantidad(cantidad);
               producto.setExistencia(producto.getExistencia()-cantidad);
               Float precioUnitario = producto.getPrecioVenta();
               insert.setPrecioUnitario(precioUnitario);
               Float totalVenta = cantidad*precioUnitario;
               insert.setTotalVenta(totalVenta);
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
    
    public static boolean actualizar(Integer numeroDocumento, Integer numeroVenta, Integer idProducto, Float cantidad){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(DetalleVenta.class);
        criteria.add(Restrictions.eq("numeroDocumento", numeroDocumento));
        DetalleVenta insert = (DetalleVenta)criteria.uniqueResult();
        Transaction transaction=null;
        try{
           transaction = session.beginTransaction();
           if(insert != null){
               Ventas Venta = new Ventas();
               Venta.setNumeroVenta(numeroVenta);
               insert.setVentas(Venta);
               Productos producto = new Productos();
               producto.setIdProducto(idProducto);
               insert.setProductos(producto);
               insert.setCantidad(cantidad);
               producto.setExistencia(producto.getExistencia()-cantidad);
               Float precioUnitario = producto.getPrecioVenta();
               insert.setPrecioUnitario(precioUnitario);
               Float totalVenta = cantidad*precioUnitario;
               insert.setTotalVenta(totalVenta);
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
