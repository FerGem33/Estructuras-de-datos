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
                if(comparador.compare(nodo.getPropietario(), i.getPropietario()) < 0){
                    insertaInicio(nodo);
                } else{
                    i.setNext(nodo);
                }
            } else{
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
