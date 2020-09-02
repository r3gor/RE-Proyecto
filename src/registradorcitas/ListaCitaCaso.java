/*
* TODO: Class Cita <-extends- CitaCaso & CitaOrdinaria
* */
package registradorcitas;

import java.io.*;
import java.util.ArrayList;

public class ListaCitaCaso implements Serializable {
    private ArrayList<CitaCaso> lista;
    private String fileName;

    public ListaCitaCaso(String fileName) {
        this.fileName = fileName;
    }

    public void addCitaCaso(CitaCaso cita) throws  Exception{
        loadListaCitasCaso();
        lista.add(cita);
        saveListaCitasCaso();
    }

    public ArrayList<CitaCaso> getListaCitasCaso() {
        return lista;
    }

    public void eliminarCitaCaso(CitaCaso cita) throws Exception{
        loadListaCitasCaso();
        lista.remove(cita);
        saveListaCitasCaso();
    }

    public void replaceCitaCaso(CitaCaso oldCita, CitaCaso newCita) throws Exception{
        loadListaCitasCaso();
        int idx = lista.indexOf(oldCita);
        if (idx == -1){
            System.out.println("Cita a editar no existe");
            return;
        }
        lista.set(idx, newCita);
        saveListaCitasCaso();
    }

    private void saveListaCitasCaso() throws Exception{
        try{
            FileOutputStream outFile = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(lista);
            out.close();
        } catch (IOException err){
            err.printStackTrace();
        }
    }

    private void loadListaCitasCaso() throws Exception{
        try{
            FileInputStream inFile = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(inFile);
            lista = (ArrayList) in.readObject();
            in.close();
        } catch (IOException err){
            err.printStackTrace();
        } catch (ClassNotFoundException err){
            System.out.println("[ClassNotFoundException]\tClase no encontrada");
            err.printStackTrace();
        }
    }

}
