import javax.swing.JOptionPane;
import java.util.StringTokenizer;

public class U1Practica5 {
    public static void mostrarMatriz(char[][] matriz, String titulo) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                s.append(matriz[i][j]).append(" ");
            }
            s.append("\n");
        }
        JOptionPane.showMessageDialog(null, s, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    public static char[] sort(char[] v){
        // insertion sort
        int j;
        char t;
        for(int i=0; i<v.length; i++){
            j = i;
            while(j>0 && v[j-1] > v[j]){
                t = v[j];
                v[j] = v[j-1];
                v[j-1] = t;
                j--;
            }
        }
        return v;
    }
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog("Ingrese una frase");
        StringTokenizer st = new StringTokenizer(frase, " ");
        int n = st.countTokens();

        char[][] mc1 = new char [n][];
        char[][] mc2 = new char [n][];
        String palabra;

        for (int i = 0; i < mc1.length; i++) {
            palabra = st.nextToken().toLowerCase();
            mc1[i] = new char[palabra.length()];
            mc2[i] = new char[palabra.length()];

            for(int j=0; j<palabra.length(); j++){
                mc1[i][j]=palabra.charAt(j);
                mc2[i][j]=palabra.charAt(j);
            }
        }
        for(int i=0; i < mc1.length; i++){
            mc2[i] = sort(mc2[i]);
        }
        mostrarMatriz(mc1, "Matriz A");
        mostrarMatriz(mc2, "Matriz 2");
    }
}
