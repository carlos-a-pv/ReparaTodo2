package controlador;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class CrearOrdenController {

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfProducto;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private ComboBox<String> cbClientes;

    ModelFactoryController modelFactoryController;

    @FXML
    void initialize(){
        modelFactoryController = ModelFactoryController.getInstance();
        cbClientes.setItems(modelFactoryController.getClientes());

        tfId.setText(modelFactoryController.generarId());
        tfId.setDisable(true);
    }


    public void onClickRegistrar(ActionEvent actionEvent) {
        Orden newOrden = new Orden();
        newOrden.setId(tfId.getText());
        newOrden.setCliente(modelFactoryController.buscarCliente(cbClientes.getValue()));
        newOrden.setFecha = LocalDate.now();
        newOrden.setEstado(Estado.CREADA);
        newOrden.setProducto(tfProducto.getText());
        newOrden.setDescripcion(tfDescripcion.getText());
        boolean resultado = modelFactoryController.crearOrden(newOrden);

        if(!resultado){
            mostrarMensaje();
        }


    }

    public void onClickCancelar(ActionEvent actionEvent) {


    }
}
