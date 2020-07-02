/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MainGUI2 extends Application{
    private Scene escenaprincipal;
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Pantalla de inicio
        
        VBox LogInScreen = new VBox(30);
        LogInScreen.setPrefWidth(primaryStage.getWidth());
        LogInScreen.setMaxWidth(primaryStage.getWidth());
        LogInScreen.setPrefHeight(primaryStage.getHeight());
        LogInScreen.setMaxHeight(primaryStage.getHeight());
//        String style2 = "-fx-background-color: rgba(0, 0, 0, 0.5);";
//        LogInScreen.setStyle(style2);
        LogInScreen.setPadding(new Insets(primaryStage.getHeight()*0.1,0,primaryStage.getHeight()*0.1,0));
        LogInScreen.setAlignment(Pos.TOP_CENTER);
        
        HBox titulo = new HBox();
        String style = "-fx-background-color: rgba(27, 218, 163, 0.5);";
        titulo.setStyle(style);
        titulo.setAlignment(Pos.CENTER);
        titulo.setPrefHeight(LogInScreen.getHeight());
        titulo.setMaxHeight(LogInScreen.getHeight());
        LogInScreen.getChildren().add(titulo);
        
        Label  alarmedica=  new Label("Alarmedica");
        alarmedica.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 40));
        titulo.getChildren().add(alarmedica);
        
        VBox userandpassword = new VBox(20);
        userandpassword.setAlignment(Pos.CENTER);
        LogInScreen.getChildren().add(userandpassword);
        
        Label  l1=  new Label("Ingrese su usario");
        TextField user = new TextField("");
        user.setPrefWidth(80);
        user.setMaxWidth(80);
        userandpassword.getChildren().addAll(l1, user);
        
        Label  l2=  new Label("Ingrese su contraseña");
        TextField password = new TextField("");
        password.setPrefWidth(80);
        password.setMaxWidth(80);
        userandpassword.getChildren().addAll(l2, password);
        
        escenaprincipal=new Scene(LogInScreen,500,500);
        primaryStage.setTitle("Alarmédica");
        primaryStage.setScene(escenaprincipal);
        Image icono = new Image("/Imagenes/medico.png");
        primaryStage.getIcons().add(icono);
        primaryStage.show();
        
    }
}
