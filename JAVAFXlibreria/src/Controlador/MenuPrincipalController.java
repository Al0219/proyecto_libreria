/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 20041
 */
public class MenuPrincipalController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void abrirUsuarios(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Usuarios.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Usuarios");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void abrirClientes(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Clientes.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Clientes");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.close();
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void abrirCategorias(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Categorias.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Categorias");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void abrirProductos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Productos.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Productos");
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void abrirProveedores(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Proveedores.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Proveedores");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void abrirCompras(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Compras.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Compras");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void abrirDetalleCompra(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/DetalleCompra.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("DetalleCompra");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void abrirVentas(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Ventas.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ventas");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void abrirDetalleVenta(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/DetalleVenta.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("DetalleVenta");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
