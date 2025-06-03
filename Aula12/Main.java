import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDupla lista = new ListaDupla();
        int opcao;

        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. adicionar no final");
            System.out.println("2. adicionar no início");
            System.out.println("3. adicionar em posição específica");
            System.out.println("4. Remover do final");
            System.out.println("5. Remover do início");
            System.out.println("6. Remover de uma posição");
            System.out.println("7. Verificar se valor está na lista");
            System.out.println("8. Esvaziar lista");
            System.out.println("9. Exibir lista");
            System.out.println("10. Exibir tamanho");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir o Enter

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a adicionar no final: ");
                    lista.adicionar(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Digite o valor a adicionar no início: ");
                    lista.adicionarInicio(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Digite o valor: ");
                    String valor = sc.nextLine();
                    System.out.print("Digite a posição: ");
                    int pos = sc.nextInt();
                    sc.nextLine(); // consumir o Enter
                    lista.adicionarNaPosicao(pos, valor);
                    break;
                case 4:
                    lista.removerUltimo();
                    System.out.println("Removido do final.");
                    break;
                case 5:
                    lista.removerPrimeiro();
                    System.out.println("Removido do início.");
                    break;
                case 6:
                    System.out.print("Digite a posição a remover: ");
                    int posRem = sc.nextInt();
                    sc.nextLine();
                    lista.removerPosicao(posRem);
                    break;
                case 7:
                    System.out.print("Digite o valor a verificar: ");
                    String busca = sc.nextLine();
                    System.out.println("Está na lista? " + lista.contem(busca));
                    break;
                case 8:
                    lista.esvaziar();
                    System.out.println("Lista esvaziada.");
                    break;
                case 9:
                    lista.exibir();
                    break;
                case 10:
                    System.out.println("Tamanho da lista: " + lista.getTamanho());
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
