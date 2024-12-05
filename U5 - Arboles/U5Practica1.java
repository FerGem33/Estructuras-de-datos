import javax.swing.JOptionPane;

public class U5Practica1 {
    public static void main(String[] args) {
        String menu = """
                1.  Método común divisor de 2 enteros
                2.  Multiplicar campesino egipcio
                3.  Convertir decimal a binario
                4.  Terminar
                """;

        int opc;

        do{
            opc = readInt(menu);

            switch(opc){
                case 1: {
                    int a = readInt("a: ");
                    int b = readInt("b: ");
                    JOptionPane.showMessageDialog(null, mcd(a, b));
                    break;
                }
                case 2: {
                    int a = readInt("a: ");
                    int b = readInt("b: ");
                    JOptionPane.showMessageDialog(null, multCampesino(a, b));
                    break;
                }
                case 3: {
                    int n = readInt("Número en decimal: ");
                    JOptionPane.showMessageDialog(null, decToBin(n));
                    break;
                }
            }
        } while(opc != 4);
    }
    public static int readInt(String message){
        while(true){
            try{
                return Integer.parseInt(JOptionPane.showInputDialog(message));
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero");
            }
        }
    }

    public static int mcd(int a, int b){
        if(b == 0) return a;
        return mcd(b, a % b);
    }
    public static int multCampesino(int a, int b){
        if(b == 0) return 0;
        if(b == 1) return 1;
        if(b >= 2 && b % 2 == 0) return multCampesino(2 * a, b/2);
        return multCampesino(2 * a, b / 2) + a;
    }
    public static String decToBin(int n){
        if (n / 2 != 0) return decToBin(n / 2) + (n % 2);
        return "1";
    }
}
