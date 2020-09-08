package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CitaOrdinaria;
import model.Recepcionista;

public class CtrlShowCitasOrd {
    public TableView<CitaOrdinaria> tvCitasOrd;
    public TableColumn<String, CitaOrdinaria> tcNombre;
    public TableColumn<String, CitaOrdinaria> tcDNI;
    public TableColumn<String, CitaOrdinaria> tcCelular;
    public TableColumn<String, CitaOrdinaria> tcFecha;
    public TableColumn<String, CitaOrdinaria> tcAbogAsis;

    @FXML
    public void initialize() throws Exception {
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        tcDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
        tcCelular.setCellValueFactory(new PropertyValueFactory<>("contactoCelular"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        tcAbogAsis.setCellValueFactory(new PropertyValueFactory<>("abogadoAsistente"));
        tvCitasOrd.getItems().addAll(Recepcionista.getListaCitasOrd());
    }

}
