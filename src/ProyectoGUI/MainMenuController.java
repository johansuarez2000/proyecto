package ProyectoGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proyecto.Avl_Node;
import proyecto.Usuario;
import proyecto.medicamento;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML private TableView<medicamento> tabla;
    @FXML private TableColumn<medicamento,String> medicamentoNombreColumn;
    @FXML private TableColumn<medicamento,String> medicamentoDosisColumn;
    @FXML private TableColumn<medicamento,String> medicamentoVecesDiaColumn;
    @FXML private TableColumn<medicamento,String> medicamentoVecesSemanaColumn;

    private Avl_Node<Usuario> usuario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        medicamentoNombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        medicamentoDosisColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        medicamentoVecesDiaColumn.setCellValueFactory(new PropertyValueFactory<>("veces_dia"));
        medicamentoVecesSemanaColumn.setCellValueFactory(new PropertyValueFactory<>("veces_semana"));
    }

    public  void cargarMedicamentosEnTabla() {
        ObservableList<medicamento>  medicamentos=FXCollections.observableArrayList();
        for(int i=0; i<this.usuario.getElement().getMedicamentos().getSize();i++){
            medicamentos.add(this.usuario.getElement().getMedicamentos().get(i));
        }
        tabla.setItems(medicamentos);
    }

    public void cerrarSesion (ActionEvent event) throws IOException {
        Parent registro = FXMLLoader.load(getClass().getResource("IniciarSesion.fxml"));
        Scene iniciarSesionScene= new Scene (registro);
        iniciarSesionScene.getStylesheets().add("stylesheets/styles.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(iniciarSesionScene);
        window.show();
    }
    public void initUserData(Avl_Node<Usuario> usuario){
        this.usuario=usuario;
        cargarMedicamentosEnTabla();
    }
}
