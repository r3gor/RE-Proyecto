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

import java.io.IOException;

public class ControllerView2 {
    public ChoiceBox choiseBoxCargo;
    public int CARGO;
    public int codigo;
    public String password;
    public Button btnSiguiente;
    public TextField etCodigo;
    public PasswordField etPwd;
    public Button btnAtras;
    static String cargoEmpLogeado;

    private String CARGOS[] = {"Abogado Jefe", "Recepcionista"};

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
        if (Administrador.validLogin(codigo, password, CARGO)) {
            cargoEmpLogeado = CARGOS[CARGO];
            System.out.println("Login valido");
            Parent root = FXMLLoader.load(getClass().getResource("/view/ViewInterfEmp.fxml"));
            btnSiguiente.getScene().setRoot(root);
        } else {
            System.out.println("Login invalido");
        }
    }

    public void clickBtnAtras(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/View1.fxml"));
        btnAtras.getScene().setRoot(root);
    }
}
