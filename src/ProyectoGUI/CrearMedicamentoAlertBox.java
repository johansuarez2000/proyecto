package ProyectoGUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CrearMedicamentoAlertBox implements Initializable {
    @FXML private Button guardarButton;
    @FXML private Button cancelarButton;
    @FXML private TextField nombreTextField;
    @FXML private TextField dosisTextField;
    @FXML private TextField vecesDiaTextField;
    @FXML private TextField vecesSemanaTextField;

    public Button getGuardarButton() {
        return guardarButton;
    }

    public TextField getNombreTextField() {
        return nombreTextField;
    }

    public Button getCancelarButton() {
        return cancelarButton;
    }

    public TextField getDosisTextField() {
        return dosisTextField;
    }

    public TextField getVecesDiaTextField() {
        return vecesDiaTextField;
    }

    public TextField getVecesSemanaTextField() {
        return vecesSemanaTextField;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
