public class Materia{
    private String nombre, clave;
    private int creditos;

    public Materia(String nombre, int creditos, String clave){
        this.nombre = nombre;
        this.creditos = creditos;
        this.clave = clave;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCreditos(){
        return creditos;
    }
    public String getClave(){
        return clave;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCreditos(int creditos){
        this.creditos = creditos;
    }
    public void setClave(String clave){
        this.clave = clave;
    }
    public String toString(){
        return "Nombre: " + nombre + "\nCreditos: " + creditos + "\nClave: " + clave;
    }
}