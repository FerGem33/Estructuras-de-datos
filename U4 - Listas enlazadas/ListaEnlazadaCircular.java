/* CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA CIRCULAR con 2 atributos:
*    - un apuntador al primer nodo (inicio)
*    - un apuntador al último nodo (fin)
*
*/

public class ListaEnlazadaCircular {
// Atributos 
private Nodo inicio;
private Nodo fin;

// Constructor (crea una lista vacía)
public ListaEnlazadaCircular () {  
    inicio = fin = null; 
}

// get...
public Nodo getInicio() { 
    return inicio;
}

public Nodo getFin() { 
    return fin;
}

// set...
public void setInicio (Nodo n) { 
    inicio = n;
}

public void setFin (Nodo n) { 
    fin = n;
}

// checar si la lista está vacía
public boolean listaVacia () {              
    return (inicio == null);
}

// inserta nodo al inicio de la lista
public void insertaInicio (Nodo nuevo) {
    if ( listaVacia ( ) ) {
        inicio = fin = nuevo;        
        nuevo.setNext (nuevo);
    }
     else {
        nuevo.setNext (inicio);
        inicio = nuevo; 
        fin.setNext (nuevo);
    }
 }

// toString
public String toString () {  
   String s = "";
    Nodo r = inicio; 
   if (listaVacia () )
      s += "Lista vacia";
   else {
       do {
          s += r.toString() + "\n";
          r = r.getNext();
       } while (r != inicio);
   }
   return s;
}

// faltan más métodos
}
