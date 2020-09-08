package model;

import java.util.ArrayList;

public class Recepcionista extends Empleado {
    private static ListaPersistente<CitaOrdinaria> listaCitasOrdinarias = new ListaPersistente<>(ListaPersistente.CIT_ORD);

    public Recepcionista(String nombre, Integer DNI, Integer codigoEmpleado, Cargo cargo, String pwd) {
        super(nombre, DNI, codigoEmpleado, cargo, pwd);
    }

    static public void addCitaOrd(CitaOrdinaria citaOrd) throws Exception {
        listaCitasOrdinarias.add(citaOrd);
    }

    static public void deleteCitaOrd(CitaOrdinaria citaOrd) throws Exception {
        listaCitasOrdinarias.delete(citaOrd);
    }

    static public ArrayList<CitaOrdinaria> getListaCitasOrd() throws Exception {
        return listaCitasOrdinarias.getLista();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
