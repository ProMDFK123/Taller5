package List.Linked;

import List.Elemento;

/**
 * Clase de una LinkedList.
 */
public class ListaNodoDoble implements Lista{
    //Primer nodo de la lista.
    private NodoDoble cabeza;
    //Ultimo nodo de la lista.
    private NodoDoble cola;
    //Tamaño de la lista.
    private int tamanio;

    /**
     * Constructor de una LinkedList.
     */
    public ListaNodoDoble() {
        this.cabeza=null;
        this.cola=null;
        this.tamanio=0;
    }

    /**
     * Obtiene el tamaño de la lista (cantidad de nodos).
     * @return el tamaño de la lista.
     */
    public int getTamanio() {
        return tamanio;
    }

    @Override
    public boolean agregar(Elemento elemento) {
        return false;
    }

    @Override
    public boolean eliminar(Elemento elemento) {
        return false;
    }

    @Override
    public boolean contiene(Elemento elemento) {
        return false;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public boolean isVacia() {
        return false;
    }

    @Override
    public boolean agregar(Elemento elemento, int posicion) {
        return false;
    }

    @Override
    public boolean eliminar(int posicion) {
        return false;
    }

    @Override
    public int getPosicion(Elemento elemento) {
        return 0;
    }

    @Override
    public Elemento getElemento(int posicion) {
        return null;
    }
}
