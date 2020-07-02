/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoGUI;

import java.net.URL;
import java.util.IllegalFormatException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import proyecto.Avl_tree;
import proyecto.Usuario;

public class IniciarSesionController implements Initializable {
    private Avl_tree<Usuario> usuarios1 = new Avl_tree<>();
    Usuario u1 = new Usuario(1515,"1515");
    @FXML private Label labelusuario;
    @FXML private Button iniciarsesion;
    @FXML private TextField textid;
    @FXML private TextField textcontraseña;
    @FXML private Label error;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarios1.insert(u1);
    }
    public void iniciarSesion(){
        error.setVisible(false);  
        try {
            int id=Integer.parseInt(textid.getText());
            String contraseña = textcontraseña.getText();
            Usuario comprobar = new Usuario(id,contraseña);
            if(usuarios1.find(comprobar)== null){
                error.setVisible(true);
            }
        }
        catch(IllegalFormatException | NumberFormatException e){
            error.setVisible(true);
        }
    }
    public void registrarse(){
        
    }
}
