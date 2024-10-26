package POJOs;
// Generated 25/10/2024 09:33:04 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private Integer nitCliente;
     private boolean estadoCliente;
     private String nombreCliente;
     private String direccionCliente;
     private String telefonoCliente;
     private Set<Ventas> ventases = new HashSet<Ventas>(0);

    public Clientes() {
    }

	
    public Clientes(boolean estadoCliente, String nombreCliente, String direccionCliente, String telefonoCliente) {
        this.estadoCliente = estadoCliente;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
    }
    public Clientes(boolean estadoCliente, String nombreCliente, String direccionCliente, String telefonoCliente, Set<Ventas> ventases) {
       this.estadoCliente = estadoCliente;
       this.nombreCliente = nombreCliente;
       this.direccionCliente = direccionCliente;
       this.telefonoCliente = telefonoCliente;
       this.ventases = ventases;
    }
   
    public Integer getNitCliente() {
        return this.nitCliente;
    }
    
    public void setNitCliente(Integer nitCliente) {
        this.nitCliente = nitCliente;
    }
    public boolean isEstadoCliente() {
        return this.estadoCliente;
    }
    
    public void setEstadoCliente(boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    public String getNombreCliente() {
        return this.nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getDireccionCliente() {
        return this.direccionCliente;
    }
    
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    public String getTelefonoCliente() {
        return this.telefonoCliente;
    }
    
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    public Set<Ventas> getVentases() {
        return this.ventases;
    }
    
    public void setVentases(Set<Ventas> ventases) {
        this.ventases = ventases;
    }




}


