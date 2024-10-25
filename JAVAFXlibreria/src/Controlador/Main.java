/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 20041
 */
public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public void start(Stage primaryStage ){
        try{
            Parent root=FXMLLoader.load(getClass().getResource("/Vista/Categorias.fxml"));
            primaryStage.setTitle("Menu");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }catch (Exception e){
            System.out.println("error="+e);
        }
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
