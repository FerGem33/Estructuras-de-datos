// Clase instanciable para manejar una Pila de números enteros

public class PilaLibro{
    // atributos  
     private Libro p[ ];     // vector para guardar datos de la pila
     private int tope;    // apuntador al último elemento de la pila

    // 1er. constructor, genera una pila de 5 casillas
    public PilaLibro ( ) {
       p = new Libro [5];     // se crea el vector (pila)
       tope  =  -1;          // pila está vacía, por lo que se inicializa el tope
    }

    // 2do. constructor, genera una pila de tamaño n
    public PilaLibro (int n) {
        p = new Libro [n];    // se crea el vector (pila) de n casillas
        tope =  -1;              // igual, se inicializa el tope
    }

     // get...
     public Libro[ ] getP ( ) {
        return p;
     }

     public int getTope ( ) {
        return tope;
     }

     // set...
     public void setP ( Libro [ ] nuevoP ) {
        p = nuevoP;
     }

     public void setTope ( int nuevoTope ) {
       tope = nuevoTope;
     }

     // inserta un elemento en la pila
     public void push ( Libro nuevo ) {
       if ( !isFull () ) {      // Se puede insertar si la pila NO está llena
           tope++;               // mueve el tope a la sig. casilla libre
          p[tope] = nuevo;     // guarda el dato en el tope de la pila
       }
     }

    // elimina un elemento de la pila
     public Libro pop ( ) {
       Libro borrado = new Libro();     //  variable para devolver el dato borrado ó -99999
       if ( !isEmpty () ) {     // Se puede eliminar si NO está vacía
          borrado = p[tope];      // se saca el dato del tope
          p[tope] = null;            // se borra físicamente la casilla            
          tope--;                 // se decrementa el tope
       }
       return borrado;           
     }

   // método que checa si la pila está vacía
   public boolean isEmpty ( ) {
      return (tope == - 1);    // devuelve true ó false si está VACÍA o NO
   }

   // método que checa si la pila está llena
   public boolean isFull ( ) {
     return ( tope == p.length - 1);   // devuelve true ó false si está LLENA o no
   }
     
   // devuelve el número de elementos que hay actualmente en la pila
   public int size ( )  {
      return tope + 1;
   }

   public String toString ( ) {
       String s = "";
       int i;
       for( i = tope; i >= 0; i--)  // recorre la pila del tope a la casilla 0
          s += "-------------\n" + p[i].toString()+ "\n";
       return s;
   }
}  // fin de la clase PilaInt

