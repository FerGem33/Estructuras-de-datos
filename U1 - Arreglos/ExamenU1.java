import javax.swing.JOptionPane;

public class ExamenU1 {
    static Cono figuras[] = new Cono[5];

    public static void showMessage(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static float readFloat(String mensaje){
        while(true){
            try{
                return Float.parseFloat(JOptionPane.showInputDialog(mensaje));
            } catch(Exception e){
                showMessage("Debe introducir un número!");
            }
        }
    }

    public static int readInt(String mensaje){
        while(true){
            try{
                return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            } catch(Exception e){
                showMessage("Debe introducir un número entero!");
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz, String titulo) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                s.append(matriz[i][j]).append(" ");
            }
            s.append("\n");
        }
        JOptionPane.showMessageDialog(null, s, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void capturarCono(){
        for (int i=0; i<figuras.length; i++){
            if(figuras[i] == null){
                float radio, altura;
                radio = readFloat("Radio: ");
                altura = readFloat("Altura: ");
                figuras[i] = new Cono(radio, altura);
                break;
            }
            showMessage("La casilla no existe, arreglo lleno!");   
        }
    }

    public static void mostrarConos(){
        for(int i=0; i<figuras.length; i++){
            if(figuras[i] != null){
                showMessage("Cono en la casilla " + i + "\n" + figuras[i].toString());
            }
        }
    }

    public static void sumarVolumenes(){
        int suma = 0;
        for(int i=0; i<figuras.length; i++){
            if(figuras[i] != null){
                suma += figuras[i].volumen();
            }
        }
        showMessage("Suma total de volúmenes: " + suma);
    }

    public static void manejarMatrices(){
        int n = readInt("Tamaño de las matrices: ");

        int a[][] = new int[n][n];
        int b[][] = new int[n][n];

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                a[i][j] = (int) (Math.random() * 50);
            }
        }

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                b[j][a.length-1-i] = a[i][j];
            }
        }

        mostrarMatriz(a, "Matriz A");
        mostrarMatriz(b, "Matriz B");
    }

    public static void main(String[] args) {
        String opciones = """
                1.  Capturar un cono
                2.  Mostrar datos de todos los conos
                3.  Suma de volúmenes
                4.  Manejo de una matriz
                5.  Terminar
                """;

        short opcion;

        do{
            opcion = Short.parseShort(JOptionPane.showInputDialog(opciones));

            switch(opcion){
                case 1:{
                    capturarCono();
                    break;
                }
                case 2:{
                    mostrarConos();
                    break;
                }
                case 3:{
                    sumarVolumenes();
                    break;
                }
                case 4:{
                    manejarMatrices();
                    break;
                }
                case 5:{
                    break;
                }
                default:{
                    showMessage("Opción no válida!");
                    break;
                }
            }
        }while(opcion != 5);
    }
}
