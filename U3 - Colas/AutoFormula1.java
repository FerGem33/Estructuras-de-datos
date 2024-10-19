public class AutoFormula1 {
    private String piloto, escuderia;
    private int puntos;

    public AutoFormula1(String piloto, String escuderia, int puntos){
        this.piloto = piloto;
        this.escuderia = escuderia;
        this.puntos = puntos;
    }
    public String getPiloto(){
        return piloto;
    }
    public String getEscuderia(){
        return escuderia;
    }
    public int getPuntos(){
        return puntos;
    }
    public void setPiloto(String piloto){
        this.piloto = piloto;
    }
    public void setEscuderia(String escuderia){
        this.escuderia = escuderia;
    }
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
    public String toString(){
        return "Piloto: " + piloto + "\nEscudería: " + escuderia + "\nPuntos: " + puntos;
    }
}
