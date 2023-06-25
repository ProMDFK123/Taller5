package List.Array;

import System.Utils;
import List.Elemento;

/**
 * Clase que almacena una lista de elementos.
 */
public class ListaElemento implements ListaStatic{
    //Cantidad actual de elementos.
    private int cantElementos;
    //Cantidad máxima de elementos.
    private int maximo;
    //La lista.
    private Elemento[] elementos;

    /**
     * Constructor de una lista.
     * @param maximo - capacidad máxima de la lista.
     */
    public ListaElemento(int maximo) {
        if(!Utils.validarInt(maximo)) throw new IllegalArgumentException("[!] Valor Invalido [!]");
        this.maximo = maximo;
        this.cantElementos=0;
        elementos=new Elemento[maximo];
    }

    //Los Getters.

    public int getCantElementos() {
        return cantElementos;
    }

    public int getMaximo() {
        return maximo;
    }


    /**
     * Agrega un elemento.
     * @param elemento a agregar.
     * @return true si se agregó.
     */
    @Override
    public boolean agregar(Elemento elemento) {
        //Valida el elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Si el elemento ya existe.
        if(this.contiene(elemento)) return false;

        //Si la lista ya esta llena.
        if(this.cantElementos==this.maximo) return false;

        //Agrega el elemento.
        this.elementos[this.cantElementos]=elemento;
        this.cantElementos++;
        return true;
    }

    /**
     * Elimina un elemento.
     * @param elemento a eliminar.
     * @return true si se elimino correctamente.
     */
    @Override
    public boolean eliminar(Elemento elemento) {
        //Valida el elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Si la lista esta vacía.
        if(this.isVacia()) return false;

        //Recorre la lista.
        for(int i=0; i<this.cantElementos; i++){
            //Compara elementos.
            if(this.elementos[i].esIgual(elemento)){
                //Se encontró el elemento y se elimina.
                this.elementos[i]=null;
                this.cantElementos--;
                return true;
            }
        }

        //No se encontró el elemento.
        return false;
    }

    /**
     * Busca si ya existe un elemento o no.
     * @param elemento a verificar.
     * @return true si existe, false si no.
     */
    @Override
    public boolean contiene(Elemento elemento) {
        //Validación del elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //La lista esta vacía.
        if(this.isVacia()) return false;

        //Recorre la lista.
        for(int i=0; i<this.cantElementos; i++){
            //Se encontró el elemento.
            if(this.elementos[i].esIgual(elemento)) return true;
        }

        //No se encontró el elemento.
        return false;
    }

    /**
     * Método que verifica si la lista esta o no vacía.
     * @return true si esta vacía.
     */
    @Override
    public boolean isVacia() {return this.cantElementos==0;}

    /**
     * Agregar un elemento en una dada posición.
     * @param elemento a agregar.
     * @param posicion en la que se agregará el elemento.
     * @return true si se agregó, false si no.
     */
    @Override
    public boolean agregar(Elemento elemento, int posicion) {
        //Validación de elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Si la posición se encuentra fuera del rango.
        if(!Utils.validarRango(posicion,0,this.maximo)) return false;

        //Si la posición dada ya esta ocupada.
        if(this.getElemento(posicion)!=null) return false;

        //Si el elemento ya existe.
        if(this.getPosicion(elemento)>-1) return false;

        //Agrega el elemento.
        this.elementos[posicion]=elemento;
        this.cantElementos++;
        return true;
    }

    /**
     * Elimina un elemento dada su posición.
     * @param posicion del elemento a eliminar.
     * @return true si se eliminó correctamente.
     */
    @Override
    public boolean eliminar(int posicion) {
        //Posición fuera de rango.
        if(!Utils.validarRango(posicion,0,this.maximo)) return false;

        //Lista vacía.
        if(this.isVacia()) return false;

        //Si la posición ya esta vacía.
        if(this.elementos[posicion]==null) return false;

        //Elimina el elemento.
        this.elementos[posicion]=null;
        this.cantElementos--;
        return true;
    }

    /**
     * Busca la posición de un elemento.
     * @param elemento a buscar su posición.
     * @return la posición del elemento.
     */
    @Override
    public int getPosicion(Elemento elemento) {
        //Validación de elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Lista vacía.
        if(this.isVacia()) return -1;

        //Recorre la lista.
        for(int i=0; i<this.cantElementos; i++){
            //Elemento encontrado.
            if(this.elementos[i].esIgual(elemento)) return i;
        }

        //No se encontró el elemento.
        return -1;
    }

    /**
     * Busca un elemento dada su posición.
     * @param posicion del elemento buscado.
     * @return
     */
    @Override
    public Elemento getElemento(int posicion) {
        //Posición fuera de rango.
        if(!Utils.validarRango(posicion,0,this.maximo)) return null;

        //Si la lista esta vacía.
        if(this.isVacia()) return null;

        return this.elementos[posicion];
    }
}
