package POJOs;
// Generated 23/10/2024 09:26:17 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Compras generated by hbm2java
 */
public class Compras  implements java.io.Serializable {


     private Integer numeroCompra;
     private Proveedores proveedores;
     private Usuarios usuarios;
     private boolean estadoCompra;
     private Date fechaCompra;
     private Set<DetalleCompra> detalleCompras = new HashSet<DetalleCompra>(0);

    public Compras() {
    }

	
    public Compras(Proveedores proveedores, Usuarios usuarios, boolean estadoCompra, Date fechaCompra) {
        this.proveedores = proveedores;
        this.usuarios = usuarios;
        this.estadoCompra = estadoCompra;
        this.fechaCompra = fechaCompra;
    }
    public Compras(Proveedores proveedores, Usuarios usuarios, boolean estadoCompra, Date fechaCompra, Set<DetalleCompra> detalleCompras) {
       this.proveedores = proveedores;
       this.usuarios = usuarios;
       this.estadoCompra = estadoCompra;
       this.fechaCompra = fechaCompra;
       this.detalleCompras = detalleCompras;
    }
   
    public Integer getNumeroCompra() {
        return this.numeroCompra;
    }
    
    public void setNumeroCompra(Integer numeroCompra) {
        this.numeroCompra = numeroCompra;
    }
    public Proveedores getProveedores() {
        return this.proveedores;
    }
    
    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public boolean isEstadoCompra() {
        return this.estadoCompra;
    }
    
    public void setEstadoCompra(boolean estadoCompra) {
        this.estadoCompra = estadoCompra;
    }
    public Date getFechaCompra() {
        return this.fechaCompra;
    }
    
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public Set<DetalleCompra> getDetalleCompras() {
        return this.detalleCompras;
    }
    
    public void setDetalleCompras(Set<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }




}

