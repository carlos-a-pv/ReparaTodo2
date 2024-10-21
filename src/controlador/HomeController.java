package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("producto"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("estado"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("pago"));


        ordeSelecionada = tbOrdenes.getSelectionModel().getSelectedItem();
    }


    public void onClickCrearOrden(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/vista/crear-orden.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 300);
        Stage stage = new Stage();
        stage.setTitle("Crear orden");
        stage.setScene(scene);
        stage.initOwner(btnCrearOrden.getScene().getWindow());
        stage.show();
    }

    public void onClickBuscar(ActionEvent actionEvent) {
    }

    public void onClickCrearCliente(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/vista/crear-cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 300);
        Stage stage = new Stage();
        stage.setTitle("Crear Cliente");
        stage.setScene(scene);
        stage.initOwner(btnCrearCliente.getScene().getWindow());
        stage.show();
    }
}
