package gui.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import registradorcitas.AbogadoJefe;
import registradorcitas.Administrador;
import registradorcitas.Recepcionista;

import java.io.IOException;

public class ControllerView4 {
    public TextField tfNombre;
    public TextField tfDNI;
    public TextField tfCdigo;
    public PasswordField pfPwd;
    public ChoiceBox cbCargo;
    public Button btnRegistrar;

    public Integer CARGO;
    public Button btnImpRegistrados;
    public Button btnAtras;

    @FXML
    public void initialize() {
        cbCargo.setItems(FXCollections.observableArrayList("Abogado Jefe", "Recepcionista"));
        cbCargo.getSelectionModel().selectedIndexProperty().addListener((ov, valie, new_value) -> CARGO = new_value.intValue());
    }

    public void clickBtnRegistrar(ActionEvent actionEvent) throws Exception {
        if (CARGO == Administrador.ABOG_JEF) {
            Administrador.addAbogadoJefe(
                    new AbogadoJefe(tfNombre.getText(), Integer.parseInt(tfDNI.getText()), Integer.parseInt(tfCdigo.getText()), "Abogado Jefe", pfPwd.getText())
            );
        }
        if (CARGO == Administrador.RECEP) {
            Administrador.addRecepcionista(
                    new Recepcionista(tfNombre.getText(), Integer.parseInt(tfDNI.getText()), Integer.parseInt(tfCdigo.getText()), "Recepcionista", pfPwd.getText())
            );
        }
    }

    public void clickBtnImpRegistrados(ActionEvent actionEvent) throws Exception {
        Administrador.listaAbogJefes.printLista();
        Administrador.listaRecepcionistas.printLista();
    }

    public void clickBtnAtras(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(ControllerView1.class.getResource("/gui/view/View1.fxml"));
        btnAtras.getScene().setRoot(root);
    }
}
