package model;

import java.util.ArrayList;

public class Administrador {
    public static ListaPersistente<AbogadoJefe> listaAbogJefes = new ListaPersistente<>(ListaPersistente.ABO_JEF);
    public static ListaPersistente<Recepcionista> listaRecepcionistas = new ListaPersistente<>(ListaPersistente.RECEP);
    public static Empleado empLogeado = null;

    public Administrador() {
    }

    public static boolean validLoginAdm(String pwd) {
        String key_adm = "Th3cur3";
        return key_adm.equals(pwd);
    }

    public static Empleado getEmpLogeado() {
        return empLogeado;
    }

    public static boolean validLogin(int cod, String pwd, Cargo cargo) throws Exception {
        listaAbogJefes.loadLista();
        if (cargo == Cargo.ABOG_JEFE) {
            for (AbogadoJefe aj : listaAbogJefes.getLista()) {
                if (aj.getCodigoEmpleado() == cod) {
                    empLogeado = aj;
                    System.out.println("Codigo encontrado");
                    return aj.correctPwd(pwd);
                }
            }
            System.out.println("Codigo no encontrado en ABO_JEF");
            return false;
        }
        if (cargo == Cargo.RECEPCIONISTA) {
            for (Recepcionista r : listaRecepcionistas.getLista()) {
                if (r.getCodigoEmpleado() == cod) {
                    empLogeado = r;
                    return r.correctPwd(pwd);
                }
            }
            System.out.println("Codigo no encontrado en RECEP");
            return false;
        } else {
            System.out.println("valor TYPE incorrecto");
        }
        empLogeado = null;
        return false;
    }

    public static void addAbogadoJefe(AbogadoJefe abog) throws Exception {
        listaAbogJefes.add(abog);
    }

    public static void addRecepcionista(Recepcionista recep) throws Exception {
        listaRecepcionistas.add(recep);
    }

    public static ArrayList<Empleado> getEmpleados() throws Exception {
        ArrayList<Empleado> listaEmp = new ArrayList<>();
        ArrayList<AbogadoJefe> listAbogJef = listaAbogJefes.getLista();
        for (AbogadoJefe o : listAbogJef) {
            listaEmp.add(new Empleado(o.getNombre(), o.getDNI(), o.getCodigoEmpleado(), o.getCargo(), o.getPwd()));
        }
        ArrayList<Recepcionista> listRecep = listaRecepcionistas.getLista();
        for (Recepcionista o : listRecep) {
            listaEmp.add(new Empleado(o.getNombre(), o.getDNI(), o.getCodigoEmpleado(), o.getCargo(), o.getPwd()));
        }
        return listaEmp;
    }
}
