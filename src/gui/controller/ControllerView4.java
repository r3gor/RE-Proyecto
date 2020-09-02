package gui.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import registradorcitas.AbogadoJefe;
import registradorcitas.Administrador;
import registradorcitas.Recepcionista;

public class ControllerView4 {
    public TextField tfNombre;
    public TextField tfDNI;
    public TextField tfCdigo;
    public PasswordField pfPwd;
    public ChoiceBox cbCargo;
    public Button btnRegistrar;

    public Integer CARGO;
    public Button btnImpRegistrados;

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
}
