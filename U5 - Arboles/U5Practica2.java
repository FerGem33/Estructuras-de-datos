import javax.swing.JOptionPane;

public class U5Practica2 {
    public static ArbolBinario arbol;

    public static void main(String[] args) {
        String menu = """
                1. Insertar un número
                2. Recorrido Preorden
                3. Recorrido Inorden
                4. Recorrido Postorden
                5. Suma total de números
                6. Números en los nodos HOJA
                7. Terminar
                """;

        arbol = new ArbolBinario();
        int opc;

        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opc){
                case 1:
                    int x = Integer.parseInt(JOptionPane.showInputDialog("Número a insertar: "));
                    arbol.insertar(new NodoArbolBin(x));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, arbol.preorden(arbol.getRaiz()));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, arbol.inorden(arbol.getRaiz()));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, arbol.postorden(arbol.getRaiz()));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, arbol.suma(arbol.getRaiz()));
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, arbol.hojas(arbol.getRaiz()));
                    break;
            }
        } while(opc != 7);
    }
}
