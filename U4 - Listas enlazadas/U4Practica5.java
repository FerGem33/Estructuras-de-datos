import javax.swing.*;
import java.awt.*;

public class U4Practica5 {
    private static ListaCircularAlumnos grupoA;

    public static void main(String[] args) {
        grupoA = new ListaCircularAlumnos();

        String[] options = {
                "Agregar un alumno", "Mostrar alumnos del grupo A", "Promedio de calificaciones", "Buscar alumno", "Terminar"
        };

        JFrame frame = new JFrame("Grupo A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        // Crear botones
        JButton[] buttons = new JButton[options.length + 1];
        for (int i = 0; i < options.length; i++) {
            buttons[i] = new JButton(options[i]);
        }

        // Listeners
        buttons[0].addActionListener(e -> agregarAlumno());
        buttons[1].addActionListener(e -> mostrarTodos());
        buttons[2].addActionListener(e -> mostrarPromedio());
        buttons[3].addActionListener(e -> buscarAlumno());
        buttons[options.length - 1].addActionListener(e -> System.exit(0));

        for (int i = 0; i < options.length; i++) {
            panel.add(buttons[i]);
        }

        // Add panel to the frame
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static int readInt(String message) {
        int x;
        while(true) {
            try{
                x = Integer.parseInt(JOptionPane.showInputDialog(message));
                return x;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero!");
            }
        }
    }
    public static float readFloat(String message) {
        float x;
        while(true) {
            try{
                x = Float.parseFloat(JOptionPane.showInputDialog(message));
                return x;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número!");
            }
        }
    }

    public static void agregarAlumno(){
        int numControl = readInt("Número de control: ");
        String nombre = JOptionPane.showInputDialog("Nombre: ");
        float[] calif = new float[3];
        for(int i = 0; i < calif.length; i++) {
            calif[i] = readFloat("Calificación " + (i+1) +":");
        }
        grupoA.insertarAlfabeticamente(new NodoAlumno(new Alumno(numControl, nombre, calif)));
    }

    public static boolean vacio(){
        if(grupoA.listaVacia()){
            JOptionPane.showMessageDialog(null, "El grupo está vacío.");
            return true;
        }
        return false;
    }

    public static void mostrarTodos(){
        if(!vacio()){
            JOptionPane.showMessageDialog(null, grupoA.toString());
        }
    }

    public static void mostrarPromedio(){
        if(!vacio()){
            JOptionPane.showMessageDialog(null, "El promedio del grupo es: " + grupoA.promedioCalif());
        }
    }

    public static void buscarAlumno(){
        if(!vacio()){
            String nombre = JOptionPane.showInputDialog("Nombre: ");
            Alumno alumno = grupoA.buscarAlumno(nombre);
            if(alumno != null){
                JOptionPane.showMessageDialog(null, alumno.toString());
            } else{
                JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
            }
        }
    }
}
