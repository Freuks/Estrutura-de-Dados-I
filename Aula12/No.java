public class No{
    String valor;
    No proximo;
    No anterior;

    public No(String valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}