/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuariosTabla;
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
public class UsuariosController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtCargo;
    @FXML
    private TextField txtContraseña;
    @FXML
    private TableColumn<?, ?> id_usuarios;
    @FXML
    private TableColumn<?, ?> nombre;
    @FXML
    private TableColumn<?, ?> cargo;
    @FXML
    private TableColumn<?, ?> contrasenia;
    @FXML
    private TableView<UsuariosTabla> tblUsuarios;
    private Integer idUsuarioV;
    private ObservableList<UsuariosTabla> listaUsuarios;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnAnular;
    @FXML
    private Button btnCancelar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
    }    
    
    public void mostrar(){
        listaUsuarios = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDUsuarios.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listaUsuarios.add(new UsuariosTabla((Integer)item[0],(String)item[1],(String)item[2], (String)item[3]));
        }
        this.id_usuarios.setCellValueFactory(new PropertyValueFactory("idUsuario"));
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombreUsuario"));
        this.cargo.setCellValueFactory(new PropertyValueFactory("cargoUsuario"));
        this.contrasenia.setCellValueFactory(new PropertyValueFactory("contraseniaUsuario"));
        tblUsuarios.setItems(listaUsuarios);
    }

    @FXML
    private void seleccionarModificar(javafx.scene.input.MouseEvent event){
        UsuariosTabla p = this.tblUsuarios.getSelectionModel().getSelectedItem();
        txtUsuario.setText(p.getNombreUsuario());
        txtCargo.setText(p.getCargoUsuario());
        txtContraseña.setText(p.getContraseniaUsuario());
        idUsuarioV = p.getIdUsuario();
        //btnGuardar.setVisible(false);
        //btnActualizar.setVisible(true);
        //btnAnular.setVisible(true);
        //btnCancelar.setVisible(true);
    }
    
    public void limpiar(){
        txtUsuario.setText("");
        txtCargo.setText("");
        txtContraseña.setText("");
    }
    
    @FXML
    private void insertar() {
        try{
        String nombre, cargo, contrasenia;
        nombre = txtUsuario.getText();
        cargo = txtCargo.getText();
        contrasenia = txtContraseña.getText();
        if(CRUDs.CRUDUsuarios.crear(nombre, cargo, contrasenia)){
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
        String nombre, cargo, contrasenia;
        nombre = txtUsuario.getText();
        cargo = txtCargo.getText();
        contrasenia = txtContraseña.getText();
        if(CRUDs.CRUDUsuarios.actualizar(getIdUsuarioV(), nombre, cargo, contrasenia)){
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
    private void anular() {
        try{
        if(CRUDs.CRUDUsuarios.anular(getIdUsuarioV())){
            
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
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public Integer getIdUsuarioV() {
        return idUsuarioV;
    }
    
}
