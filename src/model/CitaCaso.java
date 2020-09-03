package model;

import java.io.Serializable;
import java.util.Date;

public class CitaCaso implements Serializable {
    private String nombreCliente;
    private Integer DNI;
    private String contactoCelular; // TODO: Convert to class Cliente.d
    private Date fechaCita;
    private String caso;
    private String abogadoEspecialista; // TODO: convert to class Abogado.

    public CitaCaso(String nombreCliente, Integer DNI, String contactoCelular, Date fechaCita, String caso, String abogadoEspecialista) {
        this.nombreCliente = nombreCliente;
        this.DNI = DNI;
        this.contactoCelular = contactoCelular;
        this.fechaCita = fechaCita;
        this.caso = caso;
        this.abogadoEspecialista = abogadoEspecialista;
    }

    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj)
            return true;
        // null check
        if (obj == null)
            return false;
        // type check and cast
        if (getClass() != obj.getClass())
            return false;
        CitaCaso citaObj = (CitaCaso) obj;
        return nombreCliente.equals(((CitaCaso) obj).nombreCliente) &&
                DNI.equals(((CitaCaso) obj).DNI) &&
                contactoCelular.equals(((CitaCaso) obj).contactoCelular) &&
                //fechaCita.equals(((CitaOrdinaria) obj).fechaCita) &&
                caso.equals(((CitaCaso) obj).caso) &&
                abogadoEspecialista.equals(((CitaCaso) obj).abogadoEspecialista);
    }

    @Override
    public String toString() {
        return "CitaCaso{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", DNI=" + DNI +
                ", contactoCelular='" + contactoCelular + '\'' +
                ", fechaCita=" + fechaCita +
                ", caso='" + caso + '\'' +
                ", abogadoEspecialista='" + abogadoEspecialista + '\'' +
                '}';
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public String getContactoCelular() {
        return contactoCelular;
    }

    public void setContactoCelular(String contactoCelular) {
        this.contactoCelular = contactoCelular;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getCaso() {
        return caso;
    }

    public void setCaso(String caso) {
        this.caso = caso;
    }

    public String getAbogadoEspecialista() {
        return abogadoEspecialista;
    }

    public void setAbogadoEspecialista(String abogadoEspecialista) {
        this.abogadoEspecialista = abogadoEspecialista;
    }
}
