package Objects;

/**
 * Clase de las transacciones (prestamos/devoluciones)
 */
public class Transferencia {
    private String rutVendedor;
    private String nombreVendedor;
    private String apellidoVendedor;
    private String isbnLibro;
    private String tituloLibro;
    private String tipoTransaccion;

    /**
     * Constructor
     * @param rutVendedor
     * @param nombreVendedor
     * @param apellidoVendedor
     * @param isbnLibro
     * @param tituloLibro
     * @param categoriaLibro
     */
    public Transferencia(String rutVendedor, String nombreVendedor, String apellidoVendedor, String isbnLibro, String tituloLibro, String categoriaLibro) {
        this.rutVendedor = rutVendedor;
        this.nombreVendedor = nombreVendedor;
        this.apellidoVendedor = apellidoVendedor;
        this.isbnLibro = isbnLibro;
        this.tituloLibro = tituloLibro;
        this.tipoTransaccion = categoriaLibro;
    }

    public String getRutVendedor() {
        return rutVendedor;
    }

    public void setRutVendedor(String rutVendedor) {
        this.rutVendedor = rutVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApellidoVendedor() {
        return apellidoVendedor;
    }

    public void setApellidoVendedor(String apellidoVendedor) {
        this.apellidoVendedor = apellidoVendedor;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String categoriaLibro) {
        this.tipoTransaccion = categoriaLibro;
    }
}
