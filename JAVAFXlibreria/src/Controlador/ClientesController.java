/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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
    @FXML
    private TableColumn<?, ?> nitPersona;
    @FXML
    private TableColumn<?, ?> nombreCliente;
    @FXML
    private TableColumn<?, ?> direccionCliente;
    @FXML
    private TableColumn<?, ?> telefonoCliente;
    @FXML
    private TextField txtTelefono;
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
        // TODO
    }    
    
}
