public class DoblePila {
    private int p[];
    private int tope1, tope2;

    public DoblePila(int n){
        p = new int[n];
        tope1 = -1;
        tope2 = n;
    }
    public void pushPila1(int x){
        if(!isFullPila1()){
            p[++tope1] = x;
        }
    }
    public void pushPila2(int x){
        if(!isFullPila2()){
            p[--tope2] = x;
        }
    }
    public int popPila1(){
        int borrado = -99999;
        if(!isEmptyPila1()){
            borrado = p[tope1];
            p[tope1--] = 0;
        }
        return borrado;
    }
    public int popPila2(){
        int borrado = -99999;
        if(!isEmptyPila2()){
            borrado = p[tope2];
            p[tope2++] = 0;
        }
        return borrado;
    }
    public boolean isEmptyPila1(){
        return tope1 == -1;
    }
    public boolean isEmptyPila2(){
        return tope2 == p.length;
    }
    public boolean isFullPila1(){
        return tope1 == p.length/2 - 1;
    }
    public boolean isFullPila2(){
        return tope2 == p.length/2;
    }
    public int sizePila1(){
        return tope1 + 1;
    }
    public int sizePila2(){
        return p.length - tope2;
    }
    public String toStringPila1(){
        StringBuilder s = new StringBuilder();
        for(int i=tope1; i >= 0; i--){
            System.out.println(i + ", " + p.length);
            s.append(p[i]).append('\n');
        }
        return s.toString();
    }
    public String toStringPila2(){
        StringBuilder s = new StringBuilder();
        for(int i=tope2; i < p.length; i++){
            System.out.println(i + ", " + p.length);
            s.append(p[i]).append('\n');
        }
        return s.toString();
    }
}
