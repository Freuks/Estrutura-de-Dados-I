public class ListaDupla {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionar(String valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        tamanho++;
    }

    public void adicionarInicio(String valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
    }

    public void adicionarNaPosicao(int posicao, String valor) {
        if (posicao <= 0) {
            adicionarInicio(valor);
        } else if (posicao >= tamanho) {
            adicionar(valor);
        } else {
            No atual = inicio;
            for (int i = 0; i < posicao; i++) {
                atual = atual.proximo;
            }
            No novo = new No(valor);
            novo.anterior = atual.anterior;
            novo.proximo = atual;
            atual.anterior.proximo = novo;
            atual.anterior = novo;
            tamanho++;
        }
    }

    public void removerUltimo() {
        if (fim != null) {
            if (fim.anterior != null) {
                fim = fim.anterior;
                fim.proximo = null;
            } else {
                inicio = fim = null;
            }
            tamanho--;
        }
    }

    public void removerPrimeiro() {
        if (inicio != null) {
            if (inicio.proximo != null) {
                inicio = inicio.proximo;
                inicio.anterior = null;
            } else {
                inicio = fim = null;
            }
            tamanho--;
        }
    }

    public void removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return;
        if (posicao == 0) {
            removerPrimeiro();
        } else if (posicao == tamanho - 1) {
            removerUltimo();
        } else {
            No atual = inicio;
            for (int i = 0; i < posicao; i++) {
                atual = atual.proximo;
            }
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
            tamanho--;
        }
    }

    public boolean contem(String valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) return true;
            atual = atual.proximo;
        }
        return false;
    }

    public void esvaziar() {
        inicio = fim = null;
        tamanho = 0;
    }

    public void exibir() {
        No atual = inicio;
        System.out.print("[");
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.proximo != null) {
                System.out.print(", ");
            }
            atual = atual.proximo;
        }
        System.out.println("]");
    }

    public int getTamanho() {
        return tamanho;
    }
}
