import javax.swing.JOptionPane;

public class U3Practica1 {
    public static ColaString singular, plural;   

    public static void leerPalabra(){
        String palabra = JOptionPane.showInputDialog("Ingrese la palabra: ");
        char x = palabra.charAt(palabra.length() - 1);
        if(x != 's'){
            singular.insertar(palabra);
        } else{
            plural.insertar(palabra);
        }
    }
    public static void mostarPalabras(String cola){
        String x;
        if(cola == "singular"){
            x = singular.toString();
        } else{
            x = plural.toString();
        }
        JOptionPane.showMessageDialog(null, "Palabras en "+ cola +":\n" + x);
    }
    public static void eliminarPalabra(String cola){
        String x;
        if(cola == "singular"){
            if(!singular.estaVacia()){
                x = singular.eliminar();
                JOptionPane.showMessageDialog(null, "Palabra eliminada de singular\n" + x);
            } else{
                JOptionPane.showMessageDialog(null, "No hay palabra en singular para eliminar");
            }
        } else{
            if(!plural.estaVacia()){
                x = plural.eliminar();
                JOptionPane.showMessageDialog(null, "Palabra eliminada de plural:\n" + x);
            } else{
                JOptionPane.showMessageDialog(null, "No hay palabra en plural para eliminar");
            }
        }
    }
    public static void cantidadPalabras(){
        int a = singular.numElementos();
        int b = plural.numElementos();
        String s = "Cantidad de palabras en singular: " +  a
                + "\nCantidad de palabras en plural: " + b
                +"\nTotal: " + (a + b);
        JOptionPane.showMessageDialog(null, s);
    }
    public static void frenteSingular(){
        String s = "Palabra al frente de singular: " + singular.datoEnFrente();
        JOptionPane.showMessageDialog(null, s);
    }
    public static void finPlural(){
        String s = "Palabra al final de plural: " + plural.datoEnFin();
        JOptionPane.showMessageDialog(null, s);
    }

    public static void main(String[] args) {
        singular = new ColaString(12);
        plural = new ColaString(12);

        String menu = """
                1.  Leer una palabra
                2.  Mostrar palabras en singular
                3.  Mostrar palabras en plural
                4.  ELiminar una palabra singular
                5.  Eliminar una palabra plural
                6.  Cantidad de palabras
                7.  Palabra al inicio de singulares
                8.  Palabra al final de plurales
                9.  Terminar 
                """;

        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opc) {
                case 1:{
                    leerPalabra();
                    break;
                }
                case 2:{
                    mostarPalabras("singular");
                    break;
                }
                case 3:{
                    mostarPalabras("plural");
                    break;
                }
                case 4:{
                    eliminarPalabra("singular");
                    break;
                }
                case 5:{
                    eliminarPalabra("plural");
                    break;
                }
                case 6:{
                    cantidadPalabras();
                    break;
                }
                case 7:{
                    frenteSingular();
                    break;
                }
                case 8:{
                    finPlural();
                    break;
                }
            }

        } while(opc != 9);
    }
}
