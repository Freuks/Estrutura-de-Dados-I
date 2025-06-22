public class Main {
    public static void main(String[] args) {
        Deque d = new Deque();

        d.inserirInicio(10);
        d.inserirFim(20);
        d.inserirInicio(5);
        d.inserirFim(30);

        System.out.println("Deque após todas as inserções:");
        d.exibir();

        d.removerInicio();
        System.out.println("\nDeque após remover do início:");
        d.exibir();

        d.removerFim();
        System.out.println("\nDeque após remover do fim:");
        d.exibir();
        
        d.removerInicio();
        d.removerFim();
        System.out.println("\nDeque após esvaziar:");
        d.exibir();
    }
}