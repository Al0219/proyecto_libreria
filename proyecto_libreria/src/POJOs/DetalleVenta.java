package POJOs;
// Generated 23/10/2024 09:26:17 PM by Hibernate Tools 4.3.1



/**
 * DetalleVenta generated by hbm2java
 */
public class DetalleVenta  implements java.io.Serializable {


     private Integer numeroDocumento;
     private Productos productos;
     private Ventas ventas;
     private float cantidad;
     private float precioUnitario;
     private float totalVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(Productos productos, Ventas ventas, float cantidad, float precioUnitario, float totalVenta) {
       this.productos = productos;
       this.ventas = ventas;
       this.cantidad = cantidad;
       this.precioUnitario = precioUnitario;
       this.totalVenta = totalVenta;
    }
   
    public Integer getNumeroDocumento() {
        return this.numeroDocumento;
    }
    
    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public Ventas getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
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
    public float getTotalVenta() {
        return this.totalVenta;
    }
    
    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }




}

