package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import registradorcitas.CitaOrdinaria;
import registradorcitas.Recepcionista;

import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception{

        launch(args);
        // test
        /*
        Date d = new Date();
        CitaOrdinaria newCita = new CitaOrdinaria("roger", 76011, "933231", new Date(), "srta. navarrete");
        CitaOrdinaria newCita2 = new CitaOrdinaria("tony", 76011, "933231", new Date(), "srta. navarrete");
        Recepcionista recepc = new Recepcionista("ramos", 1234, 1111, "Recepcionista");
        */
        //recepc.creaNuevaCita(newCita);
        //recepc.editaCita(newCita2, newCita);
        //recepc.eliminarCita(newCita);
        //recepc.printCitas();
    }
}
