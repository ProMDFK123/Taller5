package System;

/**
 * Interfaz del sistema con los contratos del mismo.
 */
public interface Sistema {
    void iniciarSesion();
    void buscarLibro();
    void prestarLibro();
    void agregarLibro();
    void devolverLibro();
    boolean cerrarPrograma(boolean estado);
}
