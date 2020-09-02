package gui.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import registradorcitas.Administrador;

public class ControllerView2 {
    public ChoiceBox choiseBoxCargo;
    public int CARGO;
    public int codigo;
    public String password;
    public Button btnSiguiente;
    public TextField etCodigo;
    public PasswordField etPwd;

    @FXML
    public void initialize() {
        choiseBoxCargo.setItems(FXCollections.observableArrayList("Abogado Jefe", "Recepcionista"));
        choiseBoxCargo.getSelectionModel().selectedIndexProperty().addListener((ov, valie, new_value) -> CARGO = new_value.intValue());
    }

    public void clickBtnSgte(ActionEvent actionEvent) throws Exception {
        codigo = Integer.parseInt(etCodigo.getText());
        password = etPwd.getText();
        System.out.println("Codigo: " + codigo);
        System.out.println("Pwd: " + password);
        System.out.println("Cargo: " + CARGO);
        if (Administrador.validLogin(codigo, password, CARGO)){
            System.out.println("Login valido");
        } else {
            System.out.println("Login invalido");
        }
    }
}
