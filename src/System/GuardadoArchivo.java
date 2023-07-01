package System;

import List.Linked.ListaNodoDoble;
import Objects.Libro;

import java.io.*;
import java.util.ArrayList;

public class GuardadoArchivo {
    private GuardadoArchivo() {}

    /**
     * Método para guardar una lista en un txt.
     * @param lista a guardar.
     * @throws IOException en caso de error.
     */
    public static void guardar(ArrayList lista) throws IOException {
        FileWriter writer = new FileWriter("reservas.txt");

        for(int i=0; i<lista.size(); i++){
            try {
                writer.write(lista.get(i) +"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
