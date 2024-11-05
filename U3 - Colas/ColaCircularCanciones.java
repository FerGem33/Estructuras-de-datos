public class ColaCircularCanciones {
    private Cancion[] cc;
    private int frente, contador;

    public ColaCircularCanciones() {
        cc = new Cancion[5];
        frente = 0;
        contador = 0;
    }
    public ColaCircularCanciones(int n) {
        cc = new Cancion[n];
        frente = 0;
        contador = 0;
    }

    public Cancion[] getCc () {
        return cc;
    }
    public int getFrente () {
        return frente;
    }
    public int getContador () {
        return contador;
    }
    public void setCc (Cancion[] cc) {
        this.cc = cc;
    }
    public void setFrente (int frente) {
        this.frente = frente;
    }
    public void setContador (int contador) {
        this.contador = contador;
    }

    public boolean estaVacia ()  {
        return (contador == 0);
    }
    public boolean estaLlena()  {
        return  ( contador == cc.length);
    }
    public Cancion datoEnFrente () {
        if ( estaVacia() )
           return null;
        else
           return cc [frente];
    }
    public Cancion datoEnFin () {
        if ( estaVacia() )
           return null;
        else
           return cc [(frente - 1 + contador) % cc.length];
    }
    public int numElementos ( ) {
        return contador;
   }
   public void insertar (Cancion x) {
    if ( ! estaLlena () ) {                // solo podemos insertar si NO esta llena
       cc [(frente + contador) % cc.length] = x; // se calcula la posicion donde se insertara x
       contador++;                       // obviamente se incrementa el contador, ya que se inserto un elemento
        }
    }
    public Cancion eliminar ( ) {
        Cancion eliminado = null;
        if ( ! estaVacia () ) {                  // solo podemos eliminar si NO esta vacia
           eliminado = cc[frente];               // Dato que se elimina y es el que se devuelve
           cc[frente] = null;                    // se anula el dato de la casilla
           frente = (frente + 1 ) % cc.length;   // se calcula la nueva posicion del frente
           contador--;                           // obviamente se decrementa el contador, ya que se elimino un elemento
        }    
        return eliminado;
    }
    public String toString() {
        String s="";
        int i= 1, indice = frente;   // se inicia a recorrer la fila circular desde el frente
  
         while (i <= contador) {    // ciclo que realiza "n" iteraciones (de acuerdo al contador de elementos)
           s+= cc[indice] + "\n";   // se accesa cada elemento con el indice (casilla)
           if (indice == cc.length - 1)   // si el indice esta en la ultima casilla,      
             indice = 0;                  // tiene que MOVERSE hasta la posicion 0
           else                         // si NO esta en la ultima casilla
             indice++;                  // simplemente se incrementa para pasar a la siguiente casilla
           i++;                // se incrementa i que controla la cantidad de iteraciones
         } 
         return s;
      } 
}
