package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.AbogadoJefe;
import model.CitaOrdinaria;

public class CtrlRegisCitaCasoPtBuscar {
    public Button btnAtras;
    public Button btnNuevaCita;
    public TextArea taInfoCliente;
    public Button btnBuscar;
    public TextField tfDNI;

    CitaOrdinaria citaOrd = null;

    public void clickBtnNuevaCita(ActionEvent actionEvent) {
        if (citaOrd != null) {
            System.out.println("[click]\t Nueva cita");
        }
    }

    public void clickBtnAtras(ActionEvent actionEvent) {
    }

    public void clickBtnBuscar(ActionEvent actionEvent) throws Exception {
        citaOrd = AbogadoJefe.findCitaOrd(Integer.parseInt(tfDNI.getText()));
        if (citaOrd != null) {
            taInfoCliente.setText(citaOrd.toString());
        } else {
            taInfoCliente.setText("Cita no encontrada...");
        }
    }
}
