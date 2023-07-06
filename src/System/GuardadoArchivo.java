package System;

import List.Elemento;
import List.Linked.ListaNodoDoble;
import Objects.Libro;
import Objects.Transferencia;

import javax.swing.text.Element;
import java.io.*;
import java.util.ArrayList;

public class GuardadoArchivo {
    private GuardadoArchivo() {
    }

    public static void guardar(ArrayList<Elemento> lista, String fileName) {
        try{
            FileWriter writer = new FileWriter(fileName,true);

            try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    for(Elemento elemento : lista){
                        if(elemento instanceof Libro libro){
                            StringBuilder sb = new StringBuilder();
                            sb.append(libro.getIsbn()+",");
                            sb.append(libro.getTitulo()+",");
                            sb.append(libro.getAutor()+",");
                            sb.append(libro.getCategoria()+",");
                            sb.append(libro.getStock()+",");
                            sb.append(libro.getPrecio());
                            String bookString = sb.toString();

                            if(!bookString.equals(line)){
                                writer.write(bookString);
                            }
                        } else if (elemento instanceof Transferencia trans) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(trans.getRutVendedor()+",");
                            sb.append(trans.getNombreVendedor()+",");
                            sb.append(trans.getApellidoVendedor()+",");
                            sb.append(trans.getIsbnLibro()+",");
                            sb.append(trans.getTituloLibro()+",");
                            sb.append(trans.getTipoTransaccion());
                            String movimiento = sb.toString();

                            if(!movimiento.equals(line)){
                                writer.write(movimiento);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

            writer.close();
        }catch (IOException e){
            System.out.println("Ocurrio un error al actualizar el archivo: "+e.getMessage());
        }
    }
}
