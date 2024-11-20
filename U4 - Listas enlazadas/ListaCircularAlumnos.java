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

    public void insertarAlfabeticamente(NodoAlumno nodo){
        if(listaVacia()){
            // Si la lista está vacía...
            inicio = nodo;
            nodo.setNext(inicio);
            System.out.println("0");
        } else{
            Locale es = Locale.of("es");
            Collator collator = Collator.getInstance(es);
            collator.setStrength(Collator.PRIMARY);
            String nombre = nodo.getAlumno().getNombre();

            NodoAlumno i, j;
            i = inicio;
            j = i.getNext();

            if(i == j){
                // Si la lista tiene un único nodo...
                if(collator.compare(nombre, i.getAlumno().getNombre())  <= 0){
                    // Si nodo <= inicio
                    nodo.setNext(i);
                    i.setNext(nodo);
                    inicio = nodo;
                    System.out.println("1");
                } else{
                    // Si inicio < nodo
                    inicio.setNext(nodo);
                    nodo.setNext(inicio);
                    System.out.println("2");
                }
            } else{
                // Si la lista tiene múltiples nodos...

                if (collator.compare(nombre, i.getAlumno().getNombre()) <= 0) {
                    // Si nodo <= inicio
                    nodo.setNext(i);

                    fin = i;
                    while (fin.getNext() != inicio) {
                        fin = fin.getNext();
                    }
                    fin.setNext(nodo);

                    inicio = nodo;
                    System.out.println("3");
                }
                else {
                    do {
                        if (collator.compare(nombre, i.getAlumno().getNombre()) >= 0
                                && collator.compare(nombre, j.getAlumno().getNombre()) <= 0) {
                            // Si i < nodo < j ...
                            nodo.setNext(j);
                            i.setNext(nodo);
                            System.out.println("4");
                            return;
                        }

                        i = j;
                        j = j.getNext();
                    } while (j != inicio);
                    // Si fin < n ...
                    i.setNext(nodo);
                    nodo.setNext(inicio);
                    System.out.println("5");
                }
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
                s.append(i).append("\n------------------\n");
                i = i.getNext();
            } while (i != inicio);
        }
        return s.toString();
    }
}
