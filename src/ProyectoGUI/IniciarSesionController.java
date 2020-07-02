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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyecto.Avl_tree;
import proyecto.Usuario;

public class IniciarSesionController implements Initializable {
    private Avl_tree<Usuario> usuarios1 = new Avl_tree<>();
    Usuario u1 = new Usuario(1515,"1515");
    @FXML private Label labelusuario;
    @FXML private Button iniciarsesion;
    @FXML private TextField textid;
    @FXML private TextField textcontraseña;
    @FXML private Label labelError;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarios1.insert(u1);
    }
    public void iniciarSesion(){
        labelError.setVisible(false);
        try {
            int id=Integer.parseInt(textid.getText());
            String contraseña = textcontraseña.getText();
            Usuario comprobar = new Usuario(id,contraseña);
            if(usuarios1.find(comprobar)== null){
                labelError.setVisible(true);
            }
        }
        catch(IllegalFormatException | NumberFormatException e){
            labelError.setVisible(true);
        }
    }
    public void registrarse(ActionEvent event) throws IOException{
        Parent registro = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        Scene registroScene= new Scene (registro);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registroScene);
        window.show();
    }
}
