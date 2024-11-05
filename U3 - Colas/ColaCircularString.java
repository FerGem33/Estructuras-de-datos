/**
 *  Este programa sirve para trabajar con una estructura de datos de tipo 
 *
 *  COLA CIRCULAR
 *
 *  Utiliza 3 atributos:
 *  - el VECTOR de datos de tipo String
 *  - un APUNTADOR al inicio o frente (casilla del primer elemento en la fila)
 *  - un CONTADOR de datos ingresados (cuántos hay actualmente en fila)
 *
 **/

public class ColaCircularString {
    // ATRIBUTOS
    private String cc[ ];   // Este es el vector donde se guardan los datos
    private int frente;     // Apuntador al frente , YA NO SE NECESITA EL APUNTADOR DEL FINAL
    private int contador;   // Ahora el control se maneja a traves de un CONTADOR de datos ingresados

    // 1er Constructor crea una cola CIRCULAR de 5 casillas
    public ColaCircularString () {
       cc = new String[5];
       frente = 0;
       contador = 0;
    }

    // 2do Constructor crea una cola CIRCULAR con el numero de elementos que se recibe como parametro
    public ColaCircularString (int num) {
       cc = new String [num];
       frente = 0;
       contador = 0;
    }

    // getters
    public String[ ] getCc () {
        return cc;
    }

    public int getFrente () {
        return frente;
    }

    public int getContador () {
        return contador;
    }

    // setters
    public void setCc (String[] nuevoCc) {
        cc = nuevoCc;
    }

    public void setFrente (int nuevoFrente) {
        frente = nuevoFrente;
    }

    public void setContador (int nuevoCont) {
        contador = nuevoCont;
    }

    //Ahora cuando esta VACIA lo sabemos simplemente porque el CONTADOR de ingresados vale CERO
    public boolean estaVacia ()  {
      return (contador == 0);
    }

   // Y para checar si esta LLENA tambien lo podemos saber gracias al CONTADOR de ingresados
   // que se compara contra la cantidad de casillas que tiene el vector
    public boolean estaLlena()  {
      return  ( contador == cc.length);
    }

   // Devuelve el elemento del frente de la cola CIRCULAR. NO LO ELIMINA
    public String datoEnFrente () {
      if ( estaVacia() )
         return null;
      else
         return cc [frente];
    }

    // Devuelve el elemento del final de la cola CIRCULAR. NO LO ELIMINA
    public String datoEnFin () {
       if ( estaVacia() )
          return null;
       else
          return cc [(frente - 1 + contador) % cc.length];
    }

   // Devuelve la cantidad de elementos que hay actualmente en la cola CIRCULAR
    public int numElementos ( ) {
         return contador;
    }

   // Metodo para insertar un dato x
   public void insertar (String x) {
      if ( ! estaLlena () ) {                // solo podemos insertar si NO esta llena
         cc [(frente + contador) % cc.length] = x; // se calcula la posicion donde se insertara x
         contador++;                       // obviamente se incrementa el contador, ya que se inserto un elemento
      }
    }
    
   // Metodo para eliminar un dato, devuelve el elemento eliminado o null si no hay datos para borrar
   public String eliminar ( ) {
      String eliminado=null;
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
}   // fin de la clase ColaCircularString








