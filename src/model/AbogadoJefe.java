package model;

import java.io.Serializable;
import java.util.ArrayList;

public class AbogadoJefe extends Empleado implements Serializable {
    static private ListaPersistente<CitaOrdinaria> listaCitasOrdinarias = new ListaPersistente<>(ListaPersistente.CIT_ORD);
    static private ListaPersistente<CitaCaso> listaCitasCaso = new ListaPersistente<>(ListaPersistente.CIT_CAS);

    public AbogadoJefe(String nombre, Integer DNI, Integer codigoEmpleado, Cargo cargo, String pwd) {
        super(nombre, DNI, codigoEmpleado, cargo, pwd);
    }

    static public CitaOrdinaria findCitaOrd(int DNI) throws Exception {
        ArrayList<CitaOrdinaria> citasOrd = listaCitasOrdinarias.getLista();
        for (CitaOrdinaria cita : citasOrd) {
            if (cita.getDNI().equals(DNI)) {
                return cita;
            }
            System.out.println(cita.getDNI() + " no es el buscado");
        }
        return null;
    }

    static public void addCitaCaso(CitaCaso citaCaso) throws Exception {
        listaCitasCaso.add(citaCaso);
    }

    static public void deleteCitaCaso(CitaCaso citaCaso) throws Exception {
        listaCitasCaso.delete(citaCaso);
    }

    static public ArrayList<CitaCaso> getListaCitasCaso() throws Exception {
        return listaCitasCaso.getLista();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
