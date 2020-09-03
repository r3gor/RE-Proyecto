package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Administrador;
import model.Empleado;

import java.util.ArrayList;

public class ControllerMuestraUsuarios {
    public TableView<Empleado> tvEmpleados;
    public TableColumn<String, Empleado> cNombre;
    public TableColumn<Integer, Empleado> cDNI;
    public TableColumn<Integer, Empleado> cCodigo;
    public TableColumn<String, Empleado> cCargo;
    public TableColumn<String, Empleado> cContrasegna;

    @FXML
    public void initialize() throws Exception {
        ArrayList<Empleado> listaEmp = Administrador.getEmpleados();
        //cNombre = new TableColumn<>("Nombre");
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //cDNI = new TableColumn<>("DNI");
        cDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));

        //cCodigo = new TableColumn<>("Codigo");
        cCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoEmpleado"));

        //cCargo = new TableColumn<>("Cargo");
        cCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

        //cContrasegna = new TableColumn<>("Contraseña");
        cContrasegna.setCellValueFactory(new PropertyValueFactory<>("pwd"));

        tvEmpleados.getItems().addAll(listaEmp);
    }
}
