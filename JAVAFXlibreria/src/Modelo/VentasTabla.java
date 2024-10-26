/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 20041
 */
public class VentasTabla {
    
    private Integer numeroVenta;
    private Integer nitCliente;
    private Date fechaVenta;
    private Integer idUsuario;

    public VentasTabla(Integer numeroVenta, Integer nitCliente, Date fechaVenta, Integer idUsuario) {
        this.numeroVenta = numeroVenta;
        this.nitCliente = nitCliente;
        this.fechaVenta = fechaVenta;
        this.idUsuario = idUsuario;
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
     * @return the nitCliente
     */
    public Integer getNitCliente() {
        return nitCliente;
    }

    /**
     * @param nitCliente the nitCliente to set
     */
    public void setNitCliente(Integer nitCliente) {
        this.nitCliente = nitCliente;
    }

    /**
     * @return the fechaVenta
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(String fechaVenta1) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
}
