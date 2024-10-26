/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import POJOs.Categorias;

/**
 *
 * @author 20041
 */
public class ProductosTabla {
     private Integer idProducto;
     private Categorias categorias;
     private Integer idCategoria;
     private String nombreProducto;
     private String descripcionProducto;
     private float existencia;
     private float precioCosto;
     private float precioVenta;

    public ProductosTabla(Integer idProducto, Categorias categorias, String nombreProducto, String descripcionProducto, float existencia, float precioCosto, float precioVenta) {
        this.idProducto = idProducto;
        this.categorias = categorias;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.existencia = existencia;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
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
     * @return the categorias
     */
    public Categorias getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcionProducto
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * @param descripcionProducto the descripcionProducto to set
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    /**
     * @return the existencia
     */
    public float getExistencia() {
        return existencia;
    }

    /**
     * @param existencia the existencia to set
     */
    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }

    /**
     * @return the precioCosto
     */
    public float getPrecioCosto() {
        return precioCosto;
    }

    /**
     * @param precioCosto the precioCosto to set
     */
    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    /**
     * @return the precioVenta
     */
    public float getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the idCategoria
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
     
}
