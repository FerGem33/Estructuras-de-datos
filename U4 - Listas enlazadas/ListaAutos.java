import java.util.Locale;
import java.text.Collator;

public class ListaAutos {
    private NodoAuto inicio;

    public ListaAutos(){
        inicio = null;
    }
    public NodoAuto getInicio(){
        return inicio;
    }
    public void setInicio(NodoAuto inicio){
        this.inicio = inicio;
    }
    public boolean listaVacia(){
        return inicio == null;
    }
    public void insertaInicio(NodoAuto nodo){
        nodo.setNext(inicio);
        inicio = nodo;
    }
    public void insertaFinal(NodoAuto nodo){
        if(listaVacia()){
            inicio = nodo;
        } else{
            NodoAuto i = inicio;
            while(i.getNext() != null){
                i = i.getNext();
            }
            i.setNext(nodo);
        }
    }
    public void insertaAlfabetiamente(NodoAuto nodo){
        if(listaVacia()){
            inicio = nodo;
        } else{
            Locale español = Locale.of("es");
            Collator comparador = Collator.getInstance(español);
            comparador.setStrength(Collator.PRIMARY);

            NodoAuto i = inicio, j = i.getNext();
            
            if (j == null){
                if(comparador.compare(nodo.getPropietario(), i.getPropietario()) >= 0){
                    i.setNext(nodo);
                }
            } else{
                if(comparador.compare(nodo.getPropietario(), i.getPropietario()) < 0){
                    insertaInicio(nodo);
                }
                do{
                    if(comparador.compare(nodo.getPropietario(), i.getPropietario()) >= 0
                        &&  comparador.compare(nodo.getPropietario(), j.getPropietario()) < 0){
                            nodo.setNext(j);
                            i.setNext(nodo);
                            return;
                        }
                    i = j;
                    j = j.getNext();
                } while(j != null);
                i.setNext(nodo); // insertaFinal(nodo);
            }    
        }
    }
    public NodoAuto eliminaPrimero(){
        NodoAuto borrado = inicio;
        if(!listaVacia()){
            inicio = inicio.getNext();
            borrado.setNext(null);
        }
        return borrado;
    }
    public NodoAuto eliminaUltimo(){
        if(listaVacia()){
            return null;
        }

        NodoAuto p = inicio;
        if(p.getNext() == null){
            inicio = null;
            return p;
        }

        NodoAuto u = p.getNext();
        do{
            p = u;
            u = u.getNext();
        } while(u.getNext() != null);
        p.setNext(null);
        return u;
    }
    public NodoAuto buscarPlaca(String placa){
        if(!listaVacia()){
            NodoAuto i = inicio;
            do{
                if(placa.equals(i.getPlaca())){
                    return i;
                }

                i = i.getNext();
            } while(i != null);
        }
        return null;
    }
    public NodoAuto eliminarPorPlaca(String placa){
        if(listaVacia()) return null;
        NodoAuto i = inicio, j = i.getNext();

        if(placa.compareToIgnoreCase(i.getPlaca()) == 0){
            inicio = j;
            i.setNext(null);
            return i;
        }
        do{
            if(placa.compareToIgnoreCase(j.getPlaca()) == 0){
                i.setNext(j.getNext());
                j.setNext(null);
                return j;
            }
           i = j;
           j = j.getNext();
        } while(j.getNext() != null);
        return null;
    }
    public NodoAuto buscarPropietario(String propietario){
        if(!listaVacia()){
            Locale español = Locale.of("es");
            Collator comparador = Collator.getInstance(español);
            comparador.setStrength(Collator.PRIMARY);

            NodoAuto i = inicio;
            do{
                if(comparador.compare(propietario, i.getPropietario()) == 0){
                    return i;    
                }

                i = i.getNext();
            } while(i != null);
        }
        return null;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        NodoAuto i = inicio;

        while(i != null){
            s.append(i.toString()).append("\n----------\n");
            i = i.getNext();
        }
        return s.toString();
    }
}
