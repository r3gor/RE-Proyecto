package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerView1 {
    public void clickBtnIngresar(ActionEvent actionEvent) throws IOException {
        System.out.println("[LOG]\t Ingresar clickeado.");
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(ControllerView1.class.getResource("/gui/view/View2.fxml"));
        primaryStage.setTitle("View 2 - Ingresar al sistema");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void clickBtnRegistrar(ActionEvent actionEvent) throws IOException {
        System.out.println("[LOG]\t Resistrar clickeado.");
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(ControllerView1.class.getResource("/gui/view/View3.fxml"));
        primaryStage.setTitle("View 3 - Registrar");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
