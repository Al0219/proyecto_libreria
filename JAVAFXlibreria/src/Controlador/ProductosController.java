/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ProductosTabla;
import POJOs.Productos;
import POJOs.Categorias;
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
public class ProductosController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtExistencia;
    @FXML
    private TextField txtPrecioCosto;
    @FXML
    private TextField txtPrecioVenta;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TableView<ProductosTabla> tblProductos;
    private Integer idProductosV;
    private ObservableList<ProductosTabla> listaProductos;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nombre;
    @FXML
    private TableColumn<?, ?> descripcion;
    @FXML
    private TableColumn<?, ?> categoria;
    @FXML
    private TableColumn<?, ?> existencia;
    @FXML
    private TableColumn<?, ?> precioVenta;
    @FXML
    private TableColumn<?, ?> precioCosto;
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
    
    @FXML
    public void mostrar(){
        listaProductos = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDProductos.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listaProductos.add(new ProductosTabla((Integer)item[0],(Categorias)item[1],(String)item[2], (String)item[3], (Float)item[4], (Float)item[5],(Float)item[6]));
        }
        this.id.setCellValueFactory(new PropertyValueFactory("idProducto"));
        this.categoria.setCellValueFactory(new PropertyValueFactory("categorias"));
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombreProducto"));
        this.descripcion.setCellValueFactory(new PropertyValueFactory("descripcionProducto"));
        this.existencia.setCellValueFactory(new PropertyValueFactory("existencia"));
        this.precioCosto.setCellValueFactory(new PropertyValueFactory("precioCosto"));
        this.precioVenta.setCellValueFactory(new PropertyValueFactory("precioVenta"));
        tblProductos.setItems(listaProductos);
    }

    @FXML
    private void seleccionarModificar(MouseEvent event) {
        ProductosTabla p = this.tblProductos.getSelectionModel().getSelectedItem();
        txtNombre.setText(p.getNombreProducto());
        txtDescripcion.setText(p.getDescripcionProducto());
        txtExistencia.setText(""+p.getExistencia());
        txtPrecioVenta.setText(""+p.getPrecioVenta());
        txtPrecioCosto.setText(""+p.getPrecioCosto());
        txtCategoria.setText(p.getCategorias()+"");
        
        idProductosV = p.getIdProducto();
    }

    public void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtExistencia.setText("");
        txtPrecioVenta.setText("");
        txtPrecioCosto.setText("");
        txtCategoria.setText("");
    }
    @FXML
    private void insertar(ActionEvent event) {
        try{
        Integer idCat; 
        String nombre, descripcion;
        Float existencia,precioVenta, precioCosto;
        nombre = txtNombre.getText();
        descripcion = txtDescripcion.getText();
        existencia = Float.parseFloat(txtExistencia.getText());
        precioVenta = Float.parseFloat(txtPrecioVenta.getText());
        precioCosto = Float.parseFloat(txtPrecioCosto.getText());
        idCat = Integer.parseInt(txtCategoria.getText());
        if(CRUDs.CRUDProductos.crear(idCat, nombre, descripcion, existencia, precioVenta, precioCosto)){
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
        Integer idCat;
        String nombre, descripcion;
        Float existencia,precioVenta, precioCosto;
        nombre = txtNombre.getText();
        descripcion = txtDescripcion.getText();
        existencia = Float.parseFloat(txtExistencia.getText());
        precioVenta = Float.parseFloat(txtPrecioVenta.getText());
        precioCosto = Float.parseFloat(txtPrecioCosto.getText());
        idCat = Integer.parseInt(txtCategoria.getText());
        if(CRUDs.CRUDProductos.actualizar(getIdProductosV(), idCat, nombre, descripcion, existencia, precioVenta, precioCosto)){
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
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
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
    public Integer getIdProductosV() {
        return idProductosV;
    }
    
}
