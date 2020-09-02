package registradorcitas;

public class Recepcionista extends Empleado {
    ListaPersistente<CitaOrdinaria> listaCitasOrdinarias = new ListaPersistente<>(ListaPersistente.CIT_ORD);

    public Recepcionista(String nombre, Integer DNI, Integer codigoEmpleado, String cargo, String pwd) {
        super(nombre, DNI, codigoEmpleado, cargo, pwd);
    }

    public void addCitaOrd(CitaOrdinaria citaOrd) throws Exception {
        listaCitasOrdinarias.add(citaOrd);
    }

    public void deleteCitaOrd(CitaOrdinaria citaOrd) throws Exception {
        listaCitasOrdinarias.delete(citaOrd);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
