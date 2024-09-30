import java.text.DecimalFormat;

public class Libro {
    private String titulo, autor;
    private float precio;
    DecimalFormat df = new DecimalFormat("$#.00");

    public Libro(){
        titulo = autor = "";
        precio = 0;
    }
    public Libro(String titulo, String autor, float precio){
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public float getPrecio(){
        return precio;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.titulo = autor;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public String toString(){
        return "Titulo: " + titulo +"\nAutor: " + autor + "\nPrecio: " + df.format(precio);
    }
}
