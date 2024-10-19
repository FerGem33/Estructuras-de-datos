import javax.swing.JOptionPane;
import java.util.Arrays;

public class U3Practica2 {
    public static ColaAutosF1 gpMexico;

    public static String input(String text){
        return JOptionPane.showInputDialog(text);
    }
    public static void print(String text){
        JOptionPane.showMessageDialog(null, text);
    }

    public static void main(String[] args) {
        String menu = """
        1.  Insertar un auto
        2.  Mostrar fila de autos
        3.  Pasar el auto del inicio al final
        4.  Buscar un auto de un piloto
        5.  Pilotos de una escudería
        6.  Podium       
        7.  Terminar
                """;

        gpMexico = new ColaAutosF1(20);
        int opc;
        do{
            opc = Integer.parseInt(input(menu));

            switch(opc){
                case 1:{
                    insertarAuto();
                    break;
                }
                case 2:{
                    mostrarCola();
                    break;
                }
                case 3:{
                    inicioAFin();
                    break;
                }
                case 4:{
                    buscarPorPiloto();
                    break;
                }
                case 5:{
                    buscarPorEscuderia();
                    break;
                }
                case 6:{
                    podium();
                    break;
                }
            }
        }while(opc != 7);
    }

    public static void insertarAuto(){
        if(!gpMexico.estaLlena()){
            String piloto, escuderia;
            int puntos;
            piloto = input("Piloto del auto:");
            escuderia = input("Escudería del auto: ");
            puntos = Integer.parseInt(input("Puntos del auto: "));

            gpMexico.insertar(new AutoFormula1(piloto, escuderia, puntos));
        } else{
            print("La cola ya está llena!");
        }
    }
    public static void mostrarCola(){
        print("Autos:\n" + gpMexico.toString());
    }
    public static void inicioAFin(){
        if(!gpMexico.estaVacia()){
            gpMexico.insertar(gpMexico.eliminar());
        }
        else{
            print("La cola está vacía!");
        }
    }
    public static void buscarPorPiloto(){
        String piloto = input("Piloto a buscar: ");
        AutoFormula1 auto;
        boolean encontrado = false;
        for(int i=gpMexico.getFrente(); i<=gpMexico.getFin(); i++){
            auto = gpMexico.getC()[i];
            if(auto.getPiloto().equals(piloto)){
                encontrado = true;
                print("Escudería: " + auto.getEscuderia() + 
                "\nPuntos: " + auto.getPuntos() + "\nLugar en la cola: " + (i-gpMexico.getFrente()+1)); 
            }
        }
        if(!encontrado){
            print("Piloto no encontrado!");
        }
    }
    public static void buscarPorEscuderia(){
        String escuderia = input("Escudería a buscar: ");
        StringBuilder s = new StringBuilder("Pilotos de la escudería " +  escuderia + ":\n");
        AutoFormula1 auto;

        for(int i=gpMexico.getFrente(); i<=gpMexico.getFin(); i++){
            auto = gpMexico.getC()[i];
            if(auto.getEscuderia().equals(escuderia)){
                s.append(auto.getPiloto()).append("\n");
            }
        }
        print(s.toString());
    }
    public static void podium(){
        StringBuilder s = new StringBuilder("Pilotos en el podio:\n");
        AutoFormula1[] sorted = sort();
        for(int i=0; i<3; i++){
            s.append(sorted[i].getPiloto()).append("\n");
        }
        print(s.toString());
    }
    public static AutoFormula1[] sort(){
        AutoFormula1[] arr = Arrays.copyOfRange(gpMexico.getC(), gpMexico.getFrente(), gpMexico.getFin()+1);
        /*
         *  Funciones lambda
         *  (params) -> expresión
         *  Para ordenar en orden ascendente:
         *  (a1, a2) -> Integer.compare(a1.getPuntos(), a2.getPuntos())
         *  Para ordenar en orden descendente:
         *  (a1, a2) -> Integer.compare(a2.getPuntos(), a1.getPuntos())
         */ 
        Arrays.sort(arr, (a1, a2) -> Integer.compare(a2.getPuntos(), a1.getPuntos()));
        return arr;
    }
}