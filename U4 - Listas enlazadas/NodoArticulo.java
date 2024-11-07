import java.text.DecimalFormat;

public class NodoArticulo {
    private String descripcion;
    private int cantidad;
    private float precio;
    private NodoArticulo next;

    public NodoArticulo(){
        descripcion = "";
        cantidad = 0;
        precio = 0;
        next = null;
    }
    public NodoArticulo(String descripcion, int cantidad, float precio){
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        next = null;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public int getCantidad(){
        return cantidad;
    }
    public float getPrecio(){
        return precio;
    }
    public NodoArticulo getNext(){
        return next;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public void setNext(NodoArticulo next){
        this.next = next;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("$#.##");
        return "Descripción: " + descripcion + "\nCantidad: " + cantidad + "\nPrecio: " + df.format(precio);
    }
}
