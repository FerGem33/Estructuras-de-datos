import javax.swing.JOptionPane;

public class ExamenUnidad3 {
    public static ColaCircularJugadores uefa;

    public static void main(String[] args) {
        String menu = """
                1.  Insertar jugador
                2.  Mostrar Jugadores
                3.  Jugador con más goles
                4.  Buscar un Jugador
                5.  Jugadores de un equipo
                6.  Terminar
                """;

        uefa = new ColaCircularJugadores(20);

        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch(opc){
                case 1:
                    insertarJugador();
                    break;
                case 2:
                    mostrarJugadores();
                    break;
                case 3:
                    masGoles();
                    break;
                case 4:
                    buscarJugador();
                    break;
                case 5:
                    jugadoresPorEquipo();
                    break;
            }
        } while(opc != 6);
    }

    public static void insertarJugador(){
        if(!llena()) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
            String[] equipos = {"Juventus", "Manchester", "Arsenal"};
            int eq = JOptionPane.showOptionDialog(null, "Seleccione el equipo:",
                    "Nuevo jugador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, equipos, 0);

            int goles = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los goles: "));
            uefa.insertar(new Jugador(nombre, equipos[eq], goles));
        }
    }
    public static void mostrarJugadores(){
        if(!vacia()) {
            StringBuilder s = new StringBuilder();
            int indice = uefa.getFrente(), i = 1;
            while (i <= uefa.getContador()) {
                s.append(uefa.getCc()[indice].toString()).append('\n');

                if (indice == uefa.getCc().length - 1)
                    indice = 0;
                else
                    indice++;
                i++;
            }
            JOptionPane.showMessageDialog(null, s.toString());
        }
    }
    public static void masGoles(){
        if(!vacia()) {
            Jugador max = uefa.getCc()[uefa.getFrente()];

            int indice = uefa.getFrente(), i = 1;
            while (i <= uefa.getContador()) {
                if(max.getGoles() < uefa.getCc()[indice].getGoles()){
                    max = uefa.getCc()[indice];
                }
                if (indice == uefa.getCc().length - 1)
                    indice = 0;
                else
                    indice++;
                i++;
            }
            JOptionPane.showMessageDialog(null, "Jugador con más goles:\n" + max.getNombre());
        }
    }
    public static void buscarJugador(){
        if(!vacia()) {
            String nombre = JOptionPane.showInputDialog("Nombre del jugador a buscar: ");

            int indice = uefa.getFrente(), i = 1;
            while (i <= uefa.getContador()) {
                if(nombre.equals(uefa.getCc()[indice].getNombre())){
                    JOptionPane.showMessageDialog(null, "El jugador está en la fila.");
                    return;
                }
                if (indice == uefa.getCc().length - 1)
                    indice = 0;
                else
                    indice++;
                i++;
            }
            JOptionPane.showMessageDialog(null, "El jugador no está en la fila.");
        }
    }
    public static void jugadoresPorEquipo(){
        String[] equipos = {"Juventus", "Manchester", "Arsenal"};
        int eq = JOptionPane.showOptionDialog(null, "Seleccione el equipo:",
                "Nuevo jugador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, equipos, 0);
        if(!vacia()) {
            StringBuilder s = new StringBuilder();
            int indice = uefa.getFrente(), i = 1;
            while (i <= uefa.getContador()) {
                if(equipos[eq].equals(uefa.getCc()[indice].getEquipo())){
                    s.append(uefa.getCc()[indice].getNombre()).append('\n');
                }

                if (indice == uefa.getCc().length - 1)
                    indice = 0;
                else
                    indice++;
                i++;
            }
            JOptionPane.showMessageDialog(null, "Jugadores en " + equipos[eq] + ":\n" + s.toString());
        }
    }
    public static boolean vacia(){
        if(uefa.estaVacia()){
            JOptionPane.showMessageDialog(null, "NO HAY DATOS PARA MOSTRAR");
            return true;
        }
        return false;
    }
    public static boolean llena(){
        if(uefa.estaLlena()){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE INSERTAR");
            return true;
        }
        return false;
    }
}
