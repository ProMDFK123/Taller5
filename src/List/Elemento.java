package List;

/**
 * Interfaz auxiliar para elementos en general.
 */
public interface Elemento {
    /**
     * Método que verifica si un elemento es igual a otro.
     * @param elemento a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    boolean esIgual(Elemento elemento);

    /**
     * Método que compara un elemento con otro.
     * @param elemento con el cual comparar.
     * @return el resultado de la comparación.
     */
    int compararCon(Elemento elemento);
}
