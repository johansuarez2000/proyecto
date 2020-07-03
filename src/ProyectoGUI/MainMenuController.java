package ProyectoGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import proyecto.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    private Usuario usuario;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void cerrarSesion (ActionEvent event) throws IOException {
        Parent registro = FXMLLoader.load(getClass().getResource("IniciarSesion.fxml"));
        Scene iniciarSesionScene= new Scene (registro);
        iniciarSesionScene.getStylesheets().add("stylesheets/styles.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(iniciarSesionScene);
        window.show();
    }
    public void initUserData(Usuario usuario){
        this.usuario=usuario;
    }
}
