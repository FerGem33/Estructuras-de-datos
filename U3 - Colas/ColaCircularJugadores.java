public class ColaCircularJugadores {
    private Jugador[] cc;
    private int frente, contador;

    public ColaCircularJugadores() {
        cc = new Jugador[5];
        frente = 0;
        contador = 0;
    }
    public ColaCircularJugadores(int n) {
        cc = new Jugador[n];
        frente = 0;
        contador = 0;
    }

    public Jugador[] getCc () {
        return cc;
    }
    public int getFrente () {
        return frente;
    }
    public int getContador () {
        return contador;
    }
    public void setCc (Jugador[] cc) {
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
    public Jugador datoEnFrente () {
        if ( estaVacia() )
            return null;
        else
            return cc [frente];
    }
    public Jugador datoEnFin () {
        if ( estaVacia() )
            return null;
        else
            return cc [(frente - 1 + contador) % cc.length];
    }
    public int numElementos ( ) {
        return contador;
    }
    public void insertar (Jugador x) {
        if ( ! estaLlena () ) {
            cc [(frente + contador) % cc.length] = x;
            contador++;
        }
    }
    public Jugador eliminar ( ) {
        Jugador eliminado = null;
        if ( ! estaVacia () ) {
            eliminado = cc[frente];
            cc[frente] = null;
            frente = (frente + 1 ) % cc.length;
            contador--;
        }
        return eliminado;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        int i= 1, indice = frente;
        while (i <= contador) {
            s.append(cc[indice]).append('\n');
            if (indice == cc.length - 1)
                indice = 0;
            else
                indice++;
            i++;
        }
        return s.toString();
    }
}
