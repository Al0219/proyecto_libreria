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
public class ProveedoresTabla {
    
    private Integer nitProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private Integer telefonProveedor;

    public ProveedoresTabla(Integer nitProveedor, String nombreProveedor, String direccionProveedor, Integer telefonProveedor) {
        this.nitProveedor = nitProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.telefonProveedor = telefonProveedor;
    }

    /**
     * @return the nitProveedor
     */
    public Integer getNitProveedor() {
        return nitProveedor;
    }

    /**
     * @param nitProveedor the nitProveedor to set
     */
    public void setNitProveedor(Integer nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    /**
     * @return the nombreProveedor
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * @param nombreProveedor the nombreProveedor to set
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * @return the direccionProveedor
     */
    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    /**
     * @param direccionProveedor the direccionProveedor to set
     */
    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    /**
     * @return the telefonProveedor
     */
    public Integer getTelefonProveedor() {
        return telefonProveedor;
    }

    /**
     * @param telefonProveedor the telefonProveedor to set
     */
    public void setTelefonProveedor(Integer telefonProveedor) {
        this.telefonProveedor = telefonProveedor;
    }
  
}



