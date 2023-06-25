package List.Array;

import List.Elemento;

/**
 * Interfaz contenedor ArrayList.
 */
public interface Contenedor {
    /**
     * Agregar un elemento a la lista.
     * @param elemento a agregar.
     * @return true si se agrego correctamente.
     */
    boolean agregar(Elemento elemento);

    /**
     * Método para eliminar un elemento.
     * @param elemento a eliminar.
     * @return true si el elemento fue eliminado correctamente.
     */
    boolean eliminar(Elemento elemento);

    /**
     * Método para verificar si un elemento ya existe o no.
     * @param elemento a verificar.
     * @return true si ya existe, false si no.
     */
    boolean contiene(Elemento elemento);

    /**
     * Método que verifica si la lista ya esta vacía.
     * @return true si esta vacía.
     */
    boolean isVacia();
}
