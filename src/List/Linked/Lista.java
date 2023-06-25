package List.Linked;

import List.Elemento;

public interface Lista extends Coleccion{
    /**
     * Método que agrega un elemento dado una posición.
     * @param elemento a agregar.
     * @param posicion en la cual agregar.
     * @return true si se agrego perfectamente, false si no.
     */
    boolean agregar(Elemento elemento, int posicion);

    /**
     * Método para eliminar un elemento dada la posición de este.
     * @param posicion del elemento a eliminar.
     * @return true si se elimino correctamente, false si no.
     */
    boolean eliminar(int posicion);

    /**
     * Método para obtener la posición de un elemento.
     * @param elemento a buscar su posición.
     * @return la posición del elemento.
     */
    int getPosicion(Elemento elemento);

    /**
     * Obtener un elemento dada la posición.
     * @param posicion del elemento buscado.
     * @return el elemento en esa posición.
     */
    Elemento getElemento(int posicion);
}
