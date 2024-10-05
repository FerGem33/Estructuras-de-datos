public class PilaChar{
    //  atributos
    private char[] p;
    private int tope;

    //  constructores
    public PilaChar(){
        p = new char[5];
        tope = -1;
    }
    public PilaChar(int n){
        p = new char[n];
        tope = -1;
    }

    // métodos get y set
    public char[] getP(){
        return p;
    }
    public void setP(char[] p){
        this.p = p;
    }
    public int getTope(){
        return tope;
    }
    public void setTope(int tope){
        this.tope = tope;
    }

    //  métodos de pila

    //  inserta un elemento 
    public void push(char x){
        if(!isFull()){
            p[++tope] = x;
        }
    }
    //  elimina un elemento
    public char pop(){
        char x = '\uFFFF';
        if(!isEmpty()){
            x = p[tope];
            p[tope--] = '\0';
        }
        return x;
    }
    //  indica si la pila está vacía
    public boolean isEmpty(){
        return (tope == -1);
    }
    //  indica si la pila está llena
    public boolean isFull(){
        return (tope == p.length - 1);
    }
    //  devuelve el número de elementos que hay actualmente en la pila
    public int size(){
        return tope + 1;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i=tope; i >= 0; i--){
            s.append(p[i]).append('\n');
        }
        return s.toString();
    }
    //  indica si la pila contiene un carácter
    public boolean contains(char x){
        for(int i=tope; i >= 0; i--){
            if(x == p[i]){
                return true;
            }
        }
        return false;
    }
}