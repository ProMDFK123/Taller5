package List.Linked;

import List.Elemento;
import System.Utils;

/**
 * Clase de un nodo.
 */
public class NodoDoble {
    //El nodo siguiente.
    private NodoDoble siguiente;
    //El nodo anterior.
    private NodoDoble anterior;
    //El elemento almacenado.
    private Elemento elemento;

    /**
     * Constructor de un nodo.
     * @param elemento a guardar.
     */
    public NodoDoble(Elemento elemento) {
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");
        this.elemento = elemento;
        this.siguiente=null;
        this.anterior=null;
    }

    //Los Getters.

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public Elemento getElemento() {
        return elemento;
    }

    //Los Setters

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
