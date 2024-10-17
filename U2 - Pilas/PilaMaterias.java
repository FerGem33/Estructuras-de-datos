public class PilaMaterias{
    //  atributos
    private Materia[] p;
    private int tope;

    //  constructores
    public PilaMaterias(){
        p = new Materia[5];
        tope = -1;
    }
    public PilaMaterias(int n){
        p = new Materia[n];
        tope = -1;
    }

    // métodos get y set
    public Materia[] getP(){
        return p;
    }
    public void setP(Materia[] p){
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
    public void push(Materia x){
        if(!isFull()){
            p[++tope] = x;
        }
    }
    //  elimina un elemento
    public Materia pop(){
        Materia x = null;
        if(!isEmpty()){
            x = p[tope];
            p[tope--] = null;
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
}
