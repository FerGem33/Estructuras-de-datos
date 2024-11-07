import java.text.DecimalFormat;

public class ListaArticulos {
    private NodoArticulo inicio;

    public ListaArticulos () { 
        inicio = null; 
    }
    public NodoArticulo getInicio ( ) { 
        return inicio;
    }
    public void setInicio (NodoArticulo nuevoInicio) {
        inicio = nuevoInicio;
    }
    public boolean listaVacia() { 
        return (inicio == null);
    } 
    public void insertaInicio (NodoArticulo nuevo) {
        nuevo.setNext(inicio);
        inicio = nuevo;
    }
    public void insertarFinal(NodoArticulo nuevo){
        NodoArticulo r = inicio;
        if (listaVacia()){
            inicio = nuevo;
        } else{
            while(r.getNext() != null){
                r = r.getNext();
            }
            r.setNext(nuevo);
        }
    }
    public float inventarioTotal(){
        NodoArticulo r = inicio;
        float s = 0;
        while(r != null){
            s += r.getPrecio() * r.getCantidad();
            r = r.getNext();
        }
        return s;
    }
    public String articulosMayoresQue(float x){
        StringBuilder s = new StringBuilder();
        DecimalFormat df = new DecimalFormat("$#.##");
        NodoArticulo r = inicio;

        while(r != null){
            if(r.getPrecio() > x){
                s.append(r.getDescripcion()).append(" : ")
                .append(df.format(r.getPrecio())).append('\n');
            }
            r = r.getNext();
        }
        return s.toString();
    }
    public String max(){
        NodoArticulo max = inicio, r = inicio;
        while(r != null){
            if(r.getPrecio() > max.getPrecio()){
                max = r;
            }
            r = r.getNext();
        }
        return max.toString();
    }
    public String toString() {
        NodoArticulo r = inicio;
        StringBuilder s = new StringBuilder();
        while (r != null) {
            s.append(r.toString()).append('\n');
            r = r.getNext();
        }
        return s.toString();
    }
}