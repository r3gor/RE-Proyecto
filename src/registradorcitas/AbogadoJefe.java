package registradorcitas;

import java.io.Serializable;

public class AbogadoJefe extends Empleado implements Serializable {
    private ListaCitasOrdinarias listaCitasOrdinarias;
    private ListaCitaCaso listaCitaCaso;

    public AbogadoJefe(String nombre, Integer DNI, Integer codigoEmpleado, String cargo, String pwd) {
        super(nombre, DNI, codigoEmpleado, cargo, pwd);
    }

    public boolean existCitaOrdinaria(Integer DNI){
        return listaCitasOrdinarias.findCitaOrdinaria(DNI) != -1;
    }

    public CitaOrdinaria buscarCitaOrdinaria(Integer DNI){
        Integer idx = listaCitasOrdinarias.findCitaOrdinaria(DNI);
        if (idx == -1){
            return null;
        } else {
            return listaCitasOrdinarias.getCitaOrdinaria(idx);
        }
    }

    public void nuevaCitaCaso(CitaCaso cita) throws Exception{
        listaCitaCaso.addCitaCaso(cita);
    }
    public void editarCitaCaso(CitaCaso oldCita, CitaCaso newCita) throws Exception{
        listaCitaCaso.replaceCitaCaso(oldCita, newCita);
    }

}
