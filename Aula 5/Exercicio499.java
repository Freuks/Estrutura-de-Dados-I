import javax.swing.JOptionPane;
import java.util.Arrays;

public class Exercicio499 {
    static int[] vetor = new int[5];
    static boolean dadosPreenchidos = false;

    public static void main(String[] args) {
        int op;
        do {
            String menu = "MENU VETOR - FUNCAO\n" +
                          "1 - Dados do VETOR\n" +
                          "2 - Ordena VETOR\n" +
                          "3 - Imprime VETOR\n" +
                          "4 - Sai do programa\n" +
                          "OPCAO:";
            
            String opcao = JOptionPane.showInputDialog(null, menu);
            op = Integer.parseInt(opcao);
            switch (op) {
                case 1:
                    entradaDados();
                    dadosPreenchidos = true;
                    break;
                case 2:
                    if (dadosPreenchidos) {
                        ordenaVetor();
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro opcao 1");
                    }
                    break;
                case 3:
                    if (dadosPreenchidos) {
                        imprimeVetor();
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro opcao 1");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo do algoritmo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
            }
        } while (op != 4);
    }
    static void entradaDados() {
        for (int i = 0; i < 5; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite numero " + (i + 1) + ": "));
        }
    }
    static void ordenaVetor() {
        Arrays.sort(vetor);
    }
    static void imprimeVetor() {
        StringBuilder sb = new StringBuilder("VETOR\n");
        for (int i = 0; i < 5; i++) {
            sb.append("\n").append(i + 1).append(" - ").append(vetor[i]);
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}