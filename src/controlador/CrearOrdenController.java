package controlador;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Cliente;
import modelo.Orden;
import modelo.enums.Estado;

import java.time.LocalDate;

import static javafx.collections.FXCollections.observableList;

public class CrearOrdenController {

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfProducto;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private ComboBox<Cliente> cbClientes;
    @FXML
    private Button btnRegistrar, btnCancelar;

    ModelFactoryController modelFactoryController;

    @FXML
    void initialize(){
        modelFactoryController = ModelFactoryController.getInstance();
        cbClientes.setItems(FXCollections.observableList(modelFactoryController.getClientes()));

        tfId.setText(modelFactoryController.generarId());
        tfId.setDisable(true);
    }


    public void onClickRegistrar(ActionEvent actionEvent) {
        Orden newOrden = new Orden();
        newOrden.setIdOrden(tfId.getText());
        newOrden.setCliente(modelFactoryController.buscarCliente(cbClientes.getValue().idCliente));
        newOrden.setFechaCreacion( LocalDate.now());
        newOrden.setEstado(Estado.RECEPCIONADA);
        newOrden.setProducto(tfProducto.getText());
        newOrden.setDescripcionAveria(tfDescripcion.getText());
        boolean resultado = modelFactoryController.crearOrden(newOrden);

        if(resultado){
            mostrarMensaje("Crear orden","Crear orden","Se ha creado la orden correctamente", Alert.AlertType.INFORMATION);
        }
        else{
            mostrarMensaje("Crear orden", "Crear orden", "No se ha podido crear la orden", Alert.AlertType.ERROR);
        }

        limpiarCampos();
        btnRegistrar.getScene().getWindow().hide();


    }

    private void limpiarCampos() {
        tfId.clear();
        tfProducto.clear();
        tfDescripcion.clear();
        cbClientes.getSelectionModel().clearSelection();


    }

    public void onClickCancelar(ActionEvent actionEvent) {
        btnCancelar.getScene().getWindow().hide();


    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }


}
