package POJOs;
// Generated 21/10/2024 11:49:32 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private int nitCliente;
     private boolean estadoCliente;
     private String nombreCliente;
     private String direccionCliente;
     private String telefonoCliente;
     private Set<Ventas> ventases = new HashSet<Ventas>(0);

    public Clientes() {
    }

	
    public Clientes(int nitCliente, boolean estadoCliente, String nombreCliente, String direccionCliente, String telefonoCliente) {
        this.nitCliente = nitCliente;
        this.estadoCliente = estadoCliente;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
    }
    public Clientes(int nitCliente, boolean estadoCliente, String nombreCliente, String direccionCliente, String telefonoCliente, Set<Ventas> ventases) {
       this.nitCliente = nitCliente;
       this.estadoCliente = estadoCliente;
       this.nombreCliente = nombreCliente;
       this.direccionCliente = direccionCliente;
       this.telefonoCliente = telefonoCliente;
       this.ventases = ventases;
    }
   
    public int getNitCliente() {
        return this.nitCliente;
    }
    
    public void setNitCliente(int nitCliente) {
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


