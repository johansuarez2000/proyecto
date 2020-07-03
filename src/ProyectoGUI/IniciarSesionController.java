/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoGUI;

import java.io.IOException;
import java.net.URL;
import java.util.IllegalFormatException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyecto.Avl_tree;
import proyecto.Usuario;

public class IniciarSesionController implements Initializable {
    private Avl_tree<Usuario> usuarios1;
    Usuario u1 = new Usuario(1515,"1515");

    @FXML private TextField textid;
    @FXML private TextField textcontraseña;
    @FXML private Label labelError;
    @FXML private Label alarmedica;
    @FXML private Label title;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* id para css
            titles : usar para labels que requieran un borde redondo de fondo blanco con padding de 5
         */
        usuarios1 = new Avl_tree<>();
        title.setId("titles");
        title.getStylesheets().add("stylesheets/specific.css");

        alarmedica.setId("titles");
        alarmedica.getStylesheets().add("stylesheets/specific.css");

        labelError.setId("label-error");
        labelError.getStylesheets().add("stylesheets/specific.css");

        usuarios1.insert(u1);
    }
    public void iniciarSesion(ActionEvent event) throws IOException{
        labelError.setVisible(false);
        try {
            int id=Integer.parseInt(textid.getText());
            String password = textcontraseña.getText();
            Usuario comprobar = new Usuario(id,password);
            if(usuarios1.find(comprobar)== null){
                labelError.setVisible(true);
            }
            else{
                Parent registro = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                Scene mainMenuScene= new Scene (registro);
                mainMenuScene.getStylesheets().add("stylesheets/styles.css");
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(mainMenuScene);
                window.show();
            }
        }
        catch(IllegalFormatException | NumberFormatException e){
            labelError.setVisible(true);
        }
    }
    public void registrarse(ActionEvent event) throws IOException{
        Parent registro = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        Scene registroScene= new Scene (registro);
        registroScene.getStylesheets().add("stylesheets/styles.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registroScene);
        window.show();
    }

}
