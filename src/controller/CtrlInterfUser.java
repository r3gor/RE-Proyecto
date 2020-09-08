package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Administrador;
import model.Cargo;

import java.io.IOException;

public class CtrlInterfUser {
    public Button btnRegistrarCita;
    public Button btnMostrarCitasOrd;
    public Button btnCerrarSesion;
    public Label lblInfoUser;

    public static Stage stageRegisCita;
    public Button btnMostrarCitasCaso;

    @FXML
    public void initialize() {
        lblInfoUser.setText("Cargo: " + CtrlLogin.cargoEmpLogeado);
        if (CtrlLogin.empLogeado.getCargo() == Cargo.RECEPCIONISTA) {
            btnMostrarCitasCaso.setVisible(false);
        }
    }

    public void clickBtnCerrarSesion(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        btnCerrarSesion.getScene().setRoot(root);
    }

    public void clickBtnMostrarCitasOrd(ActionEvent actionEvent) throws Exception {
        Stage stageViewCita = new Stage();
        stageViewCita.setTitle("Citas Ordinarias");
        Parent root = FXMLLoader.load(getClass().getResource("/view/ShowCitasOrd.fxml"));
        stageViewCita.setScene(new Scene(root));
        stageViewCita.show();
    }

    public void clickBtnMostrarCitasCaso(ActionEvent actionEvent) throws IOException {
        Stage stageViewCita = new Stage();
        stageViewCita.setTitle("Citas Ordinarias");
        Parent root = FXMLLoader.load(getClass().getResource("/view/ShowCitasCaso.fxml"));
        stageViewCita.setScene(new Scene(root));
        stageViewCita.show();
    }

    public void clickBtnRegistrarCita(ActionEvent actionEvent) throws IOException {
        stageRegisCita = new Stage();
        stageRegisCita.setTitle("Crear cita ordinaria");

        if (Administrador.getEmpLogeado().getCargo() == Cargo.RECEPCIONISTA) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/RegisCitaOrd.fxml"));
            stageRegisCita.setScene(new Scene(root));

        }
        if (Administrador.getEmpLogeado().getCargo() == Cargo.ABOG_JEFE) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/RegisCitaCasoPtBuscar.fxml"));
            stageRegisCita.setScene(new Scene(root));
        }

        stageRegisCita.show();
    }


}
