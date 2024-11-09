import javax.swing.JOptionPane;

public class U4Practica2 {
    public static ListaAutos vehiculos;

    public static void main(String[] args) {
        String menu = """
                1. Insertar un automóvil
                2. Mostrar todos los autos
                3. Auto con el mayor kilometraje
                4. Buscar por placa
                5. Buscar por propietario
                6. Modificar kilometraje
                7. Terminar
                """;
        vehiculos = new ListaAutos();
        int opc; 
        
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch(opc){
                case 1:{
                    insertaAuto();
                    break;
                }
                case 2:{
                    mostrarAutos();
                    break;
                }
                case 3:{
                    maxKilometraje();
                    break;
                }
                case 4:{
                    buscarPlaca();
                    break;
                }
                case 5:{
                    buscarPropietario();
                    break;
                }
                case 6:{
                    actualizarKilometraje();
                    break;
                }
            }    
        } while(opc != 7);
    }
    public static void insertaAuto(){
        String placa = JOptionPane.showInputDialog("Placa: ");
        String propietario = JOptionPane.showInputDialog("Propietario: ");
        int kilometraje = Integer.parseInt(JOptionPane.showInputDialog("Kilometraje: "));

        vehiculos.insertaAlfabetiamente(new NodoAuto(placa, propietario, kilometraje));
    }
    public static void mostrarAutos(){
        if(vehiculos.listaVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacía!");
        } else{
            JOptionPane.showMessageDialog(null, vehiculos.toString());
        }
    }
    public static void maxKilometraje(){
        if(!vehiculos.listaVacia()){
            NodoAuto i = vehiculos.getInicio(), max = i;

            do{
                if(max.getKilometraje() < i.getKilometraje()){
                    max = i;
                }
                i = i.getNext();
            } while(i != null);
            JOptionPane.showMessageDialog(null, max.toString());
        } else{
            JOptionPane.showMessageDialog(null, "Lista vacía!");
        }
    }
    public static void buscarPlaca(){
        if(vehiculos.listaVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacía!");
        } else{
            String placa = JOptionPane.showInputDialog("Placa a buscar: ");
            NodoAuto auto = vehiculos.buscarPlaca(placa);

            if(auto != null){
                JOptionPane.showMessageDialog(null, auto.toString());
            } else{
                JOptionPane.showMessageDialog(null, "AUTOMÓVIL CON ESA PLACA NO EXISTE");
            }
        }
    }
    public static void buscarPropietario(){
        if(vehiculos.listaVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacía!");
        } else{
            String propietario = JOptionPane.showInputDialog("Propietario a buscar: ");
            NodoAuto auto = vehiculos.buscarPropietario(propietario);

            if(auto != null){
                JOptionPane.showMessageDialog(null, auto.toString());
            } else{
                JOptionPane.showMessageDialog(null, "AUTOMÓVIL DE ESE PROPIETARIO NO EXISTE");
            }
        }
    }
    public static void actualizarKilometraje(){
        if(vehiculos.listaVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacía!");
        } else{
            String placa = JOptionPane.showInputDialog("Placa a buscar: ");
            NodoAuto auto = vehiculos.buscarPlaca(placa);

            if(auto != null){
                JOptionPane.showMessageDialog(null, "Kilometraje actual: " + auto.getKilometraje());
                int km = Integer.parseInt(JOptionPane.showInputDialog("Nuevo kilometraje: "));
                auto.setKilometraje(km);
            } else{
                JOptionPane.showMessageDialog(null, "AUTOMÓVIL CON ESA PLACA NO EXISTE");
            }
        }
    }
}
