import java.util.Arrays;

public class Alumno {
    private int numControl;
    private String nombre;
    private float[] calif;

    public Alumno(){
        numControl = 0;
        nombre = "";
        calif = null;
    }
    public Alumno(int numControl, String nombre, float[] calif) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.calif = calif;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float[] getCalif() {
        return calif;
    }

    public void setCalif(float[] calif) {
        this.calif = calif;
    }

    @Override
    public String toString() {
        return "Número de control: " + numControl +
                "\nNombre: " + nombre + "\nCalificaciones: " + Arrays.toString(calif);
    }
}
