/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_libreria;

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
        System.out.println("insertar"+CRUDs.CRUDUsuarios.crear("Alan", "Contador", "12345"));
        /*for (Iterator it = CRUDs.CRUDUsuarios.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            System.out.println("idUsuarios"+ (Integer) item[0]);
            System.out.println("nombreUsuarios"+ (String) item[1]);
            System.out.println("cargoUsuarios"+ (String) item[2]);
            System.out.println("contraseniausuarios"+ (String) item[3]);
        }*/
        
    }
    
}
