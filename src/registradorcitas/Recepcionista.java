package registradorcitas;

import java.util.ArrayList;

public class Recepcionista extends Empleado {
    ListaCitasOrdinarias listaCitasOrdinarias;

    public Recepcionista(String nombre, Integer DNI, Integer codigoEmpleado, String cargo, String pwd) {
        super(nombre, DNI, codigoEmpleado, cargo, pwd);
        listaCitasOrdinarias = new ListaCitasOrdinarias("citas_ordinarias.dat");
    }

    public void creaNuevaCita(CitaOrdinaria citaOrdinaria) throws Exception{
        listaCitasOrdinarias.addCitaOrdinaria(citaOrdinaria);
    }

    public void editaCita(CitaOrdinaria c1, CitaOrdinaria c2) throws Exception{
        listaCitasOrdinarias.replaceCitaOrdinaria(c1, c2);
    }

    public void eliminarCita(CitaOrdinaria cita) throws Exception{
        listaCitasOrdinarias.eliminarCitaOrdinaria(cita);
    }

    public void printCitas(){ // only for debug
        ArrayList<CitaOrdinaria> lista = listaCitasOrdinarias.getListaCitasOrdinarias();
        for(CitaOrdinaria cita : lista){
            System.out.println(cita);
        }
    }


}
