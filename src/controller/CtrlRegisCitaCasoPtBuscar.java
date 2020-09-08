package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.AbogadoJefe;
import model.CitaCaso;
import model.CitaOrdinaria;

import java.io.IOException;

public class CtrlRegisCitaCasoPtBuscar {
    public Button btnAtras;
    public Button btnNuevaCita;
    public TextArea taInfoCliente;
    public Button btnBuscar;
    public TextField tfDNI;
    public Label lblCaso;
    public TextField tfCaso;
    public Label lblAbogCaso;
    public TextField tfAbogCaso;
    public Label lblFecha;
    public DatePicker dpFecha;

    CitaOrdinaria citaOrd = null;

    public void setVisibleWinAsignarCitaCaso(boolean val) {
        lblCaso.setVisible(val);
        tfCaso.setVisible(val);
        lblAbogCaso.setVisible(val);
        tfAbogCaso.setVisible(val);
        lblFecha.setVisible(val);
        dpFecha.setVisible(val);
    }

    @FXML
    public void initialize() {
        setVisibleWinAsignarCitaCaso(false);
    }

    public void clickBtnNuevaCita(ActionEvent actionEvent) throws Exception {
        if (citaOrd != null) {
            System.out.println("[click]\t Nueva cita");
            String caso = tfCaso.getText();
            String abogEspAsignado = tfAbogCaso.getText();
            AbogadoJefe.addCitaCaso(new CitaCaso(citaOrd.getNombreCliente(), citaOrd.getDNI(), citaOrd.getContactoCelular(),
                    java.sql.Date.valueOf(dpFecha.getValue()), caso, abogEspAsignado));
        }
    }

    public void clickBtnAtras(ActionEvent actionEvent) throws IOException {
        CtrlInterfUser.stageRegisCita.close();
    }

    public void clickBtnBuscar(ActionEvent actionEvent) throws Exception {
        citaOrd = AbogadoJefe.findCitaOrd(Integer.parseInt(tfDNI.getText()));
        if (citaOrd != null) {
            taInfoCliente.setText(citaOrd.toString());
            setVisibleWinAsignarCitaCaso(true);
        } else {
            taInfoCliente.setText("Cita no encontrada...");
            setVisibleWinAsignarCitaCaso(false);
        }
    }
}
