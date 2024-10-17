public class ColaString {
    private String c[];
    private int frente, fin;

    public ColaString(){
        c = new String[5];
        frente = 0;
        fin = -1;
    }
    public ColaString(int n){
        c = new String[n];
        frente = 0;
        fin = -1;
    }
    public String[] getC () {
        return c; 
     }
     
     public int getFrente () {
        return frente; 
     }
     
     public int getFin () {
        return fin; 
     }
     
     public void setC (String[] c) {
        this.c = c; 
     }
     
     public void setFrente (int frente) {
        this.frente = frente; 
     }
     
     public void setFin (int fin) {
        this.fin = fin; 
     }
     
     public void insertar (String x) {
        if ( !estaLlena ()) {
           fin++;
           c[fin] = x;
        }
     }
 
     public String eliminar( ){
        String borrado = "    ";
        if (!estaVacia()) {
           borrado = c [frente];
           c[frente] = null;
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
 
     public String datoEnFrente ( ) {
       if (estaVacia())
          return "   ";
       else
          return c[frente];
     }
     
     public String datoEnFin ( ) {
       if (estaVacia())
          return "   ";
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
