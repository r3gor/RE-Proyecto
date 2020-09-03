package model;

import java.io.*;
import java.util.ArrayList;

public class ListaPersistente<T extends Serializable> implements Serializable {
    final String CIT_ORD_FILE = "citas_ordinarias.dat";
    final String CIT_CAS_FILE = "citas_caso.dat";
    final String ABO_JEF_FILE = "abog_jefe.dat";
    final String RECEP_FILE = "recepcionistas.dat";
    String file = "";
    ArrayList<T> lista = new ArrayList<>();

    static final int CIT_ORD = 0;
    static final int CIT_CAS = 1;
    static final int ABO_JEF = 2;
    static final int RECEP = 3;

    public ListaPersistente(int type) {
        if (type == CIT_ORD) {
            file = CIT_ORD_FILE;
        }
        if (type == CIT_CAS) {
            file = CIT_CAS_FILE;
        }
        if (type == ABO_JEF) {
            file = ABO_JEF_FILE;
        }
        if (type == RECEP) {
            file = RECEP_FILE;
        }
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

    public ArrayList<T> getLista() {
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
