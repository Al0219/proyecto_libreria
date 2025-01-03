package POJOs;
// Generated 25/10/2024 09:33:04 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ventas generated by hbm2java
 */
public class Ventas  implements java.io.Serializable {


     private Integer numeroVenta;
     private Clientes clientes;
     private Usuarios usuarios;
     private boolean estadoVenta;
     private Date fechaVenta;
     private Set<DetalleVenta> detalleVentas = new HashSet<DetalleVenta>(0);

    public Ventas() {
    }

	
    public Ventas(Clientes clientes, Usuarios usuarios, boolean estadoVenta, Date fechaVenta) {
        this.clientes = clientes;
        this.usuarios = usuarios;
        this.estadoVenta = estadoVenta;
        this.fechaVenta = fechaVenta;
    }
    public Ventas(Clientes clientes, Usuarios usuarios, boolean estadoVenta, Date fechaVenta, Set<DetalleVenta> detalleVentas) {
       this.clientes = clientes;
       this.usuarios = usuarios;
       this.estadoVenta = estadoVenta;
       this.fechaVenta = fechaVenta;
       this.detalleVentas = detalleVentas;
    }
   
    public Integer getNumeroVenta() {
        return this.numeroVenta;
    }
    
    public void setNumeroVenta(Integer numeroVenta) {
        this.numeroVenta = numeroVenta;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public boolean isEstadoVenta() {
        return this.estadoVenta;
    }
    
    public void setEstadoVenta(boolean estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
    public Date getFechaVenta() {
        return this.fechaVenta;
    }
    
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public Set<DetalleVenta> getDetalleVentas() {
        return this.detalleVentas;
    }
    
    public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }




}


