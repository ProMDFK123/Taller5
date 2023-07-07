package System;

import List.Elemento;
import List.Linked.ListaNodoDoble;
import Objects.Libro;
import Objects.Transferencia;

import javax.swing.text.Element;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GuardadoArchivo {
    private GuardadoArchivo() {
    }

    public static void guardar(ArrayList<Elemento> lista, String fileName) {
        try{
            Set<String> lineaUnica = new HashSet<>();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String linea;
            while ((linea= reader.readLine())!=null){
                lineaUnica.add(linea);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(String unico : lineaUnica){
                writer.write(unico);
                writer.newLine();
            }
            writer.close();
        }catch (IOException ex){
            System.out.println("Error al leer y/o escribir el archivo.");
        }
    }
}
