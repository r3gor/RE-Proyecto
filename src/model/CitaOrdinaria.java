package model;

import java.io.Serializable;
import java.util.Date;

public class CitaOrdinaria implements Serializable {
    private String nombreCliente;
    private Integer DNI;
    private String contactoCelular; // TODO: Convert to class Cliente.d
    private Date fechaCita;
    private String abogadoAsistente; // TODO: convert to class Abogado.

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
        CitaOrdinaria citaObj = (CitaOrdinaria) obj;
        return nombreCliente.equals(((CitaOrdinaria) obj).nombreCliente) &&
                DNI.equals(((CitaOrdinaria) obj).DNI) &&
                contactoCelular.equals(((CitaOrdinaria) obj).contactoCelular) &&
                //fechaCita.equals(((CitaOrdinaria) obj).fechaCita) &&
                abogadoAsistente.equals(((CitaOrdinaria) obj).abogadoAsistente);
    }

    @Override
    public String toString() {
        return "\t[CitaOrdinaria] " + "\n" +
                "Nombre cliente: \t'" + nombreCliente + '\'' + "\n" +
                "DNI: \t" + DNI + "\n" +
                "Contacto celular: \t'" + contactoCelular + '\'' + "\n" +
                "Fecha cita: \t" + fechaCita + "\n" +
                "Abogado asistente: \t'" + abogadoAsistente + '\''
                ;
    }

    public CitaOrdinaria(String nombreCliente, Integer DNI, String contactoCelular, Date fechaCita, String abogadoAsistente) {
        this.nombreCliente = nombreCliente;
        this.DNI = DNI;
        this.contactoCelular = contactoCelular;
        this.fechaCita = fechaCita;
        this.abogadoAsistente = abogadoAsistente;
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

    public String getAbogadoAsistente() {
        return abogadoAsistente;
    }

    public void setAbogadoAsistente(String abogadoAsistente) {
        this.abogadoAsistente = abogadoAsistente;
    }
}
