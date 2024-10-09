import javax.swing.JOptionPane;

public class U2Practica5 {
    public static void main(String[] args) {
        DoblePila pilita = new DoblePila(50) ;
        int opcion;
        String menu = """
                1   Insertar número
                2.  Mostrar pila de pares
                3.  Mostrar pila de impares
                4.  Eliminar un par
                5.  Eliminar un impar
                6.  Terminar
                """;
    
        do{  
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                case 1:{
                    int insertar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor entero"));
                    if(insertar % 2 == 0){
                        pilita.pushPila1(insertar);
                    } else{
                        pilita.pushPila2(insertar);
                    } 
                    break;
                }
                case 2:{
                    String s = "Números en pila de pares: " + pilita.sizePila1() + "\n" + pilita.toStringPila1();
                    JOptionPane.showMessageDialog(null, s);
                    break;
                }
                case 3:{
                    String s = "Números en pila de impares: " + pilita.sizePila2() + "\n" +pilita.toStringPila2();
                    JOptionPane.showMessageDialog(null, s);
                    break;
                }
                case 4:{
                    JOptionPane.showMessageDialog(null,pilita.popPila1());
                    break;
                }
                case 5:{
                    JOptionPane.showMessageDialog(null,pilita.popPila2());
                    break;
                }
                case 6:{
                    break;
                }
            }
        }while(opcion != 6);
    }
}