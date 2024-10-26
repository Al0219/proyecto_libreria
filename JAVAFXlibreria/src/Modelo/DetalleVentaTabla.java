/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import POJOs.Productos;
import POJOs.Ventas;

/**
 *
 * @author 20041
 */
public class DetalleVentaTabla {
    private Integer numeroVenta, idProducto;
    private Integer numeroDocumento;
     private Productos productos;
     private Ventas ventas;
     private float cantidad;
     private float precioUnitario;
     private float totalVenta;

    public DetalleVentaTabla(Integer numeroVenta, Integer idProducto, Integer numeroDocumento, float cantidad) {
        this.numeroVenta = numeroVenta;
        this.idProducto = idProducto;
        this.numeroDocumento = numeroDocumento;
        this.cantidad = cantidad;
    }

    /**
     * @return the numeroVenta
     */
    public Integer getNumeroVenta() {
        return numeroVenta;
    }

    /**
     * @param numeroVenta the numeroVenta to set
     */
    public void setNumeroVenta(Integer numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    /**
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the numeroDocumento
     */
    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the productos
     */
    public Productos getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    /**
     * @return the ventas
     */
    public Ventas getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precioUnitario
     */
    public float getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the totalVenta
     */
    public float getTotalVenta() {
        return totalVenta;
    }

    /**
     * @param totalVenta the totalVenta to set
     */
    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }
     
}
