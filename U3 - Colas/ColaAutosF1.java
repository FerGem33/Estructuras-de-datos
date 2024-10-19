public class ColaAutosF1{
    private AutoFormula1 c[];
    private int frente, fin;

    public ColaAutosF1(){
        c = new AutoFormula1[5];
        frente = 0;
        fin = -1;
    }
    public ColaAutosF1(int n){
        c = new AutoFormula1[n];
        frente = 0;
        fin = -1;
    }
    public AutoFormula1[] getC () {
        return c; 
     }
     
     public int getFrente () {
        return frente; 
     }
     
     public int getFin () {
        return fin; 
     }
     
     public void setC (AutoFormula1[] c) {
        this.c = c; 
     }
     
     public void setFrente (int frente) {
        this.frente = frente; 
     }
     
     public void setFin (int fin) {
        this.fin = fin; 
     }
     
     public void insertar (AutoFormula1 x) {
        if ( !estaLlena ()) {
           fin++;
           c[fin] = x;
        }
     }
 
     public AutoFormula1 eliminar( ){
        AutoFormula1 borrado = null;
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
 
     public AutoFormula1 datoEnFrente ( ) {
       if (estaVacia())
          return null;
       else
          return c[frente];
     }
     
     public AutoFormula1 datoEnFin ( ) {
       if (estaVacia())
          return null;
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