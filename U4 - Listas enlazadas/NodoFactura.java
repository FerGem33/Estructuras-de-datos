public class NodoFactura{
    private Factura factura;
    private NodoFactura next;

    public NodoFactura(){
        factura = null;
        next = null;
    }
    public NodoFactura(Factura factura){
        this.factura = factura;
        next = null;
    }
    public Factura getFactura(){
        return factura;
    }
    public NodoFactura getNext(){
        return next;
    }
    public void setFactura(Factura factura){
        this.factura = factura;
    }
    public void setNext(NodoFactura next){
        this.next = next;
    }
    public String toString(){
        return factura.toString();
    }
}
