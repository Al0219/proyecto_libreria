package POJOs;
// Generated 25/10/2024 02:38:30 AM by Hibernate Tools 4.3.1



/**
 * DetalleCompra generated by hbm2java
 */
public class DetalleCompra  implements java.io.Serializable {


     private int numeroDocumento;
     private Compras compras;
     private Productos productos;
     private float cantidad;
     private float precioUnitario;
     private float totalCompra;

    public DetalleCompra() {
    }

    public DetalleCompra(int numeroDocumento, Compras compras, Productos productos, float cantidad, float precioUnitario, float totalCompra) {
       this.numeroDocumento = numeroDocumento;
       this.compras = compras;
       this.productos = productos;
       this.cantidad = cantidad;
       this.precioUnitario = precioUnitario;
       this.totalCompra = totalCompra;
    }
   
    public int getNumeroDocumento() {
        return this.numeroDocumento;
    }
    
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public Compras getCompras() {
        return this.compras;
    }
    
    public void setCompras(Compras compras) {
        this.compras = compras;
    }
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public float getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    public float getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public float getTotalCompra() {
        return this.totalCompra;
    }
    
    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }




}


