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
    
    private Integer nitPersona;
    private String nombreCliente;
    private String direccionCliente;
    private Integer telefonCliente;

    public ClientesTabla(Integer nitPersona, String nombreCliente, String direccionCliente, Integer telefonCliente) {
        this.nitPersona = nitPersona;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefonCliente = telefonCliente;
    }
    
    
    

    /**
     * @return the nitPersona
     */
    public Integer getNitPersona() {
        return nitPersona;
    }

    /**
     * @param nitPersona the nitPersona to set
     */
    public void setNitPersona(Integer nitPersona) {
        this.nitPersona = nitPersona;
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
    public Integer getTelefonCliente() {
        return telefonCliente;
    }

    /**
     * @param telefonCliente the telefonCliente to set
     */
    public void setTelefonCliente(Integer telefonCliente) {
        this.telefonCliente = telefonCliente;
    }
    
}



