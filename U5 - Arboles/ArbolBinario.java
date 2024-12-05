/** Clase instanciable para manejar un 
 *  ÁRBOL BINARIO ORDENADO con el siguiente criterio:
 *  datos MENORES           (<)  a la IZQUIERDA y 
 *  datos MAYORES O IGUALES (>=) a la DERECHA
 */

public class ArbolBinario {
    
   // Atributo (solo la raíz del árbol)
   private NodoArbolBin raiz;
    
   // Constructor (crea un árbol binario vacío)
   public ArbolBinario ( ) { 
       raiz = null;
   }
   
   // get
   public NodoArbolBin getRaiz ( ) { 
        return raiz;
   }
   
   // set
   public void setRaiz ( NodoArbolBin nuevaRaiz ) { 
       raiz = nuevaRaiz;
   }
   
   // Método para determinar si el árbol está vacío
   public boolean estaVacio() {
      return ( raiz == null );
   }
   
   // Método PRINCIPAL para insertar un nodo en el árbol
   public void insertar ( NodoArbolBin nuevo) {
       if( estaVacio() ) //si el arbol esta vacio, crea la raiz con este nodo nuevo
           raiz = nuevo; 
       else              // si NO ESTÁ VACÍO, tendrá que buscar dónde insertarlo
           insertarAuxiliar(raiz, nuevo); // con un método RECURSIVO auxiliar
   }                                      // al que se envían la raíz y el nodo nuevo
   
   // Método AUXILIAR RECURSIVO para insertar nodos en este ABO
   // con el criterio de que datos < a la izquierda y >= a la derecha
   private void insertarAuxiliar (NodoArbolBin raiz, NodoArbolBin nuevo) {
      if ( nuevo.getDato() < raiz.getDato() ) {  // si el dato del nodo nuevo es 
                                                 // MENOR, se va a la izquierda
         if ( raiz.getIzquierdo() == null)  // si no tiene hijo izquierdo
             raiz.setIzquierdo (nuevo); // en esta posición inserta el nuevo nodo
         else         // cuando ya tiene hijo izquierdo, y no lo puede insertar
              // realiza una llamada RECURSIVA para pasar al siguiente nivel del árbol
             insertarAuxiliar (raiz.getIzquierdo(), nuevo); 
      }
      else {  // si el dato nuevo es MAYOR O IGUAL, se va a la derecha
          if (raiz.getDerecho() == null)  // si no tiene hijo derecho
              raiz.setDerecho (nuevo); // en esta posición inserta el nuevo nodo
          else   // cuando ya tiene hijo derecho, y no lo puede insertar
              // realiza una llamada RECURSIVA para pasar al siguiente nivel del árbol
              insertarAuxiliar (raiz.getDerecho(), nuevo); 
      } 
    
   }
   
   // devuelve un String con el recorrido PREORDEN del árbol
   public String preorden (NodoArbolBin nodo) { 
      if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
         return "";
      return nodo.getDato() +"\n"+ preorden(nodo.getIzquierdo()) +  preorden(nodo.getDerecho());
   }
   
   // devuelve un String con el recorrido INORDEN del árbol
   public String inorden (NodoArbolBin nodo) { 
      if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
         return "";
      return inorden(nodo.getIzquierdo()) + nodo.getDato() +"\n"+ inorden(nodo.getDerecho());
   }
   
   // devuelve un String con el recorrido POSTORDEN del árbol
   public String postorden (NodoArbolBin nodo) { 
       if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
          return "";
      return postorden(nodo.getIzquierdo()) + postorden(nodo.getDerecho()) + nodo.getDato() +"\n";
    }
    public int suma (NodoArbolBin nodo) {
        if (nodo == null)
            return Integer.MIN_VALUE;
        return nodo.getDato() + suma(nodo.getIzquierdo()) + suma(nodo.getDerecho());
    }

    public String hojas (NodoArbolBin nodo) {
        if (nodo == null) return "";
        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) return nodo.getDato() + " ";
        return  hojas(nodo.getIzquierdo()) + hojas(nodo.getDerecho());
    }
}