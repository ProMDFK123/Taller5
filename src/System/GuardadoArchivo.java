package System;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardadoArchivo {
    private GuardadoArchivo() {}

    public static void guardar() {
    }

    public static void guardar(ArrayList lista) throws IOException {
        FileWriter writer = new FileWriter("E://reservas.txt");

        for(int i=0; i<lista.size(); i++){
            try {
                writer.write(lista.get(i) +"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
