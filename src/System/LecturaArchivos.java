package System;

import List.Array.ListaElemento;
import List.Linked.ListaNodoDoble;
import Objects.Libro;
import Objects.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Gabriel López.
 */
public class LecturaArchivos {
    private LecturaArchivos() {}

    /**
     * Método encargado de leer el archivo de "libros.txt".
     */
    public static void leerArchivoLibros(ListaNodoDoble lista) {

        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);

                Integer intISBN = Integer.parseInt(isbn);

                Libro libro = new Libro(intISBN,title,author,category,copies,price);
                lista.agregar(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Método encargado de leer el archivo de "usuarios.txt".
     */
    public static void leerArchivoUsuarios(ListaElemento lista) {

        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                //TODO: Eliminar los print, solo están de prueba para saber si el archivo se leyó correctamente.
                System.out.println("RUT: " + rut);
                System.out.println("Nombre: " + name);
                System.out.println("Apellido: " + lastname);
                System.out.println("Contraseña: " + password);
                System.out.println("-----------------------------");

                Usuario usuario = new Usuario(rut,name,lastname,password);
                lista.agregar(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}