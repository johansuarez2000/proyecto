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
import proyecto.*;

public class IniciarSesionController implements Initializable {
    private Avl_tree<Usuario> usuarioAvlTree;
    private HashTable<Usuario> usuarioHashTable;
    private Usuario u1;
    private Usuario u2;
    NodoHash<Usuario> existe = null;

    @FXML private TextField textid;
    @FXML private TextField textcontraseña;
    @FXML private Label labelError;
    @FXML private Label alarmedica;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* id para css
            titles : usar para labels que requieran un borde redondo de fondo blanco con padding de 5
         */
        u1= new Usuario(1515,"1515");
        u2= new Usuario(2020,"2020");
        medicamento m1= new medicamento("Loratadina",100,100,100);
        medicamento m2= new medicamento("Clonazepam",100,100,100);

        usuarioAvlTree = new Avl_tree<>();
        usuarioHashTable= new HashTable<>();
        u1.medicamentos.add(m1);
        u1.medicamentos.add(m2);

        alarmedica.setId("titles");
        alarmedica.getStylesheets().add("stylesheets/specific.css");

        labelError.setId("label-error");
        labelError.getStylesheets().add("stylesheets/specific.css");

        usuarioHashTable.insertar(u1);
        usuarioHashTable.insertar(u2);
    }
    public void iniciarSesion(ActionEvent event) throws IOException{
        labelError.setVisible(false);
        try {
            int id=Integer.parseInt(textid.getText());
            String password = textcontraseña.getText();
            Usuario comprobar = new Usuario(id,password);
            existe = usuarioHashTable.buscar(comprobar);
            if((existe == null) || (existe.getKey().ComparePasword(comprobar) == false)){
                labelError.setVisible(true);
            }
            else{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("MainMenu.fxml"));
                Parent iniciarSesionParent = loader.load();

                Scene mainMenuScene= new Scene (iniciarSesionParent);

                mainMenuScene.getStylesheets().add("stylesheets/styles.css");

                MainMenuController controller = loader.getController();
                controller.initUserData(existe);

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
    public void addUserToDatabase( Usuario usuario){
        usuarioHashTable.insertar(usuario);
    }
    public void updateUserInDatabase(NodoHash <Usuario> usuarioNode) {

        usuarioHashTable.eliminar((Usuario) usuarioNode.getKey());
        usuarioHashTable.insertar((Usuario) usuarioNode.getKey());
    }
}
