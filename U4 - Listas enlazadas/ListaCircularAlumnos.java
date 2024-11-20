import java.text.Collator;
import java.util.Locale;

public class ListaCircularAlumnos {
    private NodoAlumno inicio, fin;

    public ListaCircularAlumnos(){
        inicio = fin = null;
    }
    public ListaCircularAlumnos(NodoAlumno inicio){
        this.inicio = inicio;
        this.fin = inicio;
    }

    public NodoAlumno getInicio() {
        return inicio;
    }

    public void setInicio(NodoAlumno inicio) {
        this.inicio = inicio;
    }

    public NodoAlumno getFin() {
        return fin;
    }

    public void setFin(NodoAlumno fin) {
        this.fin = fin;
    }
    public boolean listaVacia(){
        return inicio == null;
    }

    public void insertaAlfabetiamente(NodoAlumno nodo){
        if(listaVacia()){
            inicio = nodo;
            nodo.setNext(inicio);
        } else{
            Locale es = Locale.of("es");
            Collator comparador = Collator.getInstance(es);
            comparador.setStrength(Collator.PRIMARY);

            NodoAlumno i = inicio, j = i.getNext();

            if (j == inicio){
                // Insertar después de inicio ( si inicio es el único nodo)
                if(comparador.compare(nodo.getAlumno().getNombre(), i.getAlumno().getNombre()) >= 0){
                    nodo.setNext(i.getNext());
                    i.setNext(nodo);
                }
            } else{
                // Insertar al inicio
                if(comparador.compare(nodo.getAlumno().getNombre(), i.getAlumno().getNombre()) < 0){
                    nodo.setNext(inicio);
                    inicio = nodo;
                }
                do{
                    // Insertar entre i y j
                    if(comparador.compare(nodo.getAlumno().getNombre(), i.getAlumno().getNombre()) >= 0
                            &&  comparador.compare(nodo.getAlumno().getNombre(), j.getAlumno().getNombre()) < 0){
                        nodo.setNext(j);
                        i.setNext(nodo);
                        return;
                    }
                    i = j;
                    j = j.getNext();
                } while(j != inicio);

                // Insertar al final
                nodo.setNext(inicio);
                i.setNext(nodo);
            }
        }
    }
    public float promedioCalif(){
        float prom = 0;
        int cuenta = 0;
        NodoAlumno i = inicio;

        do{
            for(float c : i.getAlumno().getCalif()){
                prom += c;
            }
            cuenta += 1;
            i = i.getNext();
        } while(i != inicio);
        prom /= (cuenta * 3);
        return prom;
    }

    public Alumno buscarAlumno(String nombre){
        if(!listaVacia()){
            Locale es = Locale.of("es");
            Collator comparador = Collator.getInstance(es);
            comparador.setStrength(Collator.PRIMARY);

            NodoAlumno i = inicio;
            do{
                if(comparador.compare(nombre, i.getAlumno().getNombre()) == 0){
                    return i.getAlumno();
                }
                i = i.getNext();
            } while(i != inicio);
        }
        return null;
    }

    public String toString(){
        NodoAlumno i = inicio;
        StringBuilder s = new StringBuilder();

        if(!listaVacia()){
            do {
                s.append(i).append("\n");
                i = i.getNext();
            } while (i != inicio);
        }

        return s.toString();
    }
}
