/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 20041
 */
public class ClientesTabla {
    
    private Integer nitCliente;
     private boolean estadoCliente;
     private String nombreCliente;
     private String direccionCliente;
     private String telefonoCliente;

    public ClientesTabla(Integer nitCliente, String nombreCliente, String direccionCliente, String telefonoCliente) {
        this.nitCliente = nitCliente;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
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
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the direccionCliente
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * @param direccionCliente the direccionCliente to set
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    /**
     * @return the telefonCliente
     */
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    /**
     * @param telefonCliente the telefonCliente to set
     */
    public void setTelefonoCliente(Integer telefonCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
}



