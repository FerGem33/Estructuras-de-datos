import javax.swing.JOptionPane;

public class U2Practica3 {
    static PilaLibro historia = new PilaLibro();  // stack of historical books
    static PilaLibro novela = new PilaLibro(7);  // stack of novels with size 7

    public static void insertar(float precio, PilaLibro pila, String nombre) {
        if (!pila.isFull()) {
            String titulo = JOptionPane.showInputDialog("Titulo: ");
            String autor = JOptionPane.showInputDialog("Autor: ");
            pila.push(new Libro(titulo, autor, precio));
        } else {
            JOptionPane.showMessageDialog(null, "La pila de " + nombre + " ya está llena!");
        }
    }

    public static void insertarLibro() {
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio: "));
        if (precio < 300) {
            insertar(precio, novela, "novelas");
        } else {
            insertar(precio, historia, "historias");
        }
    }

    public static void eliminarLibro(PilaLibro pila, String nombre) {
        if (!pila.isEmpty()) {
            String titulo = pila.pop().getTitulo();
            JOptionPane.showMessageDialog(null, "Se eliminó a: " + titulo);
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros de " + nombre + " por eliminar!");
        }
    }

    public static void mostrarPila(PilaLibro pila, String nombre) {
        String s = "Libros en " + nombre + ":\n" + pila.toString();
        JOptionPane.showMessageDialog(null, s);
    }
    public static void main(String[] args) {

        String menu = """
                1.  Insertar un libro
                2.  Eliminar un libro de historia
                3.  Eliminar un libro de novela
                4.  Mostrar libros de historia
                5.  Mostrar libros de novela
                6.  Mostrar libro de historia en el tope
                7.  Aumentar el precio de todos los libros
                8.  Vaciar la pila de novelas
                9.  Precio total de los libros
                10. Terminar
                """;

        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opc) {
                case 1: {
                    insertarLibro();
                    break;
                }
                case 2: {
                    eliminarLibro(historia, "historia");
                    break;
                }
                case 3: {
                    eliminarLibro(novela, "novela");
                    break;
                }
                case 4: {
                    mostrarPila(historia, "historia");
                    break;
                }
                case 5: {
                    mostrarPila(novela, "novela");
                    break;
                }
                case 6:{
                    if(!historia.isEmpty()){
                        historia.mostrarTope();
                    } else{
                        JOptionPane.showMessageDialog(null, "No hay libros de historia.");
                    }
                    break;
                }
                case 7:{
                    int x = Integer.parseInt(JOptionPane.showInputDialog("Porcentaje a incrementar: "));
                    historia.aumentarPorcentaje(x);
                    novela.aumentarPorcentaje(x);
                    break;
                }
                case 8:{
                    if(novela.isEmpty()){
                        JOptionPane.showMessageDialog(null, "No hay libros de novela para eliminar.");
                    } else{
                        novela.vaciar();
                    }
                    break;
                }
                case 9:{
                    float total = historia.sumaPrecios() + novela.sumaPrecios();
                    JOptionPane.showMessageDialog(null, "El precio total de los libros es: $" + total);
                    break;
                }
                case 10: {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Opción no válida!");
                    break;
                }
            }
        } while (opc != 10);
    }
}