/** CLASE INSTANCIABLE PARA MANEJAR UN nodo con 2 datos:
- dato1 (String)
- dato2 (int)
- next (apuntador o enlace que guarda la dirección del siguiente nodo) */

public class Nodo {

    // 3 atributos: los 2 datos y la liga o enlace al siguiente nodo    
    private String dato1; 
    private int dato2; 
    private Nodo next;  // Este apuntador SIEMPRE será del mismo tipo 
                        // de la clase que lo contiene, porque guarda
                        // la dirección de memoria del siguiente nodo

    // 1er. Constructor, crea un nodo con datos vacíos
    public Nodo () {
        dato1 = "";
        dato2 = 0;
        next = null; 
    }

    /* 2do. Constructor, recibe como parámetros los 2 datos, 
    el enlace NO se recibe, se pone en null porque cada nodo
    nuevo es independiente y está DESCONECTADO de la lista  */
    public Nodo (String d1, int d2) {
        dato1 = d1; 
        dato2 = d2; 
        next = null;
    }

    // Métodos get...
    public String getDato1(){ 
        return dato1;
    }

    public int getDato2 () { 
        return dato2;
    }
    
    public Nodo getNext (){ 
        return next;
    }
    
    // Métodos set...
    public void setDato1 (String nuevoD1) { 
        dato1 = nuevoD1;
    }
        
    public void setDato2 (int nuevoD2) { 
        dato2 = nuevoD2;
    }
    
    public void setNext(Nodo nuevoN) { 
        next = nuevoN;
    }

    /* Método toString
    Solamente se devuelven los datos, NO el enlace, 
    ya que es una dirección de memoria para ligar nodos,
    NO es un dato que deba ver el usuario.*/
    public String toString( ) { 
        return dato1 + "   " + dato2;
    }
    
} // fin de la clase Nodo