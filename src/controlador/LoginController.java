package controlador;

import javafx.fxml.FXML;

public class LoginController {

    ModelFactoryController modelFactoryController;

    @FXML
    void initialize(){
        modelFactoryController = ModelFactoryController.getInstance();
    }
}
