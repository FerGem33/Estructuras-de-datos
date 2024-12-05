/** Clase instanciable para manejar NODOS 
 * de un ARBOL BINARIO
 */

public class NodoArbolBin {
    
    private NodoArbolBin izquierdo; //apuntador al hijo izquierdo
    private int dato;               // nodo con UN dato entero
    private NodoArbolBin derecho;   //apuntador al hijo derecho
   
    // Constructor: Crea nodos hoja
    public NodoArbolBin ( int d ) { 
       dato = d;
       izquierdo = derecho = null;
    }
    
    // get...
    public int getDato ( ) { 
        return dato;
    }
    
    public NodoArbolBin getIzquierdo ( ) { 
        return izquierdo;
    }
    
    public NodoArbolBin getDerecho ( ) { 
        return derecho;
    }

    //  set..
    public void setDato (int nuevoD) { 
        dato = nuevoD;
    }   

    public void setIzquierdo ( NodoArbolBin nuevoIzq ) { 
        izquierdo = nuevoIzq;
    }
    
    public void setDerecho ( NodoArbolBin nuevoDer ) { 
         derecho = nuevoDer;
    } 
     
    // toString heredado de la clase Object
    public String toString() {
         return dato + "";
    }
    
     
}
