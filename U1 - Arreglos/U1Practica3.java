import javax.swing.JOptionPane;

public class U1Practica3 {
    public static int[][] cuadrada;

    public static void main(String[] args) throws Exception {
        String menu = "1. Generar una nueva matriz." +
                "\n2. Desplegar la matriz." +
                "\n3. Suma datos de la matriz." +
                "\n4. Sustituir multiplos de 5 por 0's" +
                "\n5. Suma de la diagonal principal." +
                "\n6. Salir.";

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (opcion) {
                case 1:
                    int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Escribe el tamaño de tu matriz:"));
                    U1Practica3.crearMatriz(size);
                    break;

                case 2:
                    U1Practica3.mostrarMatriz();
                    break;

                case 3:
                    U1Practica3.sumarMatriz();
                    break;

                case 4:
                    U1Practica3.reemplazar5();
                    break;

                case 5:
                    U1Practica3.sumarDiagonal();
                    break;
            }
        } while (opcion != 6);

    }

    public static void crearMatriz(int size) {
        U1Practica3.cuadrada = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cuadrada[i][j] = (int) (Math.random() * 100) + 1;
            }
        }
    }

    public static void mostrarMatriz() {
        String matrizString = "";

        if (cuadrada.length == 0) {
            matrizString = "NO HAY MATRIZ PARA MOSTRAR";
        } else {
            for (int i = 0; i < cuadrada.length; i++) {
                for (int j = 0; j < cuadrada.length; j++) {
                    matrizString += U1Practica3.cuadrada[i][j] + ", ";
                }
                matrizString = matrizString.substring(0, matrizString.length() - 2) + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, matrizString);
    }

    public static void sumarMatriz() {
        String message = "";

        if (cuadrada.length == 0) {
            message = "NO HAY MATRIZ PARA MOSTRAR";
        } else {
            int total = 0;
            for (int i = 0; i < cuadrada.length; i++) {
                for (int j = 0; j < cuadrada.length; j++) {
                    total += U1Practica3.cuadrada[i][j];
                }
            }
            message = "Total = " + total;
        }
        JOptionPane.showMessageDialog(null, message);
    }

    public static void reemplazar5() {
        String matrizString = "";

        if (cuadrada.length == 0) {
            matrizString = "NO HAY MATRIZ PARA MOSTRAR";
        } else {
            for (int i = 0; i < cuadrada.length; i++) {
                for (int j = 0; j < cuadrada.length; j++) {
                    if (U1Practica3.cuadrada[i][j] % 5 != 0) {
                        matrizString += U1Practica3.cuadrada[i][j] + ", ";
                    } else {
                        matrizString += 0 + ", ";
                    }

                }
                matrizString = matrizString.substring(0, matrizString.length() - 2) + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, matrizString);
    }

    public static void sumarDiagonal() {
        String message = "";

        if (cuadrada.length == 0) {
            message = "NO HAY MATRIZ PARA MOSTRAR";
        } else {
            int total = 0;
            int column = 0;
            int row = 0;
            for (int i = 0; i < cuadrada.length; i++) {
                for (int j = 0; j < cuadrada.length; j++) {
                    if (i == column && j == row) {
                        total += U1Practica3.cuadrada[i][j];
                        column++;
                        row++;
                    }
                }
            }
            message = "Total = " + total;
        }
        JOptionPane.showMessageDialog(null, message);
    }
}