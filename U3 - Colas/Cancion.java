public class Cancion {
    private String titulo, interprete;

    public Cancion(String titulo, String interprete){
        this.titulo = titulo;
        this.interprete = interprete;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getInterprete(){
        return interprete;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setInterprete(String interprete){
        this.interprete = interprete;
    }
    public String toString(){
        return "Titulo: "+ titulo + "\nInterprete: " + interprete;
    }
}
