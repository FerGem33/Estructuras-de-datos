import java.util.Locale;
import java.text.Collator;

public class Test {
    public static void main(String[] args) {
        Locale español = Locale.of("es", "MX");
        Collator comparador = Collator.getInstance(español);

        // Strength determina qué tan estricta es la comparación
        // PRIMARY ignora acentos y mayúsculas/minúsculas
        comparador.setStrength(Collator.PRIMARY);

        /* 
        Collator.compare(s1,s2) devuelve un int:
            negativo, si s1 < s2
                   0, si s1 == s2
            positivo, si s1 > s2
        */ 
        int comparacion = comparador.compare("maria", "María");
        System.out.println(comparacion);
    }
}
