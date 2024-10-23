package controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Orden;
import modelo.Pago;
import modelo.enums.Estado;
import java.io.IOException;
import java.time.LocalDate;

public class HomeController {

    @FXML
    private TableView<Orden> tbOrdenes;
    @FXML
    private TableColumn<Orden, String> colId;
    @FXML
    private TableColumn<Orden, String> colProducto;
    @FXML
    private TableColumn<Orden, String> colCliente;
    @FXML
    private TableColumn<Orden, LocalDate> colFecha;
    @FXML
    private TableColumn<Orden, Estado> colEstado;
    @FXML
    private TableColumn<Orden, String> colDescripcion;
    @FXML
    private TableColumn<Orden, Pago> colPago;
    @FXML
    private Button btnCrearOrden;
    @FXML
    private Button btnCrearCliente;


    ModelFactoryController modelFactoryController;
    Orden ordeSelecionada;

    @FXML
    void initialize(){
        modelFactoryController = ModelFactoryController.getInstance();

        this.colId.setCellValueFactory(new PropertyValueFactory<>("idOrden"));
        this.colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        this.colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        this.colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcionAveria"));
        this.colPago.setCellValueFactory(new PropertyValueFactory<>("pago"));


        ordeSelecionada = tbOrdenes.getSelectionModel().getSelectedItem();

        tbOrdenes.setItems(FXCollections.observableList(modelFactoryController.getOrdenes()));

        tbOrdenes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                ordeSelecionada = newValue;
                mostrarInfoOrden();
            }
        });
    }

    private void mostrarInfoOrden() {

    }


    public void onClickCrearOrden(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/vista/crear-orden.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 300);
        Stage stage = new Stage();
        stage.setTitle("Crear orden");
        stage.setScene(scene);
        stage.initOwner(btnCrearOrden.getScene().getWindow());
        stage.show();
    }

    public void onClickBuscar(ActionEvent actionEvent) {
    }

    public void onClickCrearCliente(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/vista/crear-cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 300);
        Stage stage = new Stage();
        stage.setTitle("Crear Cliente");
        stage.setScene(scene);
        stage.initOwner(btnCrearCliente.getScene().getWindow());
        stage.show();
    }
}
