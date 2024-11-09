public class NodoAuto {
    private String placa, propietario;
    private int kilometraje;
    private NodoAuto next;

    public NodoAuto(){
        placa = "";
        propietario = "";
        kilometraje = 0;
        next = null;
    }
    public NodoAuto(String placa, String propietario, int kilometraje){
        this.placa = placa;
        this.propietario = propietario;
        this.kilometraje = kilometraje;
        next = null;
    }
    public String getPlaca(){
        return placa;
    }
    public String getPropietario(){
        return propietario;
    }
    public int getKilometraje(){
        return kilometraje;
    }
    public NodoAuto getNext(){
        return next;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public void setPropietario(String propietario){
        this.propietario = propietario;
    }
    public void setKilometraje(int kilometraje){
        this.kilometraje = kilometraje;
    }
    public void setNext(NodoAuto next){
        this.next = next;
    }
    public String toString(){
        return "Placa: " + placa + "\nPropietario: " + propietario + "\nKilometraje: " + kilometraje;
    }
}
