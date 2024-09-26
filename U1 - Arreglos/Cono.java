public class Cono{
    private float radio, altura;

    public Cono(){
        radio = altura = 0;
    }
    public Cono(float radio, float altura){
        this.radio = radio;
        this.altura = altura;
    }

    public float getRadio(){
        return radio;
    }
    public void setRadio(float radio){
        this.radio = radio;
    }
    public float getAltura(){
        return altura;
    }
    public void setAltura(float altura){
        this.altura = altura;
    }

    public float areaBase(){
        return  (float) (Math.PI * Math.pow(radio, 2)); 
    }
    public float volumen(){
        return (areaBase() * altura) / 3;
    }

    public String toString(){
        return "Radio: " + radio + "\nAltura: " + altura + 
        "\nÁrea de la base: " + areaBase() + "\nVolúmen " + volumen();
    }
}