package registradorcitas;

import java.io.*;
import java.util.ArrayList;

public class ListaCitasOrdinarias implements Serializable {
    private ArrayList<CitaOrdinaria> lista;
    private String fileName;

    public ListaCitasOrdinarias(String fileName) {
        this.fileName = fileName;
    }

    public Integer findCitaOrdinaria(Integer DNI){
        for(int i=0; i<lista.size(); i++){
            if (lista.get(i).getDNI().equals(DNI)){
                return i;
            }
        }
        return -1;
    }

    public CitaOrdinaria getCitaOrdinaria(Integer index){
        return lista.get(index);
    }

    public void addCitaOrdinaria(CitaOrdinaria cita) throws  Exception{
        loadListaCitasOrdinarias();
        lista.add(cita);
        saveListaCitasOrdinarias();
    }

    public ArrayList<CitaOrdinaria> getListaCitasOrdinarias() {
        return lista;
    }

    public void eliminarCitaOrdinaria(CitaOrdinaria cita) throws Exception{
        loadListaCitasOrdinarias();
        lista.remove(cita);
        saveListaCitasOrdinarias();
    }

    public void replaceCitaOrdinaria(CitaOrdinaria oldCita, CitaOrdinaria newCita) throws Exception{
        loadListaCitasOrdinarias();
        int idx = lista.indexOf(oldCita);
        if (idx == -1){
            System.out.println("Cita a editar no existe");
            return;
        }
        lista.set(idx, newCita);
        saveListaCitasOrdinarias();
    }

    private void saveListaCitasOrdinarias() throws Exception{
        try{
            FileOutputStream outFile = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(lista);
            out.close();
        } catch (IOException err){
            err.printStackTrace();
        }
    }

    private void loadListaCitasOrdinarias() throws Exception{
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
