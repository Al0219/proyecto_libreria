/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_libreria;

import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author 20041
 */
public class proyecto_libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Float cantidad = 1f, existencia=5f, precioV=468f, precioC=135f;
        Integer nDoc= 1, nVenta= 1, id= 1
                ;
        
        System.out.println("insertar"+CRUDs.CRUDDetalleVenta.crear(nDoc,nVenta, id, cantidad));
        
        /*for (Iterator it = CRUDs.CRUDUsuarios.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            System.out.println("idUsuario"+ (Integer) item[0]);
            System.out.println("nombreUsuario"+ (String) item[1]);
            System.out.println("cargoUsuario"+ (String) item[2]);
            System.out.println("contraseniaUsuario"+ (String) item[3]);
        }*/
        
    }
    
}
