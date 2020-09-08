package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AbogadoJefe;
import model.CitaCaso;

public class CtrlShowCitaCaso {
    public TableView<CitaCaso> tvCitasCaso;
    public TableColumn<String, CitaCaso> tcNombre;
    public TableColumn<String, CitaCaso> tcDNI;
    public TableColumn<String, CitaCaso> tcCelular;
    public TableColumn<String, CitaCaso> tcFecha;
    public TableColumn<String, CitaCaso> tcCaso;
    public TableColumn<String, CitaCaso> tcAbogEspec;

    @FXML
    public void initialize() throws Exception {
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        tcDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
        tcCelular.setCellValueFactory(new PropertyValueFactory<>("contactoCelular"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        tcCaso.setCellValueFactory(new PropertyValueFactory<>("caso"));
        tcAbogEspec.setCellValueFactory(new PropertyValueFactory<>("abogadoEspecialista"));
        tvCitasCaso.getItems().addAll(AbogadoJefe.getListaCitasCaso());
    }
}
