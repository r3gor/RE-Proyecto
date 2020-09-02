package registradorcitas;

import java.io.Serializable;

public class AbogadoJefe extends Empleado implements Serializable {
    private ListaPersistente<CitaOrdinaria> listaCitasOrdinarias = new ListaPersistente<>(ListaPersistente.CIT_ORD);
    private ListaPersistente<CitaCaso> listaCitasCaso = new ListaPersistente<>(ListaPersistente.CIT_CAS);

    public AbogadoJefe(String nombre, Integer DNI, Integer codigoEmpleado, String cargo, String pwd) {
        super(nombre, DNI, codigoEmpleado, cargo, pwd);
    }

    public void addCitaCaso(CitaCaso citaCaso) throws Exception {
        listaCitasCaso.add(citaCaso);
    }

    public void deleteCitaCaso(CitaCaso citaCaso) throws Exception {
        listaCitasCaso.delete(citaCaso);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
