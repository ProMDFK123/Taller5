package Objects;

import List.Elemento;
import System.Utils;

/**
 * Clase de un libro.
 */
public class Libro implements Elemento {
    //El código ISBN del libro.
    private String isbn;
    //El título del libro.
    private String titulo;
    //El autor del libro.
    private String autor;
    //La categoría a la que pertenece el libro.
    private String categoria;
    //La cantidad de unidades disponibles.
    private int stock;
    private int precio;

    public Libro(String isbn, String titulo, String autor, String categoria, int stock, int precio) {
        //Validación del ISBN.
        if(!Utils.validarString(isbn)) throw new IllegalArgumentException("[!] ISBN Invalido [!]");
        this.isbn = isbn;

        //Validación del título.
        if(!Utils.validarString(titulo)) throw new IllegalArgumentException("[!] Titulo Invalido [!]");
        this.titulo = titulo;

        //Validación del autor.
        if(!Utils.validarString(autor)) throw new IllegalArgumentException("[!] Autor Invalido [!]");
        this.autor = autor;

        //Validación de la categoría.
        if(!Utils.validarString(categoria)) throw new IllegalArgumentException("[!] Categoría Invalido [!]");
        this.categoria = categoria;

        //Validación del stock.
        if(stock<0) throw new IllegalArgumentException("[!] Stock Invalido [!]");
        this.stock = stock;

        if(precio<0) throw new IllegalArgumentException("[!] Precio Invalido [!]");
        this.precio=precio;
    }

    //Los Getter.

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public int getPrecio() {
        return precio;
    }

    //Los Setter.

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Método que verifica si 2 libros son o no son iguales.
     * @param elemento a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean esIgual(Elemento elemento) {
        //Si el elemento es el mismo.
        if(this==elemento) return true;

        //Si el elemento es instancia de libro.
        if(elemento instanceof Libro libro) return this.isbn== libro.isbn;

        //Si el elemento ingresado es una instancia de otra cosa.
        return false;
    }

    /**
     * Método que compara 2 libros.
     * @param elemento con el cual comparar.
     * @return 0 si son iguales, -1 si es menor o 1 si es mayor.
     */
    @Override
    public int compararCon(Elemento elemento) {
        //Comparación consigo mismo.
        if(this==elemento) return 0;

        //Comparación por nombre.
        if(elemento instanceof Libro libro) return this.titulo.compareTo(libro.titulo);

        //No se pueden comparar.
        throw new IllegalArgumentException("[!] El elemento no es un libro [!]");
    }
}
