package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import registradorcitas.Administrador;

import java.io.IOException;

public class ControllerView3 {
    public PasswordField pfPwd;
    public Button btnContinuar;

    public void clickBtnContinuar(ActionEvent actionEvent) throws IOException {
        if (Administrador.validLoginAdm(pfPwd.getText())) {
            System.out.println("Adm logeado!");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ControllerView1.class.getResource("/gui/view/View4.fxml"));
            primaryStage.setTitle("View 4 - Registrar");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } else {
            System.out.println("Adm. pwd incorrecta");
        }
    }
}
