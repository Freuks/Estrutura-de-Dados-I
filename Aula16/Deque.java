public class Deque {
    No inicio;
    No fim;

    public Deque() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirInicio(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirFim(int valor) {
        No novo = new No(valor);
        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.anterior = fim;
            fim.proximo = novo;
            fim = novo;
        }
    }

    public void removerInicio() {
        if (inicio == null) {
            System.out.println("O Deque já está vazio.");
            return;
        }
        
        inicio = inicio.proximo;
        
        if (inicio == null) {
            fim = null;
        } else {
            inicio.anterior = null;
        }
    }

    public void removerFim() {
        if (fim == null) {
            System.out.println("O Deque já está vazio.");
            return;
        }

        fim = fim.anterior;

        if (fim == null) {
            inicio = null;
        } else {
            fim.proximo = null;
        }
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Deque vazio.");
            return;
        }
        
        No atual = inicio;
        System.out.print("Estado do Deque: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}