package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Cliente;

public class CrearClienteController {

    @FXML
    private TextField tfCedula;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfDireccion;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnRegistrarCliente;
    @FXML
    private Button btnCancelar;

    ModelFactoryController modelFactoryController;
    @FXML
    void initialize(){
        modelFactoryController = ModelFactoryController.getInstance();
    }


    public void onClickRegistrar(ActionEvent actionEvent) {
        String cedula = tfCedula.getText();
        String nombre = tfNombre.getText();
        String direccion = tfDireccion.getText();
        String telefono = tfTelefono.getText();
        String email = tfEmail.getText();

        if(validarCampos(cedula, nombre, direccion, telefono, email)){
            if(modelFactoryController.crearCliente(new Cliente(cedula, nombre, email, telefono, direccion))){
                mostrarMensaje("Registro cliente", "Accion existosa","Se ha registrado el cliente correctamente", Alert.AlertType.INFORMATION);
                btnRegistrarCliente.getScene().getWindow().hide();
            }
        }else{
            mostrarMensaje("Registro de cliente", "Error al registrar el cliente", "Lleno todos los campos", Alert.AlertType.ERROR);
        }
    }

    private boolean validarCampos(String cedula, String nombre, String direccion, String telefono, String email) {
        if(cedula.isEmpty()){
            return false;
        }
        if(nombre.isEmpty()){
            return false;
        }
        if(direccion.isEmpty()){
            return false;
        }
        if(telefono.isEmpty()){
            return false;
        }
        return !email.isEmpty();
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
