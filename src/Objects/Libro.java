package Objects;

import System.Utils;

/**
 * Clase de un libro.
 */
public class Libro {
    //El código ISBN del libro.
    private int isbn;
    //El titulo del libro.
    private String titulo;
    //El autor del libro.
    private String autor;
    //La categoría a la que pertenece el libro.
    private String categoria;
    //La cantidad de unidades disponibles.
    private int stock;

    public Libro(int isbn, String titulo, String autor, String categoria, int stock) {
        //Validación del ISBN.
        if(!Utils.validarInt(isbn)) throw new IllegalArgumentException("[!] ISBN Invalido [!]");
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
        if(!Utils.validarInt(stock)) throw new IllegalArgumentException("[!] Stock Invalido [!]");
        this.stock = stock;
    }

    //Los Getter.

    public int getIsbn() {
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

    //Los Setter.

    public void setIsbn(int isbn) {
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
}
