package System;

import List.Elemento;
import List.Linked.ListaNodoDoble;
import Objects.Libro;

import javax.swing.text.Element;
import java.io.*;
import java.util.ArrayList;

public class GuardadoArchivo {
    private GuardadoArchivo() {
    }

    public static void guardar(ArrayList<Elemento> lista, String fileName) {
        try{
            FileWriter writer = new FileWriter(fileName,true);

            for(Elemento elemento : lista){
                writer.write(elemento+"\n");
            }

            writer.close();
        }catch (IOException e){
            System.out.println("Ocurrio un error al actualizar el archivo: "+e.getMessage());
        }
    }
}
