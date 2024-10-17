/* Clase instanciable para manejar una estructura de datos
*  COLA LINEAL SIMPLE con memoria estática: 
*  1 vector y 2 apuntadores al inicio y fin de la misma
*/ 

public class ColaInt {
    // 3 atributos
    private int c[];          // Vector de enteros
    private int frente,fin;   // 2 Apuntadores para el frente y final de la fila

    public ColaInt ( ) {
      c = new int[5];
      frente = 0;
      fin = -1;
    }

    public ColaInt (int n) {
      c = new int[n];
      frente = 0;
      fin = -1;
    }

    public int[] getC () {
       return c; 
    }
    
    public int getFrente () {
       return frente; 
    }
    
    public int getFin () {
       return fin; 
    }
    
    public void setC (int[] nuevoC) {
       c = nuevoC; 
    }
    
    public void setFrente (int nuevoFrente) {
       frente = nuevoFrente; 
    }
    
    public void setFin (int nuevoFin) {
       fin = nuevoFin; 
    }
    
    public void insertar (int x) {
       if ( !estaLlena ()) {
          fin++;
          c[fin] = x;
       }
    }

    public int eliminar( ){
       int borrado = -9999;
       if (!estaVacia()) {
          borrado = c [frente];
          c[frente] = 0;
          frente++;
          if (estaVacia()) {  // si al eliminar, la cola queda VACÍA,
            frente=0;         // se REINICIAN los apuntadores para 
            fin= -1;          // recuperar las casillas desperdiciadas
          }
       }
       return borrado;
    }

    public boolean estaVacia ( )  {
       return  (frente > fin);
    }

    public boolean estaLlena( )  {
       return (fin == c.length - 1);
    }

    public int numElementos( ) {
        return (fin - frente + 1);
    }

    public int datoEnFrente ( ) {
      if (estaVacia())
         return -9999;
      else
         return c[frente];
    }
    
    public int datoEnFin ( ) {
      if (estaVacia())
         return -9999;
      else
         return c[fin];
    }

    public String toString( ) {
       String s="";
       for (int i = frente; i <= fin; i++)
          s += c[i]+"\n";
       return s;
    }
}
