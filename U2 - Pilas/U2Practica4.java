import javax.swing.JOptionPane;

public class U2Practica4 {
    public static PilaChar letras, digitos, simbolos; 

    public static void añadir(char x, PilaChar pila){
        if(!pila.contains(x)){
            pila.push(x);
        }
    }

    public static void leerEnunciado(){
        String frase = JOptionPane.showInputDialog("Ingrese la frase: ");
        int n = frase.length();
        char x;
        letras = new PilaChar(n);
        digitos = new PilaChar(n);
        simbolos = new PilaChar(n);

        for(int i=0; i<n; i++){
            x = frase.charAt(i);

            if(x == ' '){
                continue;
            }
            if(Character.isLetter(x)){
                añadir(x, letras);
                continue;
            }
            if(Character.isDigit(x)){
                añadir(x, digitos);
                continue;
            }
            añadir(x, simbolos);
        }
    }

    public static void mostrar(PilaChar pila, String nombre){
        String s = "Carácteres en " + nombre + ":\n" + pila.toString();
        JOptionPane.showMessageDialog(null, s);
    }
    public static void main(String[] args) {
        letras = digitos = simbolos = new PilaChar();
        String menu = """
                1.  Leer un enunciado
                2.  Mostrar pila de letras
                3.  Mostrar pila de dígitos
                4.  Mostrar pila de símbolos
                5.  Salir
                """;
        int opc;

        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch (opc) {
                case 1:
                    leerEnunciado();
                    break;
                case 2:
                    mostrar(letras, "letras");
                    break;
                case 3:
                    mostrar(digitos, "dígitos");
                    break;
                case 4:
                    mostrar(simbolos, "símbolos");
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        } while (opc != 5);
    }
}
