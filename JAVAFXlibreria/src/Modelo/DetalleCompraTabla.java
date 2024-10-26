/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import POJOs.Compras;
import POJOs.Productos;

/**
 *
 * @author 20041
 */
public class DetalleCompraTabla {
    private Integer numeroCompra, idProducto;
    private Integer numeroDocumento;
     private Compras compras;
     private Productos productos;
     private float cantidad;
     private float precioUnitario;
     private float totalCompra;

    public DetalleCompraTabla(Integer numeroDocumento, Integer numeroCompra, Integer idProducto, float cantidad, float precioUnitario) {
        this.numeroDocumento = numeroDocumento;
        this.numeroCompra = numeroCompra;
        this.compras = new Compras(numeroCompra);
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalCompra = cantidad*precioUnitario;
    }

    /**
     * @return the numeroDocumento
     */
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the compras
     */
    public Compras getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(Compras compras) {
        this.compras = compras;
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
     * @return the totalCompra
     */
    public float getTotalCompra() {
        return totalCompra;
    }

    /**
     * @param totalCompra the totalCompra to set
     */
    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    /**
     * @return the numeroCompra
     */
    public int getNumeroCompra() {
        return numeroCompra;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }
     
     
}
