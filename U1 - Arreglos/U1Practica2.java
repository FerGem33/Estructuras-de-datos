import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class U1Practica2 {
    public static JScrollPane crearTabla(String[][] datos, String[] columnas){
        JTable table = new JTable(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing
            }
        };
        JScrollPane scroll = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        return scroll;
    }
    public static void showMessage(Object message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarTabla(String[][] menu, String[] dias){
        JScrollPane scroll = crearTabla(menu, dias);
        showMessage(scroll, "Menú de la semana");
    }

    public static void mostrarTabla2(String[][] tabla, String[] columnas){
        //Solo funciona al imprimir en consola, no con JOptionPane
        int[] max = new int[7];
        for(int j=0; j<tabla[0].length; j++){
            max[j] = tabla[0][j].length();
            for(int i=1; i<tabla.length; i++){
                max[j] = Math.max(max[j], tabla[i][j].length());
            }
        }
        StringBuilder temp = new StringBuilder();

        for (String[] hora : tabla) {
            for (int j=0; j<hora.length; j++) {
                temp.append("| ");
                temp.append(hora[j]);
                temp.append(" ".repeat(max[j] - hora[j].length() + 1));
            }
            temp.append("\n");
        }
        System.out.println(temp);
    }

    public static void mostrarHora(String[][] menu, String[] dias, int hora){
        String[] horas = {"Almuerzo", "Comida", "Cena"};
        String[][] temp = {menu[hora]};

        JScrollPane scroll = crearTabla(temp, dias);
        showMessage(scroll, horas[hora] + "s de la semana");
    }
    public static String alimentosDia(String[][] menu, String[] dias, int dia){
        StringBuilder temp = new StringBuilder();
        temp.append("Desayuno: ").append(menu[0][dia]).append("\n");
        temp.append("Comida: ").append(menu[1][dia]).append("\n");
        temp.append("Cena: ").append(menu[2][dia]);
        return temp.toString();
    }
    public static void mostrarPorDias(String[][] tabla, String[] columnas){
        StringBuilder temp = new StringBuilder();

        for(int d=0; d<tabla[0].length; d++){
            temp.append("Menú del ").append(columnas[d]).append(":\n");
            temp.append(alimentosDia(tabla, columnas, d)).append("\n-----------------------------------\n");
        }
        showMessage(temp.toString(), "Menú por días");
    }
    public static void main(String[] args) {
        String[][] alimentos =
            {{"Avena", "Cereal", "Huevo", "Yogur", "Fruta","Pan tostado", "Hot cakes"},
            {"Pollo", "Sándwich", "Verduras", "Atún", "Bistec", "Champiñones", "Espagueti"},
            {"Frijoles", "Quesadillas", "Estofado", "Picadillo", "Lasaña", "Ensalada", "Pizza"}};
        String opciones = """
                1. Menú completo \s
                2. Menú de almuerzos \s
                3. Menú por día \s
                4. Menú de un día específico \s
                5. Salir
                """;
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String[] horas = {"Almuerzo", "Comida", "Cena"};

        boolean continuar = true;
        short opcion;

        while (continuar) {
            opcion = Short.parseShort(JOptionPane.showInputDialog(null, opciones, "Menú", JOptionPane.QUESTION_MESSAGE));
            switch(opcion){
                case 1:{
                    mostrarTabla(alimentos, dias);
                    //mostrarTabla2(alimentos, dias);
                    break;
                }
                case 2:{
                    mostrarHora(alimentos, dias, 0);
                    break;
                }
                case 3:{
                    mostrarPorDias(alimentos, dias);
                    break;
                }
                case 4:{
                    int dia = JOptionPane.showOptionDialog(null, "Seleccione el día", "Menú por día", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, dias, 0);
                    showMessage(alimentosDia(alimentos, dias, dia), "Menú del " + dias[dia] + ":");
                    break;
                }
                case 5:{
                    continuar = false;
                    break;
                }
                case 6:{
                    int hora = JOptionPane.showOptionDialog(null, "Seleccione la hora", "Menú por hora", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, horas, 0);
                    mostrarHora(alimentos, dias, hora);
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Opción no válida!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }
}
