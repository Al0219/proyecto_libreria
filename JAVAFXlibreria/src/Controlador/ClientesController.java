/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClientesTabla;
import Modelo.ClientesTabla;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 20041
 */
public class ClientesController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private Button btnCancelar;
    private TableColumn<?, ?> nitCliente;
    @FXML
    private TableColumn<?, ?> nombreCliente;
    @FXML
    private TableColumn<?, ?> direccionCliente;
    private TableColumn<?, ?> TelefonoCliente;
    
    @FXML
    private TableView<ClientesTabla> tblClientes;
    private Integer nitClienteV;
    private ObservableList<ClientesTabla> listaClientes;
    
    @FXML
    private TextField txtTelefono;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnAnular;
    @FXML
    private TableColumn<?, ?> nitPersona;
    @FXML
    private TableColumn<?, ?> telefonoCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
        // TODO
    }    
    
    public void mostrar(){
        listaClientes = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDClientes.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listaClientes.add(new ClientesTabla((Integer)item[0],(String)item[1],(String)item[2], (String)item[3]));
        }
        this.nitPersona.setCellValueFactory(new PropertyValueFactory("nitCliente"));
        this.nombreCliente.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
        this.direccionCliente.setCellValueFactory(new PropertyValueFactory("direccionCliente"));
        this.telefonoCliente.setCellValueFactory(new PropertyValueFactory("telefonoCliente"));
        tblClientes.setItems(listaClientes);
    }
    
    @FXML
    private void seleccionarModificar(javafx.scene.input.MouseEvent event){
        ClientesTabla p = this.tblClientes.getSelectionModel().getSelectedItem();
        txtNombre.setText(p.getNombreCliente());
        txtDireccion.setText(p.getDireccionCliente());
        txtTelefono.setText(p.getTelefonoCliente());
        nitClienteV = p.getNitCliente();
        //btnGuardar.setVisible(false);
        //btnModificar.setVisible(true);
        //btnAnular.setVisible(true);
        //btnCancelar.setVisible(true);
    }
    
    public void limpiar(){
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }
    
    @FXML
    private void insertar() {
        try{
        String nombre, direccion,Telefono;
        nombre = txtNombre.getText();
        direccion = txtDireccion.getText();
        Telefono = txtTelefono.getText();
        if(CRUDs.CRUDClientes.crear(nombre, direccion, Telefono)){
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
    private void modificar() {
        try{
        String nombre, direccion, Telefono;
        nombre = txtNombre.getText();
        direccion = txtDireccion.getText();
        Telefono = txtTelefono.getText();
        if(CRUDs.CRUDClientes.actualizar(getnitClienteV(), nombre, direccion, Telefono)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            mostrar();
            alerta.setTitle("Registro modificado");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro modificado");
        alerta.showAndWait();
        //btnGuardar.setVisible(true); estos son los botones
        //btnModificar.setVisible(false);
        //btnAnular.setVisible(false);
        //btnCancelar.setVisible(false);
        
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
    private void anular() {
        try{
        if(CRUDs.CRUDClientes.anular(getnitClienteV())){
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            mostrar();
            alerta.setTitle("Registro anulado");
        alerta.setHeaderText(null);
        alerta.setContentText("Registro anulado");
        alerta.showAndWait();
        //btnGuardar.setVisible(true); estos son los botones
        //btnModificar.setVisible(false);
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
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //btnGuardar.setVisible(true); estos son los botones
        //btnModificar.setVisible(false);
        //btnAnular.setVisible(false);
        //btnCancelar.setVisible(false);
        
        //btnGuardar.setVisible(true);
        //btnActualizar.setVisible(false);
        //btnAnular.setVisible(false);
        //btnCancelar.setVisible(false);
        limpiar();
    }
    
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
    public Integer getnitClienteV() {
        return nitClienteV;
    }
    
}
    

