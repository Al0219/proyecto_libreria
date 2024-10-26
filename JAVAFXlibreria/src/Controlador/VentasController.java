/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuariosTabla;
import Modelo.VentasTabla;
import POJOs.Clientes;
import POJOs.Usuarios;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class VentasController implements Initializable {

    @FXML
    private TextField txtFechaVenta;
    @FXML
    private TextField txtNitCliente;
    @FXML
    private TextField txtIdUsuario;
    @FXML
    private Button btnCancelar;
    @FXML
    private TableColumn<?, ?> nitNumeroVenta;
    @FXML
    private TableColumn<?, ?> nitCliente;
    @FXML
    private TableColumn<?, ?> fechaVenta;
    @FXML
    private TableColumn<?, ?> idUsuario;
    
    @FXML
    private TableView<VentasTabla> tblVentas;
    private Integer numeroVentass;
    private ObservableList<VentasTabla> listaVentas;
    
    
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnAnular;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
        // TODO
    }    
    
    public void mostrar(){
        listaVentas = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDVentas.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listaVentas.add(new VentasTabla((Integer)item[0],(Integer)item[1],(Date)item[2], (Integer)item[3]));
        }
        this.nitNumeroVenta.setCellValueFactory(new PropertyValueFactory("nitNumeroVenta"));
        this.nitCliente.setCellValueFactory(new PropertyValueFactory("nitCliente"));
        this.fechaVenta.setCellValueFactory(new PropertyValueFactory("fechaCliente"));
        this.idUsuario.setCellValueFactory(new PropertyValueFactory("idUsuario"));
        tblVentas.setItems(listaVentas);
    }

    @FXML
    private void seleccionarModificar(javafx.scene.input.MouseEvent event){
        VentasTabla p = this.tblVentas.getSelectionModel().getSelectedItem();
        txtFechaVenta.setText(String.valueOf(p.getFechaVenta()));
        txtNitCliente.setText(p.getNitCliente()+"");
        txtIdUsuario.setText(p.getIdUsuario()+"");
        numeroVentass= p.getNumeroVenta();
        //btnGuardar.setVisible(false);
        //btnActualizar.setVisible(true);
        //btnAnular.setVisible(true);
        //btnCancelar.setVisible(true);
    }
    
    public void limpiar(){
        txtFechaVenta.setText("");
        txtNitCliente.setText("");
        txtIdUsuario.setText("");
    }
    
    @FXML
    private void insertar() {
        try{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
        String fechaVenta;
        Integer nitCliente, idUsuario;
        fechaVenta = txtFechaVenta.getText();
        nitCliente = Integer.parseInt(txtNitCliente.getText());
        idUsuario = Integer.parseInt(txtIdUsuario.getText());
        Date fecha = formato.parse(txtFechaVenta.getText());
        if(CRUDs.CRUDVentas.crear(idUsuario, nitCliente, fecha)){
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
        String fechaVenta;
        Integer nitCliente, idUsuario;
        Date fecha = formato.parse(txtFechaVenta.getText());
        Clientes cliente = new Clientes();
        cliente.setNitCliente(Integer.parseInt(txtNitCliente.getText()));
        Usuarios usuario = new Usuarios();
        usuario.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
        
        if(CRUDs.CRUDVentas.actualizar(getNumeroVentassss(), fecha, cliente, usuario)){
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
        if(CRUDs.CRUDVentas.anular(getNumeroVentassss())){
            
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
    private void cancelar(ActionEvent event) throws InterruptedException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuPrincipal.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuPrincipal");
            window.wait();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(VentasController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Integer getNumeroVentassss() {
        return numeroVentass;
    }

    
    
}
