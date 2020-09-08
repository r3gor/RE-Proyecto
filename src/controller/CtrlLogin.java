package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Administrador;
import model.Cargo;
import model.Empleado;

import java.io.IOException;

public class CtrlLogin {
    public ChoiceBox choiseBoxCargo;
    public int idxCargo;
    public int codigo;
    public String password;
    public Button btnSiguiente;
    public TextField etCodigo;
    public PasswordField etPwd;
    public Button btnAtras;

    public static Cargo cargoEmpLogeado;
    public static Empleado empLogeado;

    @FXML
    public void initialize() {
        choiseBoxCargo.setItems(FXCollections.observableArrayList(Cargo.values())); // same order of Enum Cargo
        choiseBoxCargo.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> idxCargo = new_value.intValue());
    }

    public void clickBtnSgte(ActionEvent actionEvent) throws Exception {
        codigo = Integer.parseInt(etCodigo.getText());
        password = etPwd.getText();
        System.out.println("Codigo: " + codigo);
        System.out.println("Pwd: " + password);
        System.out.println("Cargo: " + Cargo.values()[idxCargo]);
        if (Administrador.validLogin(codigo, password, Cargo.values()[idxCargo])) {
            empLogeado = Administrador.getEmpLogeado();
            cargoEmpLogeado = Cargo.values()[idxCargo];
            System.out.println("Login valido");
            Parent root = FXMLLoader.load(getClass().getResource("/view/InterfUser.fxml"));
            btnSiguiente.getScene().setRoot(root);
        } else {
            System.out.println("Login invalido");
        }
    }

    public void clickBtnAtras(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/InitWin.fxml"));
        btnAtras.getScene().setRoot(root);
    }
}
