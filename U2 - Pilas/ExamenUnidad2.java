import javax.swing.JOptionPane;

public class ExamenUnidad2 {
    static PilaMaterias basicas, optativas;
    public static int leerInt(String mensaje){
        while(true){
            try{
                return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Debe introducir un número entero!");
            }
        }
    }
    
    public static void insertarMateria(){
        String tipos[] = {"Básica", "Optativa"}; 
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de materia:", 
        "Nueva materia", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
        null, tipos, 0);

        if(tipo==0){
            if(!basicas.isFull()){
                String nombre = JOptionPane.showInputDialog("Nombre de la materia: ");
                int creditos = leerInt("Créditos de la materia:");
                String clave = JOptionPane.showInputDialog("Clave de la materia:");
                basicas.push(new Materia(nombre, creditos, clave));
            } else{
                JOptionPane.showMessageDialog(null, "La pila de materias básicas ya está llena!");
            }
        } else{
            if(!optativas.isFull()){
                String nombre = JOptionPane.showInputDialog("Nombre de la materia: ");
                int creditos = leerInt("Créditos de la materia:");
                String clave = JOptionPane.showInputDialog("Clave de la materia:");
                optativas.push(new Materia(nombre, creditos, clave));
            } else{
                JOptionPane.showMessageDialog(null, "La pila de materias optativas ya está llena!");
            }
        }
    }
    
    public static void mostrarMaterias(String tipo){
        PilaMaterias pila;
        if(tipo == "básicas"){
            pila = basicas;
        } else{
            pila = optativas;
        }
        JOptionPane.showMessageDialog(null, "Materias " + tipo + ":\n" + pila.toString());
    }
    public static void transferirAOptativa(){
        if(!basicas.isEmpty()){
            Materia x = basicas.pop();
            if(!optativas.isFull()){
                optativas.push(x);
                JOptionPane.showMessageDialog(null, "Materia transferida:\n" + x.getNombre());
            } else{
                JOptionPane.showMessageDialog(null, "La pila de materias optativas ya está llena");
            }            
        } else{
            JOptionPane.showMessageDialog(null, "La pila de materias básicas está vacía");
        }
    }
    public static void mostrarMenores(){
        StringBuilder s = new StringBuilder("Materias de menos de 4 créditos:\n");
        for(int i=basicas.getTope(); i>=0; i--){
            Materia x = basicas.getP()[i];
            if(x.getCreditos() < 4){
                s.append(x.getNombre()).append("\n");
            }
        }
        for(int i=optativas.getTope(); i>=0; i--){
            Materia x = optativas.getP()[i];
            if(x.getCreditos() < 4){
                s.append(x.getNombre()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, s.toString());
    }
    public static void main(String[] args) {
        basicas = new PilaMaterias(8);
        optativas = new PilaMaterias(8);

        String menu = """
                1.  Insertar materia
                2.  Mostrar materias básicas
                3.  Mostrar materias optativas
                4.  Transferir un materia básica a optativa
                5.  Materias con menos de 4 créditos
                6.  Terminar
                """;
        
        int opc;
        
        do{
            opc = leerInt(menu);

            switch(opc){
                case 1:{
                    insertarMateria();
                    break;
                }
                case 2:{
                    mostrarMaterias("básicas");
                    break;
                }
                case 3:{
                    mostrarMaterias("optativas");
                    break;
                }
                case 4:{
                    transferirAOptativa();;
                    break;
                }
                case 5:{
                    mostrarMenores();
                    break;
                }
            }
        } while(opc != 6);
    }
}
