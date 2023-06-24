package Objects;

import System.Utils;

/**
 * Clase para un usuario.
 */
public class Usuario {
    //RUT del usuario.
    private String rut;
    //Nombre del usuario.
    private String nombre;
    //Apellido del usuario.
    private String apellido;
    //Contraseña del usuario.
    private String contrasenia;

    /**
     * Método constructor de un usuario.
     * @param rut del usuario.
     * @param nombre del usuario.
     * @param apellido del usuario.
     * @param contrasenia del usuario.
     */
    public Usuario(String rut, String nombre, String apellido, String contrasenia) {
        //Validación del RUT.
        if(!Utils.validarString(rut)){throw new IllegalArgumentException("[!] RUT Invalido [!]");}
        else {
            if (!Utils.validarRut(rut)) throw new IllegalArgumentException("[!] RUT Invalido [!]");
            this.rut = rut;
        }

        //Validación del nombre.
        if(!Utils.validarString(nombre)) throw new IllegalArgumentException("[!] Nombre Invalido [!]");
        this.nombre = nombre;

        //Validación del apellido.
        if(!Utils.validarString(apellido)) throw new IllegalArgumentException("[!] Apellido Invalido [!]");
        this.apellido = apellido;

        //Validación de la contraseña.
        if(!Utils.validarString(contrasenia)){throw new IllegalArgumentException("[!] Contraseña Invalida [!]");}
        else {
            if (!Utils.validarContrasenia(contrasenia)) throw new IllegalArgumentException("[!] Contraseña Invalida [!]");
            this.contrasenia = contrasenia;
        }
    }

    /**
     * Obtener el RUT.
     * @return el RUT
     */
    public String getRut() {
        return rut;
    }

    /**
     * Modificar el RUT.
     * @param rut nuevo.
     */
    public void setRut(String rut) {
        if(!Utils.validarString(rut)) throw new IllegalArgumentException("[!] RUT Invalido [!]");
        else {
            if (!Utils.validarRut(rut)) throw new IllegalArgumentException("[!] RUT Invalido [!]");
            this.rut = rut;
        }
    }

    /**
     * Obtener el nombre.
     * @return el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modificar el nombre.
     * @param nombre nuevo.
     */
    public void setNombre(String nombre) {
        if(!Utils.validarString(nombre)) throw new IllegalArgumentException("[!] Nombre Invalido [!]");
        this.nombre = nombre;
    }

    /**
     * Obtener el apellido.
     * @return el apellido.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Modificar el apellido.
     * @param apellido nuevo.
     */
    public void setApellido(String apellido) {
        if(!Utils.validarString(apellido)) throw new IllegalArgumentException("[!] Apellido Invalido [!]");
        this.apellido = apellido;
    }

    /**
     * Obtener la contraseña.
     * @return la contraseña.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Modificar la contraseña.
     * @param contrasenia nueva.
     */
    public void setContrasenia(String contrasenia) {
        if(!Utils.validarString(contrasenia)) throw new IllegalArgumentException("[!] Contraseña Invalido [!]");
        else {
            if (!Utils.validarContrasenia(contrasenia)) throw new IllegalArgumentException("[!] Contraseña Invalido [!]");
            this.contrasenia = contrasenia;
        }
    }
}
