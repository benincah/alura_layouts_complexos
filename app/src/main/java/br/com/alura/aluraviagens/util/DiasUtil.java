package br.com.alura.aluraviagens.util;

import androidx.annotation.NonNull;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int quantidadeDias) {
        if (quantidadeDias > 1 ) {
            return quantidadeDias + PLURAL;
        }
        return quantidadeDias + SINGULAR;

    }
}
