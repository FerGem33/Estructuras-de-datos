import javax.swing.JOptionPane;

public class U1Practica4 {
    public static int[][]cuadradaA,cuadradaB;

    public static void mostrarMatriz(int[][] matriz) {
        String matrizString = "";

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] < 10) {
                    matrizString += "0" + matriz[i][j] + "   ";
                } else{
                    matrizString += matriz[i][j] + "   ";
                }
            }
            matrizString += "\n";
        }
        JOptionPane.showMessageDialog(null, matrizString);
    }

    public static void crearA(){
        int cont = 1;
        int n=Integer.parseInt(JOptionPane.showInputDialog("¿De qué tamaño deseas que sea tu matriz A?"));
        cuadradaA=new int[n][n];

        int a = 0, b = cuadradaA.length-1;
        for(int k=0; k<cuadradaA.length; k++){
            if(k % 2 == 0){
                for(int j=0; j<cuadradaA[k].length; j++){
                    cuadradaA[a][j] = cont++;
                }
                a++;
            } else{
                for(int j=0; j<cuadradaA[k].length; j++){
                    cuadradaA[b][j] = cont++;
                }
                b--;
            }
        }
        mostrarMatriz(cuadradaA);
    }

    public static void crearB(){
        int cont = 1;
        int n=Integer.parseInt(JOptionPane.showInputDialog("¿De qué tamaño deseas que sea tu matriz B?"));
        cuadradaB=new int[n][n];

        for(int i=0; i<cuadradaB.length; i++){
            for(int j=0; j<cuadradaB[i].length; j++){
                if(i<=j){
                    cuadradaB[i][j] = cont++;
                }else{
                    cuadradaB[i][j] = 0;
                }
            }
        }
        mostrarMatriz(cuadradaB);
    }

    public static void main(String[] args) {
        String menu = """
            1. Matriz A\s
            2. Matriz B\s
            3. Terminar
            """;
        boolean continuar = true;
        int opc;
        while(continuar){
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opc){
                case 1:{
                    crearA();
                    break;
                }
                case 2:{
                    crearB();
                    break;
                }
                case 3:{
                    continuar = false;
                    break;
                }
            }
        }
    }
}
