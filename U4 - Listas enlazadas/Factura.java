public class Factura{
    private int numero;
    private String cliente;
    private float saldo;

    public Factura(){
        numero = 0;
        cliente = "";
        saldo = 0;
    }
    public Factura(int numero, String cliente, float saldo){
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
    }
    public int getNumero(){
        return numero;
    }
    public String getCliente(){
        return cliente;
    }
    public float getSaldo(){
        return saldo;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public String toString(){
        return "Número: " + numero + "\nCliente: " + cliente + "\nSaldo: " + saldo; 
    }
}