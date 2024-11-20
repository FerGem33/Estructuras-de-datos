public class NodoAlumno {
    private Alumno alumno;
    private NodoAlumno next;

    public NodoAlumno() {
        this.alumno = null;
        this.next = null;
    }

    public NodoAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public NodoAlumno getNext() {
        return next;
    }

    public void setNext(NodoAlumno next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return alumno.toString();
    }
}
