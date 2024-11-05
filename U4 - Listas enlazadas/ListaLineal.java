
/** CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA LINEAL Ó SIMPLE 
 * La lista que vamos a estar manejando tiene solo 1 atributo:
 * el apuntador al primer nodo (inicio) del mismo tipo de la clase Nodo
*/
 
public class ListaLineal {
    // Atributos
    private Nodo inicio; 
    
    /* Constructor que crea una lista vacía SIN NODOS, 
    por eso el contador de nodos queda en CERO y el apuntador 
    inicio que va a guardar la dirección del primer nodo (cuando exista) 
    se inicializa de momento en null*/
    public ListaLineal () { 
        inicio = null; 
    }

    // get...
    public Nodo getInicio ( ) { 
        return inicio;
    }
    
    // set...
    public void setInicio (Nodo nuevoInicio) {
        inicio = nuevoInicio;
    }
        
    // Método que devuelve true si la lista está vacía
    public boolean listaVacia() { 
        return (inicio == null);
    }

    // Método que inserta un nodo al inicio de la lista 
    public void insertaInicio (Nodo nuevo) {
        nuevo.setNext(inicio);
        inicio = nuevo;
    }
    // Método para insertar un nodo al final de la lista 
    public void insertarFinal(Nodo nuevo){
        Nodo r = inicio;
        if (listaVacia()){
            inicio = nuevo;
        } else{
            while(r.getNext() != null){
                r = r.getNext();
            }
            r.setNext(nuevo);
        }
    }

    /* Método que devuelve una cadena con los datos de todos
     * los nodos que tiene actualmente la lista*/
    
    public String toString() {
        Nodo r = inicio;
        String s = "";
        while (r != null) {
            s += r.toString() + "\n";
            r = r.getNext();
        }
        return s;
    }
    
    // FALTAN MUCHOS MÁS MÉTODOS
}
