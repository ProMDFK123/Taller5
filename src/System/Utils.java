package System;

import List.Elemento;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase auxiliar para métodos auxiliares, como validadores de datos.
 */
public class Utils {
    /**
     * Constructor vacío y privado.
     */
    private Utils(){}

    /**
     * Método booleano que valida que un String no sea nulo.
     * @param string a validar.
     * @return false si es nulo.
     */
    public static boolean validarString(String string){return string!=null;}

    /**
     * Método que valida un RUT.
     * @param rut a validar.
     * @return true si es un RUT válido.
     */
    public static boolean validarRut(String rut){
        String RUT = "^[0-9]+-[0-9kK]{1}$";
        Pattern patron = Pattern.compile(RUT);
        Matcher matcher = patron.matcher(rut);

        if(!matcher.matches()) return false;

        String[] StringRUT = rut.split("-");
        return StringRUT[1].toLowerCase().equals(digitoVerificador(StringRUT[0]));
    }

    /**
     * Método auxiliar que calcula el dígito verificador de un RUT.
     * @param rut sin dígito verificador.
     * @return el dígito verificador.
     */
    public static String digitoVerificador(String rut){
        Integer M=0,S=1,T=Integer.parseInt(rut);
        for(;T!=0;T=(int) Math.floor(T/=10)){
            S=(S+T%10*(9-M++%6))%11;
        }

        return (S > 0) ? String.valueOf(S-1) : "k";
    }

    /**
     * Método que valida una contraseña.
     * @param clave a validar.
     * @return true si es una contraseña válida.
     */
    public static boolean validarContrasenia(String clave){
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{4,6}$";
        Pattern Code = Pattern.compile(pattern);
        Matcher matcher = Code.matcher(clave);

        if(!matcher.matches()) return false;

        return true;
    }

    /**
     * Método que valida un número.
     * @param i int a validar.
     * @return true si es mayor a 0, false en caso contrario.
     */
    public static boolean validarInt(int i){return i<0;}

    /**
     * Método que valida un elemento.
     * @param elemento a validar.
     * @return true si es un elemento, false si es nulo.
     */
    public static boolean validarElemento(Elemento elemento){return elemento!=null;}

    /**
     * Método que valida si un número se encuentra dentro de un determinado rango.
     * @param i - número a validar.
     * @param min - valor mínimo del rango.
     * @param max - valor máximo del rango.
     * @return true si el número esta dentro del rango.
     */
    public static boolean validarRango(int i, int min, int max){
        if(min<i && i<max) return true;

        return false;
    }
}
