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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 20041
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private Button btnUsuarios;
    @FXML
    private Button btnClientes;
    @FXML
    private Button btnProveedores;
    @FXML
    private Button btnCategorias;
    @FXML
    private Button btnProductos;
    @FXML
    private Button btnCompras;
    @FXML
    private Button btnVentas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void abrirUsuarios(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Usuarios.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Usuarios");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void abrirClientes(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Clientes.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Clientes");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.close();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void abrirCategorias(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Categorias.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Categorias");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @FXML
    public void abrirProductos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Productos.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Productos");
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void abrirProveedores(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Proveedores.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Proveedores");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void abrirCompras(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/DetalleCompra.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("DetalleCompra");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
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
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void abrirVentas(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/DetalleVenta.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("DetalleVentas");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void abrirDetalleVenta(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/DetalleVenta.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("DetalleVenta");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
