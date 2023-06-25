package List.Array;

import List.Elemento;

/**
 * Interfaz de una lista estática.
 */
public interface ListaStatic extends Contenedor{
    /**
     * Método para agregar un elemento en una dada posición.
     * @param elemento a agregar.
     * @param posicion en la que se agregará el elemento.
     * @return true si se agregó correctamente.
     */
    boolean agregar(Elemento elemento, int posicion);

    /**
     * Método para eliminar un elemento dada una posición.
     * @param posicion del elemento a eliminar.
     * @return true si el elemento se borró perfectamente.
     */
    boolean eliminar(int posicion);

    /**
     * Método para obtener la posición de un elemento.
     * @param elemento a buscar su posición.
     * @return la posición del elemento.
     */
    int getPosicion(Elemento elemento);

    /**
     * Método para obtener un elemento dada la posición de este.
     * @param posicion del elemento buscado.
     * @return el elemento en a posición entregada.
     */
    Elemento getElemento(int posicion);
}
