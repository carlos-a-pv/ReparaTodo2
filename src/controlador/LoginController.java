package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView imgIcon;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfUser;

    @FXML
    void onClickLogin(ActionEvent event) throws IOException {
        if(tfUser.getText().equals("agente") && tfPassword.getText().equals("1234")){
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/vista/home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.initOwner(btnLogin.getScene().getWindow());
            btnLogin.getScene().getWindow().hide();
            stage.show();
       }
        else {
            mostrarMensaje("Login","Credenciales incorrectas","Verifique su usuario y contraseña", Alert.AlertType.ERROR);
            tfPassword.setText("");
            tfUser.setText("");
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

}
