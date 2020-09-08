package model;


import java.io.Serializable;

public class Empleado implements Serializable {

    private String nombre;
    private Integer DNI;
    private Integer codigoEmpleado;
    private Cargo cargo;
    private String pwd;

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", DNI=" + DNI +
                ", codigoEmpleado=" + codigoEmpleado +
                ", cargo='" + cargo + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public boolean correctPwd(String pwd) {
        return this.pwd.equals(pwd);
    }

    public Empleado(String nombre, Integer DNI, Integer codigoEmpleado, Cargo cargo, String pwd) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
        this.pwd = pwd;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDNI() {
        return DNI;
    }

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


}
