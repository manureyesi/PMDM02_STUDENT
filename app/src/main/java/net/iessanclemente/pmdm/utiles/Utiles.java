package net.iessanclemente.pmdm.utiles;

public class Utiles {

    /**
     * Formatear cadena
     * @param texto
     * @return
     */
    public static String toUpperCaseFrase (final String texto) {

        char[] arrChars = texto.toCharArray();
        arrChars[0] = Character.toUpperCase(arrChars[0]);

        return new String(arrChars);
    }

}
