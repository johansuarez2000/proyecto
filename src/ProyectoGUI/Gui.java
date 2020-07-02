/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Gui extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("IniciarSesion.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Alarmédica");
        Image icono = new Image("/Imagenes/medico.png");
        stage.getIcons().add(icono);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setMaxWidth(800);
        stage.setMaxHeight(600);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }   
}