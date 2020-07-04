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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyecto.Avl_tree;
import proyecto.Usuario;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RegistroController implements Initializable {



    @FXML private Label title;
    @FXML private Label labelError;
    @FXML private TextField textFieldID;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordFieldVerification;
    @FXML private Label alarmed;

    private Avl_tree<Usuario> usuariosAvlTree;

    /* id para CSS
             titles : usar para labels que requieran un borde redondo de fondo blanco con padding de 5
             label-error: usar para el envío del mensaje a ususario solo hay un label de este tipo,
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuariosAvlTree = new Avl_tree<>();
        Usuario usuario =new Usuario(1515,"1515");
        usuariosAvlTree.insert(usuario);
        alarmed.setId("titles");
        alarmed.getStylesheets().add("stylesheets/specific.css");
        labelError.setId("label-error");
        labelError.getStylesheets().add("stylesheets/specific.css");
    }
    public void crearUsuario(ActionEvent event) throws IOException{
        labelError.setVisible(false);
        try {
            int id=Integer.parseInt(textFieldID.getText());
            String password = passwordField.getText();
            String passwordVerification = passwordFieldVerification.getText();
            Usuario comprobar = new Usuario(id,password);
            if(usuariosAvlTree.contains(comprobar)){ //verificar si se puede corroborar por id y no por el objeto completamente
                labelError.setVisible(true);
                labelError.setText("El usuario ya existe");
            }
            else if(!password.equals(passwordVerification)){
                throw new IllegalArgumentException();
            }
            else{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("IniciarSesion.fxml"));
                Parent registroParent = loader.load();
                Scene iniciarSesionScene= new Scene (registroParent);

                IniciarSesionController controller = loader.getController();
                controller.addUserToDatabase(comprobar);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(iniciarSesionScene);
                window.show();
            }
        }
        catch(IllegalFormatException | NumberFormatException e){
            labelError.setVisible(true);
            labelError.setText("Entrada no válida");
        }
        catch (IllegalArgumentException passwordMismatch){
            labelError.setVisible(true);
            labelError.setText("Las contraseñas no coinciden");
        }
    }
    public void regresar (ActionEvent event) throws IOException{
        Parent registro = FXMLLoader.load(getClass().getResource("IniciarSesion.fxml"));
        Scene iniciarSesionScene= new Scene (registro);
        iniciarSesionScene.getStylesheets().add("stylesheets/styles.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(iniciarSesionScene);
        window.show();
    }
}
