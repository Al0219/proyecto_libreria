/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
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
    @Override
    public void start(Stage primaryStage ){
        try{
            Stage stage = new Stage();
            stage.setFullScreen(true);
            Parent root=FXMLLoader.load(getClass().getResource("/Vista/MenuPrincipal.fxml"));
            primaryStage.setTitle("Menu");
            primaryStage.setScene(new Scene(root));
            primaryStage.isFullScreen();
            primaryStage.show();
        }catch (IOException e){
            System.out.println("error="+e);
        }
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
