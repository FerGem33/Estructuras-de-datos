import javax.swing.JOptionPane;

public class U1Practica1 {
    public static int leerInt(String mensaje, String titulo){
        while(true){
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe introducir un número entero!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static boolean noVacio(Equipo[] vector){
        return vector[0] != null;
    }

    public static void main(String[] args) {
        Equipo[] ligaNorte = new Equipo[8];
        boolean continuar = true;
        int i = 0;
        int opcion;
        String menu = """
                1. Nuevo equipo.\s
                2. Mostrar equipos.\s
                3. Mostrar equipos clasificados.
                4. Mostrar equipo con más puntos.\s
                5. Terminar""";

        while(continuar){
            opcion = leerInt(menu, "Menú");
            switch(opcion){
                case 1:{ // Guardar equipo en el vector
                    if(i < ligaNorte.length){
                        String titulo = "Equipo nuevo";
                        String nombre = JOptionPane.showInputDialog(null, "Nombre del equipo: ", titulo, JOptionPane.QUESTION_MESSAGE);
                        char division = JOptionPane.showInputDialog("División: ").charAt(0);
                        int numJugadores = leerInt("Número de jugadores: ", titulo);
                        int puntos = leerInt("Puntos: ", titulo);

                        ligaNorte[i] = new Equipo(nombre, division, numJugadores, puntos);
                        i++;
                    } else{
                        JOptionPane.showMessageDialog(null, "Límite de equipos alcanzado!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
                case 2:{ // Mostrar datos de los equipos
                    if(noVacio(ligaNorte)){
                        for (Equipo equipo : ligaNorte) {
                            if (equipo != null) {
                                JOptionPane.showMessageDialog(null, equipo.toString(), "Equipos", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "No hay equipos registrados!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
                case 3:{ //Equipos clasificados
                    if(noVacio(ligaNorte)){
                        for (Equipo equipo : ligaNorte) {
                            if (equipo != null && equipo.getClasifica())
                                JOptionPane.showMessageDialog(null, equipo.toString(), "Equipos clasificados", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "No hay equipos registrados!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
                case 4:{ // Equipo con más puntos
                    if(noVacio(ligaNorte)){
                        Equipo max = ligaNorte[0];
                        for (Equipo equipo : ligaNorte) {
                            if (equipo != null && equipo.getPuntos() > max.getPuntos()){
                                max = equipo;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Equipo con más puntos.\n" + max.toString(), "Equipo ganador", JOptionPane.INFORMATION_MESSAGE);
                    } else{
                        JOptionPane.showMessageDialog(null, "No hay equipos registrados!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
                case 5:{ // Terminar
                    continuar = false;
                    break;
                }
            }
        }
    }
}
