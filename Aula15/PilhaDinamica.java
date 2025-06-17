

import java.util.EmptyStackException;

public class PilhaDinamica {
    private No topo;

    public PilhaDinamica() {
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(char caractere) {
        No novoNo = new No(caractere);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        char caractere = topo.caractere;
        topo = topo.proximo;
        return caractere;
    }
}