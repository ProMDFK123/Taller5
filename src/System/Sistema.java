package System;

import Objects.Usuario;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaz del sistema con los contratos del mismo.
 */
public interface Sistema {
    /**
     * Método de inicio de sesión.
     */
    void iniciarSesion(Ventana ventana);

    /**
     * Método para buscar un libro.
     */
    void buscarLibro(Ventana ventana);

    /**
     * Método para prestar un libro.
     */
    void prestarLibro(Ventana ventana, Usuario usuario);

    /**
     * Método para agregar un libro.
     */
    void agregarLibro(Ventana ventana);

    /**
     * Método para devolver un libro
     */
    void devolverLibro(Ventana ventana, Usuario usuario);
    /**
     * Método para cerrar el programa.
     */
    void cerrarPrograma(Ventana ventana, ArrayList lista) throws IOException;
}
