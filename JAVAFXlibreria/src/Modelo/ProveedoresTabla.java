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
     private boolean estadoProveedor;
     private String nombreProveedor;
     private String direccionProveedor;
     private String telefonoProveedor;

    public ProveedoresTabla(Integer nitProveedor, String nombreProveedor, String direccionProveedor, String telefonoProveedor) {
        this.nitProveedor = nitProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
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
     * @return the estadoProveedor
     */
    public boolean isEstadoProveedor() {
        return estadoProveedor;
    }

    /**
     * @param estadoProveedor the estadoProveedor to set
     */
    public void setEstadoProveedor(boolean estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
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
     * @return the telefonoProveedor
     */
    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    /**
     * @param telefonoProveedor the telefonoProveedor to set
     */
    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }
     
     
}
