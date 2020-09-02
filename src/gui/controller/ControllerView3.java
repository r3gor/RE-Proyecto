package gui.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import registradorcitas.Administrador;

public class ControllerView3 {
    public PasswordField pfPwd;
    public Button btnContinuar;

    public void clickBtnContinuar(ActionEvent actionEvent) {
        if (Administrador.validLoginAdm(pfPwd.getText())){
            System.out.println("Adm logeado!");
        } else {
            System.out.println("Adm. pwd incorrecta");
        }
    }
}
