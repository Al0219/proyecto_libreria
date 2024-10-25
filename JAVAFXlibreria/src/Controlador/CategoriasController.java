/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CategoriasTabla;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 20041
 */
public class CategoriasController implements Initializable {

    @FXML
    private TextField txtNombreCategoria;
    @FXML
    private TextField txtDescripcionCategoria;
    @FXML
    private TableView<CategoriasTabla> tblCategorias;
    @FXML
    private TableColumn<?, ?> idCategoria;
    @FXML
    private TableColumn<?, ?> nombreCategoria;
    @FXML
    private TableColumn<?, ?> descripcionCategoria;
    private Integer idCategoriaV;
    private ObservableList<CategoriasTabla> listaCategoria;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
        // TODO
    }

    public void mostrar(){
        listaCategoria = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDCategorias.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listaCategoria.add(new CategoriasTabla((Integer)item[0],(String)item[1],(String)item[2]));
        }
        this.idCategoria.setCellValueFactory(new PropertyValueFactory("idCategoria"));
        this.nombreCategoria.setCellValueFactory(new PropertyValueFactory("nombreCategoria"));
        this.descripcionCategoria.setCellValueFactory(new PropertyValueFactory("descripcionCategoria"));
        tblCategorias.setItems(listaCategoria);
    }

    @FXML
    private void seleccionarModificar(MouseEvent event) {
        CategoriasTabla p = this.tblCategorias.getSelectionModel().getSelectedItem();
        txtNombreCategoria.setText(p.getNombreCategoria());
        txtDescripcionCategoria.setText(p.getDescripcionCategoria());
        idCategoriaV = p.getIdCategoria();
        //btnGuardar.setVisible(false);
        //btnActualizar.setVisible(true);
        //btnAnular.setVisible(true);
        //btnCancelar.setVisible(true);
    }
    
    public void limpiar(){
        txtNombreCategoria.setText("");
        txtDescripcionCategoria.setText("");
    }

    @FXML
    private void insertar(ActionEvent event) {
        try{
        String nombre, descripcion;
        nombre = txtNombreCategoria.getText();
        descripcion = txtDescripcionCategoria.getText();
        if(CRUDs.CRUDCategorias.crear(nombre, descripcion)){
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
        String nombre, descripcion;
        nombre = txtNombreCategoria.getText();
        descripcion = txtDescripcionCategoria.getText();
        if(CRUDs.CRUDCategorias.actualizar(getIdCategoriaV(), nombre, descripcion)){
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
    private void cancelar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Usuarios.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuPrincipal");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CategoriasController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public Integer getIdCategoriaV() {
        return idCategoriaV;
    }
    
}
