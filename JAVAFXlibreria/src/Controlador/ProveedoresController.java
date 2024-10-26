/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProveedoresTabla;
import Modelo.ProveedoresTabla;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 20041
 */
public class ProveedoresController implements Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnAnular;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TableView<ProveedoresTabla> tblProveedores;
    private Integer idProveedorV;
    private ObservableList<ProveedoresTabla> listaProveedores;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nombre;
    @FXML
    private TableColumn<?, ?> direccion;
    @FXML
    private TableColumn<?, ?> telefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
        // TODO
    }    
    
    @FXML
    public void mostrar(){
        listaProveedores = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDProveedores.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listaProveedores.add(new ProveedoresTabla((Integer)item[0],(String)item[1],(String)item[2], (String)item[3]));
        }
        this.id.setCellValueFactory(new PropertyValueFactory("idProveedor"));
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombreProveedor"));
        this.direccion.setCellValueFactory(new PropertyValueFactory("direccionProveedor"));
        this.telefono.setCellValueFactory(new PropertyValueFactory("telefonoProveedor"));
        tblProveedores.setItems(listaProveedores);
    }

    @FXML
    private void insertar(ActionEvent event) {
        try{
        String nombre, direccion, telefono;
        nombre = txtNombre.getText();
        direccion = txtDireccion.getText();
        telefono = txtTelefono.getText();
        if(CRUDs.CRUDProveedores.crear(nombre, direccion, telefono)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            mostrar();
            alerta.setTitle("Registro ingresado");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro ingresado");
        alerta.showAndWait();
        limpiar();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro no ingresado");
        alerta.showAndWait();
        }
        }catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText("Error en Datos "+e);
        alerta.showAndWait();
        }
    }

    @FXML
    private void modificar(ActionEvent event) {
        try{
        String nombre, direccion, telefono;
        nombre = txtNombre.getText();
        direccion = txtDireccion.getText();
        telefono = txtTelefono.getText();
        if(CRUDs.CRUDProveedores.actualizar(getIdProveedorV(), nombre, direccion, telefono)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            mostrar();
            alerta.setTitle("Registro modificado");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro modificado");
        alerta.showAndWait();
        //btnGuardar.setVisible(true);
        //btnActualizar.setVisible(false);
        //btnAnular.setVisible(false);
        //btnCancelar.setVisible(false);
        limpiar();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro no modificado");
        alerta.showAndWait();
        }
        }catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText("Error en Datos "+e);
        alerta.showAndWait();
        }
    }

    @FXML
    private void anular(ActionEvent event) {
        try{
        if(CRUDs.CRUDProveedores.anular(getIdProveedorV())){
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            mostrar();
            alerta.setTitle("Registro anulado");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro anulado");
        alerta.showAndWait();
        //btnGuardar.setVisible(true);
        //btnActualizar.setVisible(false);
        //btnAnular.setVisible(false);
        //btnCancelar.setVisible(false);
        limpiar();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro no anulado");
        alerta.showAndWait();
        }
        }catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        
        
        alerta.setContentText("Error en Datos "+e);
        alerta.showAndWait();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuPrincipal.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuPrincipal");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProveedoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //btnGuardar.setVisible(true);
        //btnActualizar.setVisible(false);
        //btnAnular.setVisible(false);
        //btnCancelar.setVisible(false);
        limpiar();
    }

    @FXML
    private void seleccionarModificar(javafx.scene.input.MouseEvent event){
        ProveedoresTabla p = this.tblProveedores.getSelectionModel().getSelectedItem();
        txtNombre.setText(p.getNombreProveedor());
        txtDireccion.setText(p.getDireccionProveedor());
        txtTelefono.setText(p.getTelefonoProveedor());
        idProveedorV = p.getNitProveedor();
        //btnGuardar.setVisible(false);
        //btnActualizar.setVisible(true);
        //btnAnular.setVisible(true);
        //btnCancelar.setVisible(true);
    }
    
    public void limpiar(){
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }
    
    @FXML
    private void navegarCampos(TextField campoAnterior, TextField campoSiguiente){
        campoAnterior.setOnKeyPressed(event ->{
            switch(event.getCode()){
                case ENTER:
                    campoSiguiente.requestFocus();
                    break;
                default:
                    break;
            }
        });
    }
    
    @FXML
    public Integer getIdProveedorV() {
        return idProveedorV;
    }
}
