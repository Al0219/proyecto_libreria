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
        Date date = new Date();
        System.out.println("insertar"+CRUDs.CRUDVentas.crear(1,1, date));
        //System.out.println("insertar"+CRUDs.CRUDProveedores.crear("Juan","Guatemala","45795684"));
        
        /*for (Iterator it = CRUDs.CRUDUsuarios.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            System.out.println("idUsuario"+ (Integer) item[0]);
            System.out.println("nombreUsuario"+ (String) item[1]);
            System.out.println("cargoUsuario"+ (String) item[2]);
            System.out.println("contraseniaUsuario"+ (String) item[3]);
        }*/
        
    }
    
}
