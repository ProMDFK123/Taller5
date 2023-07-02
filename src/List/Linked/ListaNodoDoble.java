package List.Linked;

import List.Elemento;
import Objects.Libro;
import System.Utils;

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

    public NodoDoble getCabeza() {
        return cabeza;
    }

    public NodoDoble getCola() {
        return cola;
    }

    /**
     * Agrega un elemento.
     * @param elemento a agregar.
     * @return true si se agregó el elemento.
     */
    @Override
    public boolean agregar(Elemento elemento) {
        //Validación de elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Creación del nodo.
        NodoDoble nuevo = new NodoDoble(elemento);

        //Si la lista esta vacía.
        if(this.isVacia()){
            this.cabeza=nuevo;
            this.cola=nuevo;
            this.tamanio++;
            return true;
        }


        //Revisa si el elemento aun no existe.
        if(this.contiene(elemento)) return false;

        //Agrega el elemento al final.
        this.cola.setSiguiente(nuevo);
        nuevo.setAnterior(this.cola);
        this.cola=nuevo;
        this.tamanio++;
        return true;
    }

    /**
     * Elimina un elemento.
     * @param elemento a eliminar.
     * @return true si se eliminó el elemento.
     */
    @Override
    public boolean eliminar(Elemento elemento) {
        //Validación de elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Si la lista esta vacía.
        if(this.isVacia()) return false;

        //Si el elemento se encuentra en la cabeza.
        if(this.isCabeza(elemento)){
            this.cabeza.getSiguiente().setAnterior(null);
            this.cabeza=this.cabeza.getSiguiente();
            this.tamanio--;
            return true;
        }

        //Si el elemento se encuentra en la cola.
        if(this.isCola(elemento)){
            this.cola.getAnterior().setSiguiente(null);
            this.cola=this.cola.getAnterior();
            this.tamanio--;
            return true;
        }

        //Si el elemento se encuentra en medio.
        for(NodoDoble aux=this.cabeza; aux.getSiguiente()!=null; aux=aux.getSiguiente()){
            NodoDoble anterior = aux.getAnterior();
            NodoDoble siguiente = aux.getSiguiente();

            if(aux.getElemento().esIgual(elemento)){
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
                this.tamanio--;
                return true;
            }
        }

        //No se encontró el elemento.
        return false;
    }

    /**
     *
     * @param elemento a comprobar.
     * @return
     */
    @Override
    public boolean contiene(Elemento elemento) {
        //Validación de elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Si la lista esta vacía.
        if(this.isVacia()) return false;

        //Si el elemento es la cabeza.
        if(this.isCabeza(elemento)) return true;

        //Si el elemento es la cola.
        if(this.isCola(elemento)) return true;

        //Si el elemento está en medio.
        for(NodoDoble aux=this.cabeza; aux!=null; aux=aux.getSiguiente()){
            if(aux.getElemento().esIgual(elemento)) return true;
        }

        //No se encontró el elemento.
        return false;
    }

    /**
     * Método para vaciar la lista.
     */
    @Override
    public void vaciar() {
        this.cabeza=null;
    }

    /**
     * Verifica si la lista esta vacía o no.
     * @return true si esta vacía.
     */
    @Override
    public boolean isVacia() {
        return this.cabeza==null;
    }

    /**
     * Agrega un elemento dada la posición.
     * @param elemento a agregar.
     * @param posicion en la cual agregar.
     * @return true si se agregó.
     */
    @Override
    public boolean agregar(Elemento elemento, int posicion) {
        //Validación de elemento.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Validación de la posición.
        if(!Utils.validarRango(posicion,0,this.tamanio)) throw new IllegalArgumentException("[!] Posición Invalida [!]");

        //Si el elemento ya existe.
        if(this.contiene(elemento)) return false;

        //Creación del nodo.
        NodoDoble nuevo = new NodoDoble(elemento);

        //Si la lista esta vacía.
        if(this.isVacia()){
            this.cabeza=nuevo;
            this.cola=nuevo;
            this.tamanio++;
            return true;
        }

        //Si la posición dada es 0.
        if(posicion==0){
            nuevo.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(nuevo);
            this.cabeza=nuevo;
            this.tamanio++;
            return true;
        }

        //Si la posición dada coincide con la cantidad de nodos.
        if(posicion==this.tamanio){
            this.cola.setSiguiente(nuevo);
            nuevo.setAnterior(this.cola);
            this.cola=nuevo;
            this.tamanio++;
            return true;
        }

        //En general.
        for(NodoDoble aux=this.cabeza; aux!=null; aux=aux.getSiguiente()){
            int auxPos = this.getPosicion(aux.getElemento());
            NodoDoble auxSig = aux.getSiguiente();

            if(auxPos==posicion){
                nuevo.setSiguiente(auxSig);
                nuevo.setAnterior(aux);
                aux.setSiguiente(nuevo);
                auxSig.setAnterior(nuevo);
                this.tamanio++;
                return true;
            }
        }

        //No se pudo agregar.
        return false;
    }

    /**
     * Elimina un elemento dada su posición.
     * @param posicion del elemento a eliminar.
     * @return true si se eliminó correctamente.
     */
    @Override
    public boolean eliminar(int posicion) {
        //Validación de la posición.
        if(!Utils.validarRango(posicion,0,this.tamanio)) throw new IllegalArgumentException("[!] Posición Invalida [!]");

        //Si la lista esta vacía.
        if(this.isVacia()) return false;

        //Si la posición es la primera.
        if(posicion==0){
            this.cabeza=this.cabeza.getSiguiente();
            this.cabeza.setAnterior(null);
            this.tamanio--;
            return true;
        }

        //Si la posición es la última.
        if(posicion==this.tamanio-1){
            this.cola=this.cola.getAnterior();
            this.cola.setSiguiente(null);
            this.tamanio--;
            return true;
        }

        //En general.
        int auxPos=0;
        for(NodoDoble aux=this.cabeza; aux!=null; aux=aux.getSiguiente()){
            NodoDoble ant = aux.getAnterior();
            NodoDoble sig = aux.getSiguiente();

            if(auxPos==posicion){
                ant.setSiguiente(sig);
                sig.setAnterior(ant);
                this.tamanio--;
                return true;
            }

            auxPos++;
        }

        //No se pudo agregar.
        return true;
    }

    /**
     * Obtiene la posición de un elemento.
     * @param elemento a buscar su posición.
     * @return la posición del elemento.
     */
    @Override
    public int getPosicion(Elemento elemento) {
        //Validación de la posición.
        if(!Utils.validarElemento(elemento)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Posición auxiliar.
        int auxPos = 0;

        //Si la lista esta vacía.
        if(this.isVacia()) return -1;

        //Si el elemento es la cola.
        if(this.isCola(elemento)) return this.tamanio;

        //Si el elemento es la cabeza.
        if(this.isCabeza(elemento)) return 0;

        //En general.
        for(NodoDoble aux=this.cabeza; aux!=null; aux=aux.getSiguiente()){
            if(aux.getElemento().esIgual(elemento)) return auxPos;

            auxPos++;
        }

        //No se encontró el elemento.
        return -1;
    }

    /**
     * Obtiene un elemento dada su posición.
     * @param posicion del elemento buscado.
     * @return el elemento.
     */
    @Override
    public Elemento getElemento(int posicion) {
        //Validación de la posición.
        if(!Utils.validarRango(posicion,0,this.tamanio)) throw new IllegalArgumentException("[!] Elemento Invalido [!]");

        //Si la lista esta vacía.
        if(this.isVacia()) return null;

        //Si la posición es la primera.
        if(posicion==0) return this.cabeza.getElemento();

        //Si la posición es la última.
        if(posicion==this.tamanio-1) return this.cola.getElemento();

        //En general.
        for(NodoDoble aux=this.cabeza; aux!=null; aux=aux.getSiguiente()){
            Elemento auxElement = aux.getElemento();
            int auxPos = this.getPosicion(auxElement);

            if(auxPos==posicion){
                return auxElement;
            }
        }

        //No se encontró el elemento.
        return null;
    }

    /**
     * Métodos auxiliares para verificar si un elemento se encuentra en la cabeza o en la cola.
     * @param elemento a verificar.
     * @return true si está en la cabeza o la cola respectivamente, false en caso de no ser ni la cola ni la cabeza.
     */
    public boolean isCabeza(Elemento elemento){return this.cabeza.getElemento().esIgual(elemento);}
    public boolean isCola(Elemento elemento){return this.cola.getElemento().esIgual(elemento);}

    /**
     * Método para buscar un elemento dado su ISBN.
     * @param isbn del libro.
     * @return el libro.
     */
    public Elemento getElemento(String isbn){
        //Si la lista esta vacía.
        if(isVacia()) return null;

        //Revisar la cabeza.
        if(this.cabeza.getElemento() instanceof Libro libro){if(libro.getIsbn().equals(isbn)) return libro;}

        //Revisar la cola.
        if(this.cola.getElemento() instanceof  Libro libro){if(libro.getIsbn().equals(isbn)) return libro;}

        //Revisar el resto de la lista.
        for(NodoDoble aux=this.cabeza; aux!=null; aux=aux.getSiguiente()){
            Libro auxBook = (Libro) aux.getElemento();

            if(auxBook.getIsbn().equals(isbn)) return auxBook;
        }

        //No se encontró el libro.
        return null;
    }
}
