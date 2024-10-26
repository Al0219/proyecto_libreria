/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleCompraTabla;
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
public class DetalleCompraController implements Initializable {

    @FXML
    private TextField txtNumDoc;
    @FXML
    private TextField txtNumCompra;
    @FXML
    private TextField txtIdProd;
    @FXML
    private TextField txtcantidad;
    @FXML
    private TextField txtPrecioUnit;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button txtCancelar;
    @FXML
    private TableView<DetalleCompraTabla> tblDetallesCompra;
    private Integer numeroDocumentoV;
    private ObservableList<DetalleCompraTabla> listaDetallesCompra;
    @FXML
    private TableColumn<?, ?> numDoc;
    @FXML
    private TableColumn<?, ?> numCompra;
    @FXML
    private TableColumn<?, ?> idProd;
    @FXML
    private TableColumn<?, ?> cantidad;
    @FXML
    private TableColumn<?, ?> precioUnit;
    @FXML
    private TableColumn<?, ?> total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void mostrar(){
        listaDetallesCompra = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDDetalleCompra.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listaDetallesCompra.add(new DetalleCompraTabla((int)item[0],(Integer)item[1],(Integer)item[2], (float)item[3], (float)item[4]));
        }
        this.numDoc.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        this.numCompra.setCellValueFactory(new PropertyValueFactory("numeroCompra"));
        this.idProd.setCellValueFactory(new PropertyValueFactory("idProdUsuario"));
        this.cantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.precioUnit.setCellValueFactory(new PropertyValueFactory("precioUnitario"));
        this.total.setCellValueFactory(new PropertyValueFactory("totalCompra"));
        tblDetallesCompra.setItems(listaDetallesCompra);
    }

    @FXML
    private void seleccionarModificar(javafx.scene.input.MouseEvent event){
        DetalleCompraTabla p = this.tblDetallesCompra.getSelectionModel().getSelectedItem();
        txtNumDoc.setText(String.valueOf(p.getNumeroDocumento()));
        txtNumCompra.setText(String.valueOf(p.getNumeroCompra()));
        txtIdProd.setText(String.valueOf(p.getIdProducto()));
        txtcantidad.setText(String.valueOf(p.getCantidad()));
        txtPrecioUnit.setText(String.valueOf(p.getPrecioUnitario()));
        //btnGuardar.setVisible(false);
        //btnActualizar.setVisible(true);
        //btnAnular.setVisible(true);
        //btnCancelar.setVisible(true);
    }
    
    public void limpiar(){
        txtNumDoc.setText("");
        txtNumCompra.setText("");
        txtIdProd.setText("");
        txtcantidad.setText("");
        txtPrecioUnit.setText("");
    }

    @FXML
    private void insertar(ActionEvent event) {
        try{
        Integer numDoc, numCompra, idProd;
        Float cantidad, precioU, total;
        numDoc = Integer.parseInt(txtNumDoc.getText());
        numCompra = Integer.parseInt(txtNumCompra.getText());
        idProd = Integer.parseInt(txtIdProd.getText());
        cantidad = Float.parseFloat(txtcantidad.getText());
        precioU = Float.parseFloat(txtPrecioUnit.getText());
        total = cantidad * precioU;
        
        
        if(CRUDs.CRUDDetalleCompra.crear(numDoc, numCompra, idProd, cantidad, precioU)){
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
        Integer numDoc, numCompra, idProd;
        Float cantidad, precioU, total;
        numDoc = Integer.parseInt(txtNumDoc.getText());
        numCompra = Integer.parseInt(txtNumCompra.getText());
        idProd = Integer.parseInt(txtIdProd.getText());
        cantidad = Float.parseFloat(txtcantidad.getText());
        precioU = Float.parseFloat(txtPrecioUnit.getText());
        total = cantidad * precioU;
        if(CRUDs.CRUDDetalleCompra.actualizar(numDoc, numCompra, idProd, cantidad, precioU)){
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuPrincipal.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuPrincipal");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetalleCompraController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Integer getnumerroDocumentoV() {
        return numeroDocumentoV;
    }    
    
}
