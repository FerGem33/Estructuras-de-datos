import javax.swing.JOptionPane;

public class U4Practica1 {
    public static ListaArticulos lista;

    public static void main(String[] args){
        lista = new ListaArticulos();

        String menu = """
        1.  Insertar un artículo al inicio de la lista
        2.  Insertar un artículo al final de la lista
        3.  Mostrar artículos de la lista
        4.  Total en inventario
        5.  Artículos que cuestan más de $100
        6.  Artículo más caro
        7.  Salir
        """;
        
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opc){
                case 1:{
                    lista.insertaInicio(crearNodo());
                    break;
                }
                case 2:{
                    lista.insertarFinal(crearNodo());
                    break;
                }
                case 3:{
                    if(!vacia()){
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                    break;
                }
                case 4:{
                    if(!vacia()){
                        JOptionPane.showMessageDialog(null, "Inventario total: $" + lista.inventarioTotal());
                    }
                    break;
                }
                case 5:{
                    if(!vacia()){
                        JOptionPane.showMessageDialog(null, lista.articulosMayoresQue(100));
                    }
                    break;
                }
                case 6:{
                    if(!vacia()){
                        JOptionPane.showMessageDialog(null, lista.max());
                    }
                    break;
                }
            }
        }while(opc != 7);
    }
    public static boolean vacia(){
        if(lista.listaVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacía: no hay artículos para mostrar.");
            return true;
        }
        return false;
    }
    public static NodoArticulo crearNodo(){
        String descripcion = JOptionPane.showInputDialog("Descripción: ");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio: "));
        return new NodoArticulo(descripcion, cantidad, precio);
    }
}
