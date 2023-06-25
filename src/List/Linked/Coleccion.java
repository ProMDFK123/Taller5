package List.Linked;

import List.Elemento;

/**
 * Interfaz de una colección (LinkedList).
 */
public interface Coleccion {
    /**
     * Método que agrega un elemento.
     * @param elemento a agregar.
     * @return true si se agrego correctamente, false en caso contrario.
     */
    boolean agregar(Elemento elemento);

    /**
     * Método para eliminar un elemento.
     * @param elemento a eliminar.
     * @return true si el elemento se elimino correctamente, false en caso contrario.
     */
    boolean eliminar(Elemento elemento);

    /**
     * Método para ver si un elemento se encuentra almacenado.
     * @param elemento a comprobar.
     * @return true si ya existe, false si no.
     */
    boolean contiene(Elemento elemento);

    /**
     * Método para vaciar la lista.
     */
    void vaciar();

    /**
     * Método que verifica si la lista esta vacía.
     * @return true si esta vacía, false si no.
     */
    boolean isVacia();
}
