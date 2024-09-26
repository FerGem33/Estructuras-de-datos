import javax.swing.JOptionPane;

public class U2Practica1 {
    static PilaString amigos = new PilaString(10); 

    public static void capturarAmigo(){
        if(!amigos.isFull()){
            String nombre = JOptionPane.showInputDialog("Nombre del amigo: ");
            amigos.push(nombre);
        } else{
            JOptionPane.showMessageDialog(null, "La pila ya está llena!");
        }
    }
    public static void mostrarAmigos(){
        String s = "Amigos en la pila: " + amigos.size() + "\n" + amigos.toString();
        JOptionPane.showMessageDialog(null, s);
    }
    public static void eliminarAmigo(){
        if(!amigos.isEmpty()){
            String nombre = amigos.pop();
            JOptionPane.showMessageDialog(null, "Se eliminó a " + nombre);
        } else{
            JOptionPane.showMessageDialog(null, "La pila está vacía!");
        }
    }
    public static void amigoTope(){
        int tope = amigos.getTope();
        if(tope >= 0){
            JOptionPane.showMessageDialog(null, amigos.getP()[amigos.getTope()]);
        } else{
            JOptionPane.showMessageDialog(null, "La pila está vacía!");
        }
    }

    public static void main(String[] args) {
        String menu = """
                1.  Capturar nombre de amigo
                2.  Mostrar pila de amigos
                3.  Eliminar un amigo
                4.  Amigo en el tope de la pila
                5.  Terminar
                """;

        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch(opc){
                case 1:{
                    capturarAmigo();
                    break;
                }
                case 2:{
                    mostrarAmigos();
                    break;
                }
                case 3:{
                    eliminarAmigo();
                    break;
                }
                case 4:{
                    amigoTope();
                    break;
                }
                case 5:{
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Opción no válida!");
                    break;
                }
            }
        } while(opc != 5);
    }
}
