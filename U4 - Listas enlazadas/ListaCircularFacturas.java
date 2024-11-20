public class ListaCircularFacturas {
    private NodoFactura inicio, fin;

    public ListaCircularFacturas(){
        inicio = fin = null;
    }
    public NodoFactura getInicio(){
        return inicio;
    }
    public void setInicio(NodoFactura inicio){
        this.inicio = inicio;
    }
    public NodoFactura getFin(){
        return fin;
    }
    public void setFin(NodoFactura fin){
        this.fin = fin;
    }
    public boolean listaVacia(){
        return inicio == null;
    }
    public void insertaInicio(NodoFactura nodo){
        nodo.setNext(inicio);
        inicio = nodo;
    }
    public void insertaFinal(NodoFactura nodo){
        if(listaVacia()){
            inicio = nodo;
        } else{
            NodoFactura i = inicio;
            while(i.getNext() != null){
                i = i.getNext();
            }
            i.setNext(nodo);
        }
    }  
    public NodoFactura eliminaPrimero(){
        NodoFactura borrado = inicio;
        if(!listaVacia()){
            inicio = inicio.getNext();
            borrado.setNext(null);
        }
        return borrado;
    }
    public NodoFactura eliminaUltimo(){
        if(listaVacia()){
            return null;
        }

        NodoFactura p = inicio;
        if(p.getNext() == null){
            inicio = null;
            return p;
        }

        NodoFactura u = p.getNext();
        do{
            p = u;
            u = u.getNext();
        } while(u.getNext() != null);
        p.setNext(null);
        return u;
    }
}
