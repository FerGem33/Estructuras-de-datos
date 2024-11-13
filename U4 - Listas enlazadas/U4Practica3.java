import javax.swing.JOptionPane;

public class U4Practica3 {
    public static ListaAutos vehiculos;

    public static void main(String[] args) {
        String menu = """
                1. Insertar un automóvil
                2. Mostrar todos los autos
                3. Auto con el mayor kilometraje
                4. Buscar por placa
                5. Buscar por propietario
                6. Modificar kilometraje
                7. Eliminar primer auto
                8. Eliminar último auto
                9. Eliminar un auto por placa
                10. Terminar
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
                case 7:{
                    eliminaPrimero();
                    break;
                }
                case 8:{
                    eliminaUltimo();
                    break;
                }
                case 9:{
                    eliminaPlaca();
                    break;
                }
                case 10:{
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Opción no válida!");
                    break;
                }
            }    
        } while(opc != 10);
    }
    public static boolean noVacia(){
        if(vehiculos.listaVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacía!");
            return false;
        }
        return true;
    } 
    public static void insertaAuto(){
        String placa = JOptionPane.showInputDialog("Placa: ");
        String propietario = JOptionPane.showInputDialog("Propietario: ");
        int kilometraje = Integer.parseInt(JOptionPane.showInputDialog("Kilometraje: "));

        vehiculos.insertaAlfabetiamente(new NodoAuto(placa, propietario, kilometraje));
    }
    public static void mostrarAutos(){
        if(noVacia()){
            JOptionPane.showMessageDialog(null, vehiculos.toString());
        }
    }
    public static void maxKilometraje(){
        if(noVacia()){
            NodoAuto i = vehiculos.getInicio(), max = i;

            do{
                if(max.getKilometraje() < i.getKilometraje()){
                    max = i;
                }
                i = i.getNext();
            } while(i != null);
            JOptionPane.showMessageDialog(null, max.toString());
        }
    }
    public static void buscarPlaca(){
        if(noVacia()){
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
        if(noVacia()){
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
        if(noVacia()){
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
    public static void eliminaPrimero(){
        if(noVacia()){
            JOptionPane.showMessageDialog(null, vehiculos.eliminaPrimero().toString());
        }
    }
    public static void eliminaUltimo(){
        if(noVacia()){
            JOptionPane.showMessageDialog(null, vehiculos.eliminaUltimo().toString());
        }
    }
    public static void eliminaPlaca(){
        if(noVacia()){
            String placa=JOptionPane.showInputDialog("Ingrese la placa del vehículo");
            vehiculos.eliminarPorPlaca(placa);
        }
    }
}
