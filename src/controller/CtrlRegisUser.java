package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AbogadoJefe;
import model.Administrador;
import model.Cargo;
import model.Recepcionista;

import java.io.IOException;

public class CtrlRegisUser {
    public TextField tfNombre;
    public TextField tfDNI;
    public TextField tfCdigo;
    public PasswordField pfPwd;
    public ChoiceBox cbCargo;
    public Button btnRegistrar;

    public int idxCargo;
    public Button btnImpRegistrados;
    public Button btnAtras;

    @FXML
    public void initialize() {
        cbCargo.setItems(FXCollections.observableArrayList(Cargo.values()));
        cbCargo.getSelectionModel().selectedIndexProperty().addListener((ov, valie, new_value) -> idxCargo = new_value.intValue());
    }

    public void clickBtnRegistrar(ActionEvent actionEvent) throws Exception {
        Cargo cargoSeleccionado = Cargo.values()[idxCargo];
        if (cargoSeleccionado == Cargo.ABOG_JEFE) {
            Administrador.addAbogadoJefe(
                    new AbogadoJefe(tfNombre.getText(), Integer.parseInt(tfDNI.getText()), Integer.parseInt(tfCdigo.getText()), cargoSeleccionado, pfPwd.getText())
            );
        }
        if (cargoSeleccionado == Cargo.RECEPCIONISTA) {
            Administrador.addRecepcionista(
                    new Recepcionista(tfNombre.getText(), Integer.parseInt(tfDNI.getText()), Integer.parseInt(tfCdigo.getText()), cargoSeleccionado, pfPwd.getText())
            );
        }
    }

    public void clickBtnImpRegistrados(ActionEvent actionEvent) throws Exception {
        Administrador.listaAbogJefes.printLista();
        Administrador.listaRecepcionistas.printLista();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(CtrlInitWin.class.getResource("/view/ShowUsers.fxml"));
        primaryStage.setTitle("Usuarios registrados");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void clickBtnAtras(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(CtrlInitWin.class.getResource("/view/InitWin.fxml"));
        btnAtras.getScene().setRoot(root);
    }
}
