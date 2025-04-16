import javax.swing.JOptionPane;

public class Exercicio500 {
    static int[] vetorA = new int[5];
    static int[] vetorB = new int[5];
    static boolean dadosA = false;
    static boolean dadosB = false;

    public static void main(String[] args) {
        int op;
        do {
            String menu = "VETORES\n" +
                         "1 - Dados do VETOR A\n" +
                         "2 - Dados do VETOR B\n" +
                         "3 - Imprime VETORES\n" +
                         "4 - Soma VETORES\n" +
                         "5 - Subtrai VETORES\n" +
                         "6 - Sai do programa\n" +
                         "OPCAO:";
            
            String opcao = JOptionPane.showInputDialog(null, menu);
            op = Integer.parseInt(opcao);

            switch (op) {
                case 1:
                    entradaDados(vetorA, "A");
                    dadosA = true;
                    break;
                case 2:
                    entradaDados(vetorB, "B");
                    dadosB = true;
                    break;
                case 3:
                    if (dadosA && dadosB) {
                        imprimeVetores();
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro opcoes 1 e 2");
                    }
                    break;
                case 4:
                    if (dadosA && dadosB) {
                        somaVetores();
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro opcoes 1 e 2");
                    }
                    break;
                case 5:
                    if (dadosA && dadosB) {
                        subtraiVetores();
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro opcoes 1 e 2");
                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo do Algoritmo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
            }
        } while (op != 6);
    }

    static void entradaDados(int[] vetor, String nome) {
        for (int i = 0; i < 5; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Entrada do VETOR " + nome + "\nDigite numero " + (i + 1) + ": "));
        }
    }

    static void imprimeVetores() {
        StringBuilder sb = new StringBuilder();
        sb.append("VETOR A\n");
        for (int i = 0; i < 5; i++) {
            sb.append(vetorA[i]).append("\n");
        }
        sb.append("\nVETOR B\n");
        for (int i = 0; i < 5; i++) {
            sb.append(vetorB[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    static void somaVetores() {
        StringBuilder sb = new StringBuilder("SOMA\n");
        for (int i = 0; i < 5; i++) {
            sb.append(vetorA[i] + vetorB[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    static void subtraiVetores() {
        StringBuilder sb = new StringBuilder("DIFERENCA\n");
        for (int i = 0; i < 5; i++) {
            sb.append(vetorA[i] - vetorB[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}