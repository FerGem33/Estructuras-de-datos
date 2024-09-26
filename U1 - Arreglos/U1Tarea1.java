import javax.swing.JOptionPane;

public class U1Tarea1 {
    public static int readInt(String message){
        while(true){
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(message));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe introducir un número entero!");
            }
        }
    }

    public static void main(String[] args) {
        Equipo e1 = new Equipo();
        Equipo e2 = new Equipo("Leones", 'C', 13, 7);

        String nombre = JOptionPane.showInputDialog("Nombre del equipo: ");
        char division = JOptionPane.showInputDialog("División: ").charAt(0);
        int numJugadores = readInt("Número de jugadores: ");
        int puntos = readInt("Puntos: ");
        Equipo e3 = new Equipo(nombre, division, numJugadores, puntos);

        JOptionPane.showMessageDialog(null, e1.toString());
        JOptionPane.showMessageDialog(null, e2.toString());
        JOptionPane.showMessageDialog(null, e3.toString());

        nombre = e1.getNombre();
        if(e1.getPuntos() < e2.getPuntos()){
            nombre = e2.getNombre();
        }
        if(e2.getPuntos() < e3.getPuntos()){
            nombre = e3.getNombre();
        }
        JOptionPane.showMessageDialog(null, "EL equipo con más puntos es: " + nombre);
    }
}
