public class Equipo {
    private String nombre;
    private char division;
    private int numJugadores, puntos;
    private boolean clasifica;

    public Equipo(){
        numJugadores = puntos = 0;
        clasifica = false;
    }

    public Equipo(String nombre, char division, int numJugadores, int puntos){
        this.nombre = nombre;
        this.division = division;
        this.numJugadores = numJugadores;
        this.puntos = puntos;
        clasifica = puntos >= 15;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public char getDivision() {
        return division;
    }
    public void setDivision(char division) {
        this.division = division;
    }
    public int getNumJugadores() {
        return numJugadores;
    }
    public void setNumJugadores(int numJugadores) { 
        this.numJugadores = numJugadores;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public boolean getClasifica() {
        return clasifica;
    }
    public void setClasifica(boolean clasifica) {
        this.clasifica = clasifica;
    }
    public String toString(){
        return ("Nombre: " + nombre + "\nDivisión: " + division +
                "\nNúmero de jugadores: " + numJugadores + "\nPuntos: " + puntos +
                "\nClasifica: " + clasifica);
    }
}
