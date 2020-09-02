package registradorcitas;

import java.io.*;
import java.util.ArrayList;

public class Administrador {
    public static final int RECEP = 1;
    public static final int ABOG_JEF = 0;
    static String fileAbogadosJefe = "abog_jef.dat";
    static String fileRecepcionistas = "recepcionistas.dat";
    static ArrayList<AbogadoJefe> listaAbogJefes = new ArrayList<>();
    static ArrayList<Recepcionista> listaRecepcionistas = new ArrayList<>();
    static private String key_adm = "Th3cur3";

    public Administrador(){
    }

    public static boolean validLoginAdm(String pwd){
        return key_adm.equals(pwd);
    }

    public static boolean validLogin(int cod, String pwd, int TYPE) throws Exception{
        loadFiles();
        System.out.println(":::here:::");
        if (TYPE == ABOG_JEF){
            System.out.println("Buscando AbogJefe");
            for(AbogadoJefe aj: listaAbogJefes){
                if (aj.getCodigoEmpleado() == cod){
                    System.out.println("Codigo encontrado");
                    return aj.correctPwd(pwd);
                }
            }
        }
        if(TYPE == RECEP){
            System.out.println("Buscando Recep");
            for(Recepcionista r: listaRecepcionistas){
                if(r.getCodigoEmpleado() == cod){
                    return r.correctPwd(pwd);
                }
            }
        }
        else {
            System.out.println("valor TYPE incorrecto");
        }

        return false;
    }

    public static void addAbogadoJefe(AbogadoJefe abog) throws Exception{
        loadFiles();
        listaAbogJefes.add(abog);
        saveFiles();
    }

    public static void addRecepcionista(Recepcionista recep) throws Exception{
        loadFiles();
        listaRecepcionistas.add(recep);
        saveFiles();
    }

    public static void loadFiles() throws Exception{
        try{
            ObjectInputStream inAbogJefe = new ObjectInputStream(new FileInputStream(fileAbogadosJefe));
            listaAbogJefes = (ArrayList) inAbogJefe.readObject();
            inAbogJefe.close();

            ObjectInputStream inRecep = new ObjectInputStream(new FileInputStream(fileRecepcionistas));
            listaRecepcionistas = (ArrayList) inRecep.readObject();
            inRecep.close();
        } catch (IOException err){
            err.printStackTrace();
        }
    }

    public static void saveFiles() throws Exception{
        try{
            ObjectOutputStream outAbogJefe = new ObjectOutputStream(new FileOutputStream(fileAbogadosJefe));
            outAbogJefe.writeObject(listaAbogJefes);
            outAbogJefe.close();

            ObjectOutputStream outRecep = new ObjectOutputStream(new FileOutputStream(fileRecepcionistas));
            outRecep.writeObject(listaRecepcionistas);
            outRecep.close();;
        } catch (IOException err){
            err.printStackTrace();
        }
     }
}
