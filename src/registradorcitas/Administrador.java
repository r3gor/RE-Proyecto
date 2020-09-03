package registradorcitas;

import java.util.ArrayList;

public class Administrador {
    public static final int RECEP = 1;
    public static final int ABOG_JEF = 0;
    public static ListaPersistente<AbogadoJefe> listaAbogJefes = new ListaPersistente<>(ListaPersistente.ABO_JEF);
    public static ListaPersistente<Recepcionista> listaRecepcionistas = new ListaPersistente<>(ListaPersistente.RECEP);

    public Administrador() {
    }

    public static boolean validLoginAdm(String pwd) {
        String key_adm = "Th3cur3";
        return key_adm.equals(pwd);
    }

    public static boolean validLogin(int cod, String pwd, int CARGO) throws Exception {
        listaAbogJefes.loadLista();
        System.out.println(":::here:::");
        if (CARGO == ABOG_JEF) {
            for (AbogadoJefe aj : listaAbogJefes.getLista()) {
                if (aj.getCodigoEmpleado() == cod) {
                    System.out.println("Codigo encontrado");
                    return aj.correctPwd(pwd);
                }
            }
            System.out.println("Codigo no encontrado en ABO_JEF");
            return false;
        }
        if (CARGO == RECEP) {
            System.out.println("Buscando Recep");
            for (Recepcionista r : listaRecepcionistas.getLista()) {
                if (r.getCodigoEmpleado() == cod) {
                    return r.correctPwd(pwd);
                }
            }
            System.out.println("Codigo no encontrado en RECEP");
            return false;
        } else {
            System.out.println("valor TYPE incorrecto");
        }

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
