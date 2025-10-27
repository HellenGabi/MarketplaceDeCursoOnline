package org.example.util;

public class StringUtils {

    public static String removerEspacos(String texto) {
        if (texto == null) return null;
        return texto.trim();
    }

    public static boolean isVazia(String texto) {
        return texto == null || texto.trim().isEmpty();
    }


    public static boolean isNullOuVazia(String texto) {
        return texto == null || texto.isEmpty();
    }
}