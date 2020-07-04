package ProyectoGUI;

import javafx.beans.Observable;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyecto.Avl_Node;
import proyecto.NodoHash;
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

    private NodoHash<Usuario> usuario;
    private CrearMedicamentoAlertBox crearMedicamentoAlertBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        crearMedicamentoAlertBox = new CrearMedicamentoAlertBox();
        medicamentoNombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        medicamentoDosisColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        medicamentoVecesDiaColumn.setCellValueFactory(new PropertyValueFactory<>("veces_dia"));
        medicamentoVecesSemanaColumn.setCellValueFactory(new PropertyValueFactory<>("veces_semana"));
        tabla.setEditable(true);
        medicamentoNombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public  void cargarMedicamentosEnTabla() {
        ObservableList<medicamento>  medicamentos=FXCollections.observableArrayList();
        for(int i=0; i<this.usuario.getKey().getMedicamentos().getSize();i++){
            medicamentos.add(this.usuario.getKey().getMedicamentos().get(i));
            System.out.println(this.usuario.getKey().getMedicamentos().get(i));
        }
        tabla.setItems(medicamentos);
    }

    public void cerrarSesion (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("IniciarSesion.fxml"));
        Parent registro = loader.load();
        IniciarSesionController controller = loader.getController();
        controller.updateUserInDatabase(usuario);
        Scene iniciarSesionScene= new Scene (registro);
        iniciarSesionScene.getStylesheets().add("stylesheets/styles.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(iniciarSesionScene);
        window.show();
    }
    public void initUserData(NodoHash usuario){
        this.usuario=usuario;
        cargarMedicamentosEnTabla();
    }

    public void addMedicamento(ActionEvent event) throws  IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CrearMedicamentoAlertBox.fxml"));
        Parent registroParent = loader.load();
        Scene iniciarSesionScene= new Scene (registroParent);
        crearMedicamentoAlertBox = loader.getController();

        Stage window = new Stage();
        crearMedicamentoAlertBox.getGuardarButton().setOnAction(e->{
            String nombreMedicamento= crearMedicamentoAlertBox.getNombreTextField().getText();
            int dosis = Integer.parseInt(crearMedicamentoAlertBox.getDosisTextField().getText());
            int vecesDia = Integer.parseInt(crearMedicamentoAlertBox.getVecesDiaTextField().getText());
            int vecesSemana = Integer.parseInt(crearMedicamentoAlertBox.getVecesSemanaTextField().getText());
            medicamento nuevo = new medicamento(nombreMedicamento,dosis,vecesDia,vecesSemana);
            usuario.getKey().getMedicamentos().add(nuevo);
            cargarMedicamentosEnTabla();
            window.close();
        });
        crearMedicamentoAlertBox.getCancelarButton().setOnAction(e->{
            window.close();
        });

        window.setTitle("Alarmédica");
        Image icono = new Image("/Imagenes/medico.png");
        window.getIcons().add(icono);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(iniciarSesionScene);
        window.showAndWait();
    }
    public void deleteMedicamento(){

        ObservableList <medicamento> todos, seleccion;
        todos= tabla.getItems();
        seleccion=tabla.getSelectionModel().getSelectedItems();

        for(int i=0; i<this.usuario.getKey().getMedicamentos().getSize();i++){
            for (proyecto.medicamento medicamento : seleccion) {
                if (this.usuario.getKey().getMedicamentos().get(i).equals(medicamento)) {
                    usuario.getKey().getMedicamentos().remove(i);
                }
            }
        }
        cargarMedicamentosEnTabla();
    }
    public void changeNombreMedicamento(TableColumn.CellEditEvent cellEditEvent){
        tabla.getSelectionModel().getSelectedItem().setNombre(cellEditEvent.getNewValue().toString());
    }
}
