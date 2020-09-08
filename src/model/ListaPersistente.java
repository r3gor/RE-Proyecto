package model;

import java.io.*;
import java.util.ArrayList;

public class ListaPersistente<T extends Serializable> implements Serializable {
    public static final int CIT_ORD = 0;
    public static final int CIT_CAS = 1;
    public static final int ABO_JEF = 2;
    public static final int RECEP = 3;
    public static final String[] FILES = {"dat/citas_ordinarias.dat", "dat/citas_caso.dat", "dat/abog_jefe.dat", "dat/recepcionistas.dat"};
    String file = "";
    ArrayList<T> lista = new ArrayList<>();

    public ListaPersistente(int type) {
        file = FILES[type];
    }

    public void add(T elemento) throws Exception {
        loadLista();
        lista.add(elemento);
        saveLista();
    }

    public void delete(T elemento) throws Exception {
        loadLista();
        lista.remove(elemento);
        saveLista();
    }

    public ArrayList<T> getLista() throws Exception {
        loadLista();
        return lista;
    }

    public void loadLista() throws Exception {
        if ((new File(file)).length() == 0) {
            System.out.println("[Load]\tFichero vacio " + file);
            return;
        }
        try {
            System.out.println("[Load]\tLista cargada: " + file);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            lista = (ArrayList) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException err) {
            err.printStackTrace();
        }
    }

    public void saveLista() throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(lista);
            out.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void printLista() throws Exception {
        loadLista();
        for (T elemento : lista) {
            System.out.println(elemento);
        }
    }
}
